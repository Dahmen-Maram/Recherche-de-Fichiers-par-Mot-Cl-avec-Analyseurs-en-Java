import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ordonnanceur1 implements Ordonnancement{

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
                int nbMotTot= lecteur.lire(chemin).size();
                for (int j=0;j< liste.size();j++){
                    Document doc1=liste.get(j).getDoc();
                    if(doc1.getChemin().equals(chemin)){
                        compt+=liste.get(j).getNbOcc();
                    }
                }
                Score couple =new Score(doc,compt/nbMotTot);
                score.add(couple);
            }
            return score;



        }
    }


