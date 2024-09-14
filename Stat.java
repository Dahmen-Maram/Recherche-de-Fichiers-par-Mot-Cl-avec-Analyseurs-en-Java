import java.io.IOException;
import java.util.List;

public class Stat {
    String mot;
    int nbre_occ;
    Document doc;
    public Stat(String mot,int nbre_occ,Document doc){
        this.mot=mot;
        this.nbre_occ=nbre_occ;
        this.doc=new Document(doc.chemin, doc.type);
    }
    /*public double getStat(String mot) throws IOException {
        Lecteur lecteur=new Lecteur();
        Traiteur traiteur=new Traiteur();
        List<String> listeLignes=lecteur.lire(this.doc.chemin);
        List<String>listeMots1=traiteur.nettoyer(listeLignes);
        return (this.nbre_occ/listeMots1.size())*100;

    }*/
}
