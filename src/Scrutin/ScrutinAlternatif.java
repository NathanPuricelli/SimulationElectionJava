package Scrutin;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Personnes.Candidat;
import Personnes.Electeur;

public class ScrutinAlternatif extends Scrutin {
    public ResultatScrutin voter( Vector<Electeur> liste_electeurs,  Vector<Candidat> liste_candidats){
        int tour = 1;
        ResultatScrutin resultat = new ResultatScrutin(liste_candidats);
        Vector<Candidat> enLice = new Vector<Candidat>(liste_candidats);
        while (enLice.size()>1){
            Map<Candidat, Integer> nombreVotes = new HashMap<Candidat, Integer>();
            for(Candidat c : enLice){
                nombreVotes.put(c, 0);
            }
            for(Electeur e : liste_electeurs){
                Vector<Candidat> tabVote = this.getTabVoteElecteur(e, enLice);
                int last = nombreVotes.get(tabVote.get(0));
                nombreVotes.replace(tabVote.get(0), last+1);
            }

            // On trouve le dernier candidat et on l'exclu du vote (on affiche qu'il part)
            Candidat min = enLice.get(0);
            int minValue = nombreVotes.get(min);
            for(Map.Entry<Candidat, Integer> entry : nombreVotes.entrySet()){
                if(entry.getValue() < minValue){
                    min = entry.getKey();
                    minValue = entry.getValue();
                }
            }

            // On affiche le perdant du tour avec son nombre de voies :
            System.out.println("\t Perdant du tour " + tour +" : " + min.getNom() + " avec " + minValue + "Votes.");
            // On supprime le candidat de la lice
            enLice.remove(min); 
            tour++;          
        }
        
        resultat.remplirClassement();
        resultat.setVainqueurAlternatif(enLice.get(0));

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
                if(e.getDistanceFromOtherPerson(c) < e.getDistanceFromOtherPerson(max) ) { // La valeur 1 est une valeur arbitraire cohérente pour le taux d'acceptation des candidats avec cette méthode
                    max = c;
                }
            }
            tabVote.add(max);
            restants.remove(max);
        }
        return tabVote;
    
    } 

    @Override
    public void afficherResultats(ResultatScrutin res, Vector<Candidat> liste_candidats )
    {
        System.out.println();
        System.out.println("Vainqueur de l'election par vote alternatif : " + res.getVainqueurAlternatif().getNom());        

    
        int choixAction=-1;
        System.out.println("\t1 : Retour au Menu");
        System.out.println("\t0 : Quitter la simulation");
        choixAction = Integer.parseInt(System.console().readLine());
        if (choixAction != 1){System.exit(0);}
    }
}
