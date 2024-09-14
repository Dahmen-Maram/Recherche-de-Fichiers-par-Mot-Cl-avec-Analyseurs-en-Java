import java.util.List;

public interface Indexation {
    public void indexer(List<MotOcc> liste, String chemin);
    public List<DocMotStat> getStat(String requete);
}
