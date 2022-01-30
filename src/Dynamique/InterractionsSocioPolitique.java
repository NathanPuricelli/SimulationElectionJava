package Dynamique;

import java.util.Random;
import java.util.Vector;

import Personnes.*;

public class InterractionsSocioPolitique {

    public void interagir(Vector<Electeur> liste_electeur, Vector<Candidat> liste_candidat){
        for(Electeur e : liste_electeur){
            Random r = new Random();
            int choix = r.nextInt(5); // 4 chances sur 5 de rencontrer un candidat
            if(choix == 4){ // Si il rencontre un candidat
                int nCandidat = r.nextInt(liste_candidat.size());
                this.interractionEntre2Personnes(e, liste_candidat.get(nCandidat));
            }
            else{
                int nElecteur = r.nextInt(liste_electeur.size());
                this.interractionEntre2Personnes(e, liste_electeur.get(nElecteur));
            }

        }
        
    }


    /**
     * Méthode faisant varier les opinions d'un electeur. Les opinons s'éloignent si la distance est grande et se rapprochent autrement.
     * @param e Electeur dont les opinions bougent
     * @param p Personne a comparer à l'electeur
     */   
    private void interractionEntre2Personnes(Electeur e, Personnes p){
        float distance = e.getDistanceFromOtherPerson(p);
        if (distance > 1){
            // On eloigne les opinions de e
            e.Eloignement(p);            
            System.out.println("L'electeur " + e.getID() + " s'eloigne de " + p.getNom());            
        }
        else{
            // On rapproche les opinions
            e.Rapprochement(p);
            System.out.println("L'electeur " + e.getID() + " se rapproche de " + p.getNom());
        }
    }


    
}
