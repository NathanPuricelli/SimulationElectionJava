/**
 * @author Nathan Puricelli et Aymeric Leto
 * Fichier principal de la classe traitant la simulation
 */
import java.util.Vector;

import Personnes.Candidat;
import Personnes.Electeur;
import Scrutin.*;

import java.io.IOException;
import java.util.Map;

/**
 * @class Cette classe est la classe qui gère la simulation.
 */
public class Simulation {
    /// Liste des electeurs sous forme de Java vector (tableau dynamique)
    private Vector<Electeur> liste_electeur;
    private Vector<Candidat> liste_candidats;
    private int nbElecteurs;
    private int nbCandidats;

    public Simulation() throws IOException{
        ReadConfig properties = new ReadConfig(); //Classe pour la lecture du fichier de configuration
        
        Map<String, String> map = properties.getPropValues(); // Données du fichier de configuration
        this.nbElecteurs = Integer.parseInt(map.get("nombreElecteurs"));
        this.nbCandidats = Integer.parseInt(map.get("nombreCandidats"));
        this.liste_candidats = new Vector<Candidat>();
        this.liste_electeur = new Vector<Electeur>();

        for (int i = 0; i<this.nbElecteurs; i++){
            liste_electeur.add(new Electeur());
        }
        for (int j = 0; j<this.nbCandidats; j++){
            liste_candidats.add(new Candidat());
        }

    }

    public void simuler(){
        int choixAction=-1;
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans la simulation élection : ");
            System.out.println("Choisissez une action à réalier : ");
            System.out.println("\t1 : Affichage des candidats");
            System.out.println("\t2 : Election");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = Integer.parseInt(System.console().readLine());

        } while (choixAction != 0 && choixAction!=1 && choixAction !=2);
        switch (choixAction) {
            case 1:
                this.afficherCandidats();
                break;
            
            case 2:
                this.election();
                break;

            case 0:
                System.exit(0);
                break;
        
            default:
                break;
        }
        this.simuler();
    }

    private void afficherCandidats(){
        for(int i = 0; i< this.nbCandidats; i++){
            liste_candidats.elementAt(i).afficherOpinions();
        }
        int choixAction=-1;
        System.out.println("\t1 : Retour au Menu");
        System.out.println("\t0 : Quitter la simulation");
        choixAction = Integer.parseInt(System.console().readLine());
        if (choixAction != 1){System.exit(0);}

    }

    public void election(){
        Scrutin s;
        int choixAction=-1;
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans la simulation élection : ");
            System.out.println("Choisissez le type d'élection : ");
            System.out.println("\t1 : Scrutin majoritaire à 1 tour");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = Integer.parseInt(System.console().readLine());
        } while (choixAction != 0 && choixAction!=1);
        switch (choixAction) {
            case 1:
                s = new ScrutinMajoritaireA1Tour();
                break;

            case 0:
                s = null;
                break;
        
            default:
                s = null;
                break;
        }
        if (s == null){return;} // Si on arrete le programme (scrutin n'est pas initialisé, on sort de la fonction)
        ResultatScrutin result = s.voter(this.liste_electeur, this.liste_candidats);
        s.afficherResultats(result, this.liste_candidats);
        System.out.println(s.getClass());        
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
