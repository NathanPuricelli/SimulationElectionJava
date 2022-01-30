package Scrutin;
import Personnes.*;

import java.util.Map;
import java.util.Vector;

/**
 * Extension de la classe Scrutin pour une election majoritaire à 2 tours avec deux finalistes au second tour.
 * @author Nathan Puricelli, Aymeric Leto
 */
public class ScrutinMajoritaireA2Tours extends Scrutin{
    public ResultatScrutin voter(Vector<Electeur> liste_electeurs,  Vector<Candidat> liste_candidats){
        ScrutinMajoritaireA1Tour s = new ScrutinMajoritaireA1Tour();
        ResultatScrutin resultat = s.voter(liste_electeurs, liste_candidats);
        Vector <Candidat> Finalistes = new Vector<Candidat>();
        Finalistes.add(resultat.getClassement().get(1));
        Finalistes.add(resultat.getClassement().get(2));
        ResultatScrutin resultat2ndTour = new ResultatScrutin(Finalistes);
        for (Electeur e : liste_electeurs){
            Candidat c = this.getVoteElecteur(e, Finalistes);
            if (c == null) {
                resultat2ndTour.ajouterVoteBlanc();
            }
            else {
                resultat2ndTour.ajouterVote(c);

            }
        }
        resultat2ndTour.remplirClassement();
        afficherPremierTour(resultat, liste_candidats);
        return resultat2ndTour;
    }

    /**
     * Affiche les résultats du premier tour de l'election
     * @param res Résultat du premier tour de l'election
     * @param liste_candidats Liste des candidats de l'election
     */
    private void afficherPremierTour(ResultatScrutin res, Vector<Candidat> liste_candidats){
        System.out.println("\tRésultat du premier tour : \n");

        for(Map.Entry<Integer, Candidat> entry : res.getClassement().entrySet()){
            System.out.println(entry.getValue().getNom() + " : " + res.getResultat().get(entry.getValue()) + " Votes");
        }
        if(res.getNbVotesBlanc()>0){System.out.println("Nombre de votes blanc : " + res.getNbVotesBlanc());}
        System.out.println();
    }

    /**
     * Fonction qui retourne le candidat duquel l'electeur est le plus proche
     * @param e L'electeur a qui appartient le classement
     * @param liste_candidats Les candidats de l'election.
     * @return liste classée des candidats préférés de la personne
     * @return null, si aucun candidat n'est satisfaisant (Vote blanc)
     */
    private Candidat getVoteElecteur(Electeur e, Vector<Candidat> liste_candidats){
        Candidat meilleur = liste_candidats.get(0);
        for(Candidat c : liste_candidats) {
            if(e.getDistanceFromOtherPerson(c) >= e.getDistanceFromOtherPerson(meilleur)) {
                meilleur = c;
            }
        }
        if(e.getDistanceFromOtherPerson(meilleur) > 1.8 ) { // Pour le deuxième tour, les electeurs acceptent des candidats desquels ils sont moins proches (1.8 > 1.5)
            meilleur = null;
        }
        return meilleur;
    }


    
}
