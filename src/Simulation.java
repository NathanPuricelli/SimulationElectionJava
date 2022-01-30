import java.util.Vector;

import Dynamique.*;
import Personnes.*;
import Scrutin.*;

import java.io.IOException;
import java.util.Map;

/**
 * Cette classe est la classe qui gère la simulation.
 * Elle possède les paramètres de la simulation (les tableaux de candidats et d'electeurs)
 * @author Nathan Puricelli, Aymeric Leto
 */
public class Simulation {
    
    /**Liste des candidats de la simulation */
    private Vector<Electeur> liste_electeurs;

    /**Liste des candidats de la simulation */
    private Vector<Candidat> liste_candidats;

    /**
     * Constructeur de la classe simulation.
     * Lit le fichier de configuration pour mettre les bons paramètres de simulation.
     * @throws IOException Exception si problème avec le fichier de configuration.
     */
    public Simulation() throws IOException{
        ReadConfig properties = new ReadConfig(); //Classe pour la lecture du fichier de configuration
        
        Map<String, String> map = properties.getPropValues(); // Données du fichier de configuration
        
        this.liste_candidats = new Vector<Candidat>();
        this.liste_electeurs = new Vector<Electeur>();

        for (int i = 0; i<Integer.parseInt(map.get("nombreElecteurs")); i++){
            liste_electeurs.add(new Electeur());
        }
        for (int j = 0; j<Integer.parseInt(map.get("nombreCandidats")); j++){
            liste_candidats.add(new Candidat());
        }

    }

    /**
     * Méthode principale du projet.
     * Gère l'affichage des boites de dialogue et les choix de la simulation
     */
    public void simuler(){
        int choixAction=-1;
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans la simulation élection : ");
            System.out.println("Choisissez une action à réalier : ");
            System.out.println("\t1 : Affichage des candidats");
            System.out.println("\t2 : Election");
            System.out.println("\t3 : Interactions socio politiques");
            System.out.println("\t4 : Sondages pour modifier les opinions.");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = Integer.parseInt(System.console().readLine());

        } while (choixAction != 0 && choixAction!=1 && choixAction !=2 && choixAction !=3 && choixAction !=4);
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
            
            case 4:
                this.Sondage();
                break;

            case 0:
                System.exit(0);
                break;
        
            default:
                break;
        }
        this.simuler();
    }

    /**
     * Affiche les candidats et leurs opinions.
     */
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

    /**
     * Gère les paramètres d'une élection et affiche son résultat
     */
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
        ResultatScrutin result = s.voter(this.liste_electeurs, this.liste_candidats);
        s.afficherResultats(result, this.liste_candidats);       
    }

    /**
     * Gère les paramètres d'une interraction entre personnes et affiche ce qui en découle.
     */
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
            inter.interagir(liste_electeurs, liste_candidats);
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

    /**
     * Gère les paramètres des sondages
     */
    private void Sondage(){
        Sondage sond = new Sondage();
        int choixTypeSondage=-1;
        do {
            Simulation.clrscr();
            System.out.println("\t\tBienvenue dans le menu de simulation : ");
            System.out.println("Choisissez le type d'effet du sondage : ");
            System.out.println("\t1 : L'electeur se déplace vers son préféré parmi les 3 premiers");
            System.out.println("\t2 : L'electeur se déplace vers le candidat le plus utile ");
            System.out.println("\t3 : L'electeur se déplace vers les candidats les plus utiles en fonction de leur utilité");
            System.out.println("\t0 : Quitter la simulation");          
            choixTypeSondage = Integer.parseInt(System.console().readLine());
        } while (choixTypeSondage != 0 && choixTypeSondage!=1 && choixTypeSondage!=2 && choixTypeSondage!=3);
        switch (choixTypeSondage) {
            case 1:
                sond.AllerVersLeMeilleurDansLes3Premiers(this.liste_electeurs, this.liste_candidats);
                break;
            case 2:
                sond.AllerVersLePlusUtile(this.liste_electeurs, this.liste_candidats);
                break;
            case 3:
                sond.AllerVersLesPlusUtiles(this.liste_electeurs, this.liste_candidats);
                break;
            
            default:
                break;
        }
        System.out.println("Fin du sondage, les opinions ont été modifiés \nAppuyez pour continuer");
        System.console().readLine();

    }

    /**
     * Fonction effacant l'écran de la console, pour améliorer l'expérience utilisateur.
     */
    public static void clrscr(){
        //Efface la console
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
