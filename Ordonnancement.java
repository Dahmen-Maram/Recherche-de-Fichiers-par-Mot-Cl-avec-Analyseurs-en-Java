import java.io.IOException;
import java.util.List;

public interface Ordonnancement {
    public List<Score> calculer_score(List<DocMotStat> liste) throws IOException;
}
