public class Couple {
    String mot;
    Document f;
    public Couple(String mot,Document doc){
        this.mot=mot;
        this.f=doc;
    }
    public Document getDoc(){
        return this.f;
    }
    public String getMot(){
        return this.mot;
    }

}
