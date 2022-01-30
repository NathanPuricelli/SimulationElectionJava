package Dynamique;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Personnes.*;
import Scrutin.*;
public class Sondage {

    public void AllerVersLeMeilleurDansLes3Premiers(Vector<Electeur> liste_electeur, Vector<Candidat> liste_candidat){
        ResultatScrutin res = this.choixScrutinSondage(liste_electeur, liste_candidat);
        for (Electeur e : liste_electeur){
            Candidat best = res.getClassement().get(1);
            for(Map.Entry<Integer, Candidat> entry : res.getClassement().entrySet()){
                if(e.getDistanceFromOtherPerson(entry.getValue()) < e.getDistanceFromOtherPerson(best)){best = entry.getValue();}
            }
            e.Rapprochement(best, 1);
        }
        res.afficherResultatSondage();

    }

    public void AllerVersLePlusUtile(Vector<Electeur> liste_electeur, Vector<Candidat> liste_candidat){
        ResultatScrutin res = this.choixScrutinSondage(liste_electeur, liste_candidat);
        for (Electeur e : liste_electeur){
            Candidat best = res.getClassement().get(1);
            float utility;
            for(Map.Entry<Integer, Candidat> entry : res.getClassement().entrySet()){
                utility = 1/(e.getDistanceFromOtherPerson(best)) * res.getResultat().get(best); // On multiplie l'inverse de la distance au candidat par le nombre de voies du candidat
                //if(e.getDistanceFromOtherPerson(entry.getValue()) < e.getDistanceFromOtherPerson(best)){
                if(1/(e.getDistanceFromOtherPerson(entry.getValue())) * res.getResultat().get(entry.getValue()) > utility){
                    best = entry.getValue();
                }
            }
            e.Rapprochement(best, 1);
        }
        res.afficherResultatSondage();

    }

    public void AllerVersLesPlusUtiles(Vector<Electeur> liste_electeur, Vector<Candidat> liste_candidat){
        ResultatScrutin res = this.choixScrutinSondage(liste_electeur, liste_candidat);
        for (Electeur e : liste_electeur){
            Map<Candidat,Float> utilites = new HashMap<Candidat, Float>();
            for(Map.Entry<Integer, Candidat> entry : res.getClassement().entrySet()){
                utilites.put(entry.getValue(), 1/(e.getDistanceFromOtherPerson(entry.getValue())) * res.getResultat().get(entry.getValue()));
            }
            for(Map.Entry<Candidat, Float> entry : utilites.entrySet()){
                e.Rapprochement(entry.getKey(), (liste_electeur.size() / entry.getValue()));
            }
        }
        res.afficherResultatSondage();

    }


    /**
     * Méthode de choix du scrutin. Le scrutin majoritaire à 2 tours et le vote alternatif ne sont pas compatibles avec les sondages
     * C'est pourquoi on ne peut pas faire un sondage selon ces types de scrutin.
     * @return ResultatScrutin le résultat du sondage
     */
    private ResultatScrutin choixScrutinSondage(Vector<Electeur> liste_electeur, Vector<Candidat> liste_candidat){
        Scrutin s;
        int choixAction=-1;
        do {
            System.out.println("Choisissez le type d'élection pour le sondage : ");
            System.out.println("\t1 : Scrutin majoritaire à 1 tour");
            System.out.println("\t2 : Vote par approbation");
            System.out.println("\t3 : Vote méthode de Borda");
            System.out.println("\t0 : Quitter la simulation");
            choixAction = Integer.parseInt(System.console().readLine());
        } while (choixAction != 0 && choixAction!=1 && choixAction!=2 && choixAction!=3);
        switch (choixAction) {
            case 1:
                s = new ScrutinMajoritaireA1Tour();
                break;
            case 2:
                s = new ScrutinApprobation();
                break;
            case 3:
                s = new ScrutinBorda();
                break;

            case 0:
                s = null;
                System.exit(0);
                break;
        
            default:
                s = null;
                break;
        }
        if (s == null){return null;} // Si on arrete le programme (scrutin n'est pas initialisé, on sort de la fonction et on retourne un resultat null)
        // Le sondage est une élection parmi la moitié de la population.
        // On remplit donc le tableau d'electeurs, avec la première moitié du tableau initial.
        Vector<Electeur> newTabElect = new Vector<Electeur>();
        for(int i = 0; i < liste_electeur.size() / 2 ; i++){newTabElect.add(liste_electeur.get(i));}
        ResultatScrutin result = s.voter(newTabElect, liste_candidat);
        return result;

    }
    
}
