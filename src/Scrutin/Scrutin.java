package Scrutin;
import Personnes.*;
import java.util.Vector;

public abstract class Scrutin {
    public abstract ResultatScrutin voter( Vector<Electeur> liste_electeur,  Vector<Candidat> liste_candidats);

    public void afficherResultats(ResultatScrutin res, Vector<Candidat> liste_candidats )
    {
        System.out.println("\tRésultat de l'élection \n");
        for(int i = 0; i<res.getResultat().size(); i++){
            System.out.println("Candidat : " + i + " : " + res.getResultat().get(i+1) + " Votes");
        }
        System.out.println("Votes blanc : " + res.getNbVotesBlanc());
        int choixAction=-1;
        System.out.println("\t1 : Retour au Menu");
        System.out.println("\t0 : Quitter la simulation");
        choixAction = Integer.parseInt(System.console().readLine());
        if (choixAction != 1){System.exit(0);}
    }

    
}
