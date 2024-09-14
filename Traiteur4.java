import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Traiteur4 extends Traiteur {
    public List<String> nettoyer (List<String> listeMots){
        List<String> nouvelleListe=new ArrayList<>();
        HashSet<String> parasites=new HashSet<>();
        parasites.add("0");
        parasites.add("1");
        parasites.add("2");
        parasites.add("3");
        parasites.add("4");
        parasites.add("5");
        parasites.add("6");
        parasites.add("7");
        parasites.add("8");
        parasites.add("9");
        for(int i=0;i<listeMots.size();i++){
            for(int j=0;j<(listeMots.get(i)).length();j++){
                String mot="";
                if(!parasites.contains((listeMots.get(i)).charAt(j))){
                    mot+=(listeMots.get(i)).charAt(j);
                }
                nouvelleListe.add(mot);


            }
        }
        return nouvelleListe;
    }
}