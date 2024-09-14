import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Lecteur {
    public List<String> lire(String chemin) throws IOException {
        List<String> contenu = new ArrayList<String>();//liste des lignes

        FileReader fileReader = new FileReader(chemin);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String ligne;
        try {
            while ((ligne = bufferedReader.readLine()) != null) {
                contenu.add(ligne);
            }
            /*for (int i = 0; i < contenu.size(); i++) {
                System.out.println(contenu.get(i));
            }*/
            bufferedReader.close();
        } catch (IOException e) {
            // Gérer les exceptions d'entrée/sortie
            e.printStackTrace();
        }
        List<String> mots = new ArrayList<String>();
        for (int i = 0; i < contenu.size(); i++) {

            mots.addAll(asList(contenu.get(i).split(" ")));
        }
        return mots;
    }

}

