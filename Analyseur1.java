import java.util.*;

public class Analyseur1 implements Analyseurs {
    public List <MotOcc> analyser(List<String> listeMots) {
        Map<String, Integer> mapp = new HashMap<>();
        List<MotOcc> liste=new ArrayList<>();
        for (int i = 0; i < listeMots.size(); i++) {
            String mot = listeMots.get(i);
            int compt = 0;
            for (int j = 0; j < listeMots.size(); j++) {
                if (listeMots.get(j).equals(mot)) {
                    compt++;
                }
            }
            mapp.put(mot, compt);
        }
        for(int i=0;i<mapp.keySet().size();i++){
            Set<String> keys=mapp.keySet();
            for(String key:keys){
                MotOcc couple=new MotOcc(key,mapp.get(key));
                liste.add(couple);
            }



        }

        return liste;
    }
}
