import java.util.*;
public class Analyseur2 implements Analyseurs{
    public List<MotOcc> analyser (List<String> listeMots){
        List<MotOcc> liste=new ArrayList<>();
        for(int i=0;i<listeMots.size();i++){
            String mot=listeMots.get(i);
            int compt=0;
            for(int j=0;j<listeMots.size();j++){
                if(listeMots.get(j).equals(mot)){
                    compt++;
                }
            }
            liste.add(new MotOcc(mot,compt));
        }
        return liste;

    }
}
