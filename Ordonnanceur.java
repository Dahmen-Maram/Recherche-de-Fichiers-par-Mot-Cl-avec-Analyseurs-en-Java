import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ordonnanceur implements Ordonnancement {
    public List<Score> calculer_score(List<DocMotStat> liste) throws IOException {
        List<Score> score=new ArrayList<>();
        Lecteur lecteur=new Lecteur();
        Set<String> unique=new HashSet<>();
        for (int i=0;i< liste.size();i++){
            Document doc=liste.get(i).getDoc();
            unique.add(doc.getChemin());}
        for (String chemin: unique){
            int compt=0;
            Document doc=new Document(chemin,".txt");
            for (int j=0;j< liste.size();j++){
                Document doc1=liste.get(j).getDoc();
                if(doc1.getChemin().equals(chemin)){
                    compt+=liste.get(j).getNbOcc();
                    }
                }
            Score couple =new Score(doc,compt);
            score.add(couple);
        }
        Collections.sort(score, Comparator.comparingDouble(Score::getNbreOcc).reversed());
        return score;



    }
}
