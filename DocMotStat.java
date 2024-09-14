import javax.print.Doc;

public class DocMotStat {
    private String mot;
    private int nbOcc;
    private Document doc;
    public DocMotStat(String mot,int nbOcc,Document doc){
        this.mot=mot;
        this.nbOcc=nbOcc;
        this.doc=doc;
    }
    public String getMot(){
        return mot;
    }
    public int getNbOcc(){
        return nbOcc;
    }
    public Document getDoc(){
        return doc;
    }
}
