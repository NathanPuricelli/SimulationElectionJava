/**
 * @author Nathan Puricelli et Aymeric Leto
 * Fichier principal de la classe traitant la simulation
 */
import java.util.Vector;

import Personnes.Candidat;
import Personnes.Electeur;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * @class Cette classe est la classe qui gère la simulation.
 */
public class Simulation {
    /// Liste des electeurs sous forme de Java vector (tableau dynamique)
    private Vector<Electeur> liste_electeur;
    private Vector<Candidat> liste_candidat;
    private int nbElecteurs;
    private int nbCandidats;

    public Simulation() throws IOException{
        ReadConfig properties = new ReadConfig(); //Classe pour la lecture du fichier de configuration
        
        Map<String, Float> map = properties.getPropValues(); // Données du fichier de configuration
        float nombreElecteurs = map.get("nombreElecteurs");
        float nombreCandidats = map.get("nombreCandidats");
        this.nbCandidats = (int)nombreCandidats;
        this.nbElecteurs = (int)nombreElecteurs;
        this.liste_candidat = new Vector<Candidat>();
        this.liste_electeur = new Vector<Electeur>();

        for (int i = 0; i<this.nbElecteurs; i++){
            liste_electeur.add(new Electeur());
        }
        for (int j = 0; j<this.nbCandidats; j++){
            liste_candidat.add(new Candidat());
        }

    }

    public void simuler(){
        int choixAction=-1;
        Scanner scan = new Scanner(System.in);
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans la simulation élection : ");
            System.out.println("Choisissez une action à réalier : ");
            System.out.println("\t1 : Affichage des candidats");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = scan.nextInt();
        } while (choixAction != 0 && choixAction!=1);
        scan.close();
        switch (choixAction) {
            case 1:
                this.afficherCandidats();
                break;

            case 0:
                break;
        
            default:
                break;
        }
    }

    private void afficherCandidats(){
        for(int i = 0; i< this.nbCandidats; i++){
            liste_candidat.elementAt(i).afficherOpinions();
        }
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
