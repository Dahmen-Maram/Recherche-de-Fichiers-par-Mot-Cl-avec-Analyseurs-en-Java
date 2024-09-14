import java.util.ArrayList;
import java.util.List;

class Traiteur1 extends Traiteur{
    public List<String> nettoyer(List<String> listeMots){
        List<String> nouvelleListe=new ArrayList<>();

        for(int i=0;i<listeMots.size();i++){
            nouvelleListe.add(listeMots.get(i).toLowerCase());
        }
        return nouvelleListe;
    }
    
    
}