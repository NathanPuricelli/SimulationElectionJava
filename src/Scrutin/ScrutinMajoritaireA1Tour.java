package Scrutin;
import Personnes.*;

import java.util.Vector;

public class ScrutinMajoritaireA1Tour extends Scrutin{

    public ResultatScrutin voter(Vector<Electeur> liste_electeurs,  Vector<Candidat> liste_candidats){
        ResultatScrutin resultat = new ResultatScrutin(liste_candidats);
        for (Electeur e : liste_electeurs){
            Candidat c = this.getVoteElecteur(e, liste_candidats);
            if (c == null) {
                resultat.ajouterVoteBlanc();
            }
            else {
                resultat.ajouterVote(c);

            }
        }
        resultat.remplirClassement();

        return resultat;        
    }

    private Candidat getVoteElecteur(Electeur e, Vector<Candidat> liste_candidats){
        Candidat meilleur = liste_candidats.get(0);
        for(Candidat c : liste_candidats) {
            if(e.getDistanceFromOtherPerson(c) >= e.getDistanceFromOtherPerson(meilleur)) {
                meilleur = c;
            }
        }
        if(e.getDistanceFromOtherPerson(meilleur) > 1.5 ) { // La valeur 1.5 est une valeur arbitraire cohérente pour le taux d'abstention
            meilleur = null;
        }
        return meilleur;
    }
    

    
}
