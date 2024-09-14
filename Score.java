public class Score {
    Document doc;
    double nbreOcc;
    public Score(Document doc,double nbreOcc){
        this.doc=doc;
        this.nbreOcc=nbreOcc;
    }
    public Document getDoc(){
        return this.doc;
    }
    public double getNbreOcc(){
        return this.nbreOcc;
    }
}
