package Scrutin;

import java.util.Vector;

import Personnes.Candidat;
import Personnes.Electeur;

/**
 * Extension de la classe Scrutin pour un vote par approbation
 * @author Nathan Puricelli, Aymeric Leto
 */
public class ScrutinApprobation extends Scrutin{
    @Override
    public ResultatScrutin voter( Vector<Electeur> liste_electeurs,  Vector<Candidat> liste_candidats){
        ResultatScrutin resultat = new ResultatScrutin(liste_candidats);
        for (Electeur e : liste_electeurs){
            Vector<Candidat> tabVote = this.getTabVoteElecteur(e, liste_candidats);
            if (tabVote == null) {
                resultat.ajouterVoteBlanc();
            }
            else {
                for(Candidat c : tabVote) {resultat.ajouterVote(c);}
            }
        }
        resultat.remplirClassement();

        return resultat;        
    }

    /**
     * Fonction qui retourne les candidats satisfaisants pour un electeur
     * @param e L'electeur a qui appartient le classement
     * @param liste_candidats Les candidats de l'election.
     * @return liste des candidats satisfaisants pour l'electeur
     */
    private Vector<Candidat> getTabVoteElecteur(Electeur e, Vector<Candidat> liste_candidats){
        Vector<Candidat> tabVote = new Vector<Candidat>();
        for(Candidat c : liste_candidats) {
            if(e.getDistanceFromOtherPerson(c) < 1 ) { // La valeur 1 est une valeur arbitraire cohérente pour le taux d'acceptation des candidats avec cette méthode
                tabVote.add(c);
            }
        }
        if (tabVote.isEmpty()){return null;}
        return tabVote;
    
    }
    
}

