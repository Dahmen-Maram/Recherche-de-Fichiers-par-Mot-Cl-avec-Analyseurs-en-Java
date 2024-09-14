import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Index implements Indexation {
    public List<DocMotStat> triplet;
    public Index(){
        triplet= new ArrayList<>();
    }
    public void indexer(List<MotOcc>liste, String chemin){
        Document doc=new Document(chemin,".txt");
        for(int i=0;i<liste.size();i++){
            DocMotStat t=new DocMotStat(liste.get(i).getMot(), liste.get(i).getNbOcc(), doc);
            triplet.add(t);
        }


    }
    public List<DocMotStat> getStat(String requete){
        List<String > motsReq=new ArrayList<>();
        List<DocMotStat> motsReqStats=new ArrayList<>();
        List<String> motsReq1=new ArrayList<>();
        motsReq1=(asList(requete.split(" ")));
        
        for(String mot: motsReq1){
            motsReq.add(mot.toLowerCase());
        }

        for(String mot: motsReq){
            Set<Document> docSet=new HashSet<>();
            for(DocMotStat dms: this.triplet){
            if((mot.equals(dms.getMot()))&&(!docSet.contains(dms.getDoc()))){
                motsReqStats.add(dms);
                docSet.add(dms.getDoc());
            }
        }
    }
        Set<DocMotStat> set=new HashSet<>();
        set.addAll(motsReqStats);
        motsReqStats.clear();
        motsReqStats.addAll(set);
        return motsReqStats;
}

    public List<DocMotStat> getTriplet(){
        return this.triplet;
    }
}