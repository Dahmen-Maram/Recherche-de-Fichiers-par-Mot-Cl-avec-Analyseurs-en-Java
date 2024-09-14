import java.io.File;

public class Document {
    String chemin;
    String type;
    public Document(String chemin, String type) throws IllegalArgumentException {
        File fichier = new File(chemin);
        if (fichier.exists()) {
            this.chemin = chemin;
            this.type = type;
        } else {
            throw new IllegalArgumentException("Le chemin n'existe pas !!!!!!!");
        }
    }
    public String getChemin(){
        return this.chemin;
    }

    public String getType() {
        return type;
    }

    /*@Override
    public boolean equals(Document otherDoc) {
        return(this.chemin.equals(otherDoc.getChemin())) ;
    }*/
}