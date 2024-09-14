import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerPath = new BufferedReader(new InputStreamReader(System.in));
        Lecteur lecteur=new Lecteur();
        String rep = "oui";
        while (rep.equals("oui")) {
            Scanner scanner = new Scanner(System.in);
            List<Traiteur> traiteurs = new ArrayList<>();
            boolean defaultTraiteurAjoute = false;
            System.out.println("Choisissez le(s) traiteur(s) (1--4, séparés par des espaces) : ");
            String[] choixTraiteursStr = scanner.nextLine().split("\\s+");
            for (String choixTraiteurStr : choixTraiteursStr) {
                int choixTraiteur = Integer.parseInt(choixTraiteurStr);
                switch (choixTraiteur) {
                    case 1:
                        traiteurs.add(new Traiteur1());
                        break;
                    case 2:
                        traiteurs.add(new Traiteur2());
                        break;
                    case 3:
                        traiteurs.add(new Traiteur3());
                        break;
                    case 4:
                        traiteurs.add(new Traiteur4());
                        break;
                    default:
                        System.out.println("Le traiteur " + choixTraiteur + " est invalide !");
                        break;
                }


                if (!defaultTraiteurAjoute && choixTraiteur > 4) {
                    System.out.println("Le traiteur 1 est pris comme traiteur par défaut !");
                    traiteurs.add(new Traiteur1());
                    defaultTraiteurAjoute = true;
                }
            }
            System.out.println("Choisissez l'analyseur (1--2)");
            int choixAnalyseur = scanner.nextInt();
            Analyseurs analyseur = null;
            switch (choixAnalyseur) {
                case 1:
                    analyseur = new Analyseur1();
                    break;
                case 2:
                    analyseur = new Analyseur2();
                    break;
                default:
                    System.out.println("L'analyseur 1 est pris comme analyseur par défaut !");
                    analyseur = new Analyseur1();
                    break;
            }
            System.out.println("Choisissez l'indexeur (1--2)");
            int choixIndexeur = scanner.nextInt();
            Indexation indexeur = null;
            switch (choixIndexeur) {
                case 1:
                    indexeur = new Index();
                    break;
                case 2:
                    indexeur = new Index2();
                    break;
                default:
                    System.out.println("L'indexeur 1 est pris comme indexeur par défaut !");
                    indexeur = new Index();
                    break;
            }
            Ordonnancement ordonnanceur=null;
            System.out.println("Choisissez l'ordonnanceur (1--2)");
            int choixOrdonnanceur = scanner.nextInt();
            switch (choixOrdonnanceur) {
                case 1:
                    ordonnanceur = new Ordonnanceur();
                    break;
                case 2:
                    ordonnanceur = new Ordonnanceur1();
                    break;
                default:
                    System.out.println("L'ordonnanceur 2 est pris comme indexeur par défaut !");
                    ordonnanceur = new Ordonnanceur1();
                    break;
            }



            try {

                System.out.println("Veuillez saisir le chemin d'un répertoire ou d'un fichier :");
                String path = reader.readLine();
                Document doc = new Document(path, ".txt");

                File file = new File(path);
                if (!file.exists()) {
                    System.out.println("Chemin non valide!!!");
                } else {
                    MoteurDeRecherche moteur = new MoteurDeRecherche(doc, traiteurs, analyseur, indexeur,ordonnanceur);
                    System.out.print("Donner la requête : ");
                    String requete = reader.readLine();
                    System.out.println("le résultat de la recherche est :");



                    //CALCUL DU TEMPS D EXECUTION DE LA METHODE indexDirectoryFile
                    long startTime=System.nanoTime();
                    List<Document> resultat=moteur.indexDirectory(doc.getChemin(), requete);
                    long endTime=System.nanoTime();
                    long duration=(endTime- startTime);
                    System.out.println("Temps d'exécution de la méthode : "+duration+" nanosecondes ");
                    int i=0;
                    for (Document d : resultat ) {

                        System.out.println(d.getChemin()+" ");
                    }
                    System.out.println("le nombre d'occurence de chaque mot de la requête est  :");

                    //CAlCUL DU TEMPS D EXECUTION DE LA METHODE getStat :
                    long startTimee=System.nanoTime();
                    List<DocMotStat> statList=indexeur.getStat(requete);
                    long endTimee=System.nanoTime();
                    long durationn=(endTimee- startTimee);
                    System.out.println("Temps d'exécution de la méthode : "+durationn+" nanosecondes ");

                    


                    for(DocMotStat dms:statList){
                        System.out.println("le mot "+dms.getMot()+" a été rencontré "+dms.getNbOcc()+" fois dans le chemin "+dms.getDoc().getChemin());
                    }

                    // TEST DE L ORDONNANCEUR ;
                    List<Score> scoreList=ordonnanceur.calculer_score(indexeur.getStat(requete));
                    for(Score s: scoreList){
                        System.out.println("Le score  est égal à "+s.getNbreOcc()+" dans le chemin : "+s.getDoc().getChemin());
                    }



                    System.out.println("Voulez-vous effectuer une autre recherche ? (Oui/Non)");
                    String response = reader.readLine().toLowerCase();
                    rep=response;
                    if (rep.equals("oui")) {
                        System.out.println("Merci pour la confimation,Veuillez saisir votre choix");
                    }
                    
                    
                    


                    
                }
            } catch (IOException e) {
                System.out.println("Erreur de lecture de l'entrée.");
                e.printStackTrace();
            }
            
        }

        System.out.println("Merci pour la confirmation et Au revoir ");
    }
}



