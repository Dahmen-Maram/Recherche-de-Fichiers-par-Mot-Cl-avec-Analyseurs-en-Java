import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Traiteur3 extends Traiteur {
    @Override
    public  List<String> nettoyer (List<String> listeMots){
        List<String> nouvelleListe=new ArrayList<>();
        HashSet<String> parasites=new HashSet<>();
        parasites.add(".");
        parasites.add(",");
        parasites.add(";");
        parasites.add(":");
        parasites.add("!");
        parasites.add("?");
        for(int i=0;i<listeMots.size();i++){
            String mot="";
            for(int j=0;j<listeMots.get(i).length();j++){
                if(!parasites.contains((listeMots.get(i).charAt(j)))){
                    mot+=(listeMots.get(i)).charAt(j);
                }
            }
            nouvelleListe.add(mot);
        }
        return nouvelleListe;
    }
}


