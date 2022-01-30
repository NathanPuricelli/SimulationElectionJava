package Scrutin;

import java.util.Vector;

import Personnes.Candidat;
import Personnes.Electeur;

/**
 * Extension de la classe Scrutin pour un vote avec la méthode de Borda
 * @author Nathan Puricelli, Aymeric Leto
 */
public class ScrutinBorda extends Scrutin {
    public ResultatScrutin voter( Vector<Electeur> liste_electeurs,  Vector<Candidat> liste_candidats){
        ResultatScrutin resultat = new ResultatScrutin(liste_candidats);
        for (Electeur e : liste_electeurs){
            Vector<Candidat> tabVote = this.getTabVoteElecteur(e, liste_candidats);
            for(int i = 0; i<tabVote.size(); i++){
                resultat.ajouterNVote(tabVote.size() - i, tabVote.get(i));
            }
        }
        resultat.remplirClassement();

        return resultat;        
    }

    /**
     * Fonction qui classe les candidats préférés d'une personne
     * @param e L'electeur a qui appartient le classement
     * @param liste_candidats Les candidats de l'election.
     * @return liste classée des candidats préférés de la personne
     */
    private Vector<Candidat> getTabVoteElecteur(Electeur e, Vector<Candidat> liste_candidats){
        Vector<Candidat> tabVote = new Vector<Candidat>();
        Vector<Candidat> restants = new Vector<Candidat>(liste_candidats);
        while (!restants.isEmpty()){
            Candidat max = restants.get(0);        
            for(Candidat c : restants) {
                if(e.getDistanceFromOtherPerson(c) < e.getDistanceFromOtherPerson(max) ) {
                    max = c;
                }
            }
            tabVote.add(max);
            restants.remove(max);
        }
        return tabVote;
    
    } 

    @Override
    public void afficherResultats(ResultatScrutin res, Vector<Candidat> liste_candidats ){
        System.out.println("Avec cette méthode de vote, les votes indiqués dans les résultats sont en réakuté des points");
        System.out.println("Le nombre de points maximum par candidat est (nbCandidat * nbElecteur)");
        super.afficherResultats(res, liste_candidats);
    }
    
}
