import java.util.*;
import static java.util.Arrays.asList;

 class Index2 implements Indexation {
    public Map<String,List<DocOcc>> triplet;
    public Index2(){
        triplet=new HashMap<>();
    }
    public void indexer(List<MotOcc>liste, String chemin){
        Document doc=new Document(chemin,".txt");
        for(int i=0;i<liste.size();i++){
            String mot=liste.get(i).getMot();
            int occ=liste.get(i).getNbOcc();
            DocOcc couple=new DocOcc(doc,occ);
            if(triplet.containsKey(mot)){
                List<DocOcc> aux=new ArrayList<>();
                aux=triplet.get(mot);
                aux.add(couple);
                triplet.put(mot,aux);
            }else{
                List<DocOcc> coupleList=new ArrayList<DocOcc>();
                coupleList.add(couple);
                triplet.put(mot,coupleList);
            }
        }
    }
    public List<DocMotStat> getStat(String requete){
        List<String > motsReq1=new ArrayList<>();
        List<DocMotStat>resReq=new ArrayList<>();
        List<String > motsReq=new ArrayList<>();
        motsReq1=(asList(requete.split(" ")));
        for(String mot: motsReq1){
            motsReq.add(mot.toLowerCase());
        }
        for(int i=0;i<motsReq.size();i++){
            String mot=motsReq.get(i);
            if(triplet.containsKey(mot)){
                List<DocOcc> liste =triplet.get(mot);
                Set<Document> setDoc=new HashSet<>();
                for(int j=0;j<liste.size();j++){
                    Document doc=liste.get(j).getDoc();
                    if(!setDoc.contains(doc)) {
                        setDoc.add(doc);
                        int nbre_occ = liste.get(j).getOcc();

                        DocMotStat triplett = new DocMotStat(mot, nbre_occ, doc);
                        resReq.add(triplett);
                    }
                }
            }
        }
        Set<DocMotStat> set=new HashSet<>();
        set.addAll(resReq);
        resReq.clear();
        resReq.addAll(set);
        return resReq;
    }
}
