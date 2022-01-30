package Scrutin;
import Personnes.*;

import java.util.Map;
import java.util.Vector;

/**
 * Classe abstraire de Scrutin. Définit une méthode abstraite de vote et un affichage du résultat.
 * @author Nathan Puricelli, Aymeric Leto
 */
public abstract class Scrutin {
    /**
     * Fait voter les electeurs pour des candidats en fonction du type de scrutin
     * @param liste_electeur Liste des electeurs
     * @param liste_candidats Liste des candidats
     * @return ResultatScrutin, les informations du résultat du scrutin
     */
    public abstract ResultatScrutin voter( Vector<Electeur> liste_electeur,  Vector<Candidat> liste_candidats);

    /***
     * Affiche le résultat du scrutin.
     * @param res resultat du scutin
     * @param liste_candidats Liste des candidats
     */
    public void afficherResultats(ResultatScrutin res, Vector<Candidat> liste_candidats )
    {
        System.out.println("\tRésultat de l'élection :\n");

        for(Map.Entry<Integer, Candidat> entry : res.getClassement().entrySet()){
            System.out.println(entry.getValue().getNom() + " : " + res.getResultat().get(entry.getValue()) + " Votes");
        }
        if(res.getNbVotesBlanc()>0){System.out.println("Nombre de votes blanc : " + res.getNbVotesBlanc());}        

    
        int choixAction=-1;
        System.out.println("\t1 : Retour au Menu");
        System.out.println("\t0 : Quitter la simulation");
        choixAction = Integer.parseInt(System.console().readLine());
        if (choixAction != 1){System.exit(0);}
    }

    
}
