/**
 * @author Nathan Puricelli et Aymeric Leto
 * Fichier principal de la classe traitant la simulation
 */
import java.util.Vector;

import Dynamique.InterractionsSocioPolitique;
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
            System.out.println("\t3 : Interactions socio politique");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = Integer.parseInt(System.console().readLine());

        } while (choixAction != 0 && choixAction!=1 && choixAction !=2 && choixAction !=3);
        switch (choixAction) {
            case 1:
                this.afficherCandidats();
                break;
            
            case 2:
                this.election();
                break;
            
            case 3:
                this.Interraction();
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
        for(Candidat c : liste_candidats){
            c.afficherOpinions();
            System.out.println();
        }
        int choixAction=-1;
        System.out.println("\t1 : Retour au Menu");
        System.out.println("\t0 : Quitter la simulation");
        choixAction = Integer.parseInt(System.console().readLine());
        if (choixAction != 1){System.exit(0);}

    }

    private void election(){
        Scrutin s;
        int choixAction=-1;
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans la simulation élection : ");
            System.out.println("Choisissez le type d'élection : ");
            System.out.println("\t1 : Scrutin majoritaire à 1 tour");
            System.out.println("\t2 : Scrutin majoritaire à 2 tours");
            System.out.println("\t3 : Vote par approbation");
            System.out.println("\t4 : Vote Alternatif");
            System.out.println("\t5 : Vote méthode de Borda");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = Integer.parseInt(System.console().readLine());
        } while (choixAction != 0 && choixAction!=1 && choixAction!=2 && choixAction!=3 && choixAction!=4 && choixAction!=5);
        switch (choixAction) {
            case 1:
                s = new ScrutinMajoritaireA1Tour();
                break;
            case 2:
                s = new ScrutinMajoritaireA2Tours();
                break;
            case 3:
                s = new ScrutinApprobation();
                break;
            case 4:
                s = new ScrutinAlternatif();
                break;
            case 5:
                s = new ScrutinBorda();
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
    }

    private void Interraction(){
        InterractionsSocioPolitique inter = new InterractionsSocioPolitique();
        int nbIterations=-1;
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans le menu d'interaction socio politique : ");
            System.out.println("Choisissez le nombre d'interactions par candidat entre 1 et 5 : ");
            System.out.println("Choisissez 0 pour revenir au menu");           
            nbIterations = Integer.parseInt(System.console().readLine());
        } while (nbIterations != 0 && nbIterations!=1 && nbIterations!=2 && nbIterations!=3 && nbIterations!=4 && nbIterations!=5);
        while (nbIterations > 0){
            System.out.println("Interactions restantes : " + nbIterations);
            inter.interagir(liste_electeur, liste_candidats);
            System.out.println("Appuyez pour continuer");
            System.console().readLine();
            nbIterations--;
        }
        int choixAction=-1;
        System.out.println("\t1 : Retour au Menu");
        System.out.println("\t0 : Quitter la simulation");
        choixAction = Integer.parseInt(System.console().readLine());
        if (choixAction != 1){System.exit(0);}
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
