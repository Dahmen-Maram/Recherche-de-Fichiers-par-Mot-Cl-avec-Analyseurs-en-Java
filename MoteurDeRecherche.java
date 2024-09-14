import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class MoteurDeRecherche {
    private Document doc ;
    private Indexation index;
    private Lecteur lecteur;
    private List<Traiteur> traiteurs;
    //private List<Document> results;

    private Analyseurs analyseur;
    private Ordonnancement ordonnanceur;
    //Constructeur par défaut du moteur de recherche :
    public MoteurDeRecherche(Document f,List<Traiteur> traiteurs,Analyseurs choixAnalyseur,Indexation choixIndexeur,Ordonnancement choixOrdonnanceur){
        this.doc=new Document(f.getChemin(),f.getType());
        this.index=choixIndexeur;
        this.lecteur=new Lecteur();
        this.traiteurs=traiteurs;
        this.analyseur=choixAnalyseur;
        this.ordonnanceur=choixOrdonnanceur;
    }
    //constructeur avant les choix de l'utilisateur :
    /*public MoteurDeRecherche(Traiteur choixTraiteur,Analyseurs choixAnalyseur,Indexation choixIndexeur){
        this.index=choixIndexeur;
        this.lecteur=new Lecteur();
        this.traiteur=choixTraiteur;
        this.analyseur=choixAnalyseur;
    }*/
    public List<Document> indexSingleDoc(String req) throws IOException{
        List<String> lecture = this.lecteur.lire(this.doc.getChemin());
        List<String> liste_traiteurs = new ArrayList<>();
        for (Traiteur traiteur : traiteurs) {
            liste_traiteurs.addAll(traiteur.nettoyer(lecture));
        }
        List<MotOcc> liste = this.analyseur.analyser(liste_traiteurs);
        this.index.indexer(liste, doc.getChemin());
        List<DocMotStat> dms = this.index.getStat(req);
        List<Document> liste_finale = new ArrayList<>();
        for (DocMotStat triplet : dms) {
            liste_finale.add(triplet.getDoc());
        }
        Set<Document> set = new HashSet<>();
        set.addAll(liste_finale);
        liste_finale.clear();
        liste_finale.addAll(set);
        set.clear();
        return liste_finale;
    }
    public String test(String path){
        File filePath = Paths.get(path).toFile();
        if(filePath.exists()){
            if(filePath.isDirectory()){
                //System.out.println(path+" is a directory");

                return ("dir");
            }else{
                //System.out.println(path+" is a file");
                //indexSingleDocument(path);
                return ("file");

            }
        }else{
            //System.out.println(path+" does not exist");
            return ("inex");
        }

    }



   /* public void indexSingleDocument(String path){
        System.out.println(path);
    }*/

    public  List<Document>   indexDirectory(String path,String req)throws IOException{
        List<Document> results=new ArrayList();
        File pathFile = Paths.get(path).toFile();
        File[] files = pathFile.listFiles();
        for(File f: files ){
            if(f.isDirectory()){
                results.addAll(indexDirectory(f.getAbsolutePath(),req));
                //test(f.getAbsolutePath());
            }else{
                //test(f.getAbsolutePath());
                //indexSingleDocument(f.getAbsolutePath());
                this.doc=new Document(f.getAbsolutePath(),".txt");
                results.addAll(indexSingleDoc(req));
            }
        }
        Set<Document> set=new HashSet<>();
        set.addAll(results);
        results.clear();
        results.addAll(set);
        set.clear();
        return results;
    }
}
