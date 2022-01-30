package Scrutin;
import Personnes.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;
import java.util.Vector;

/**
 * Gère les résultats d'un scrutin
 * @author Nathan Puricelli, Aymeric Leto
 */
public class ResultatScrutin {
    /**Assotiation de la forme Candidat : Nombre de votes */
    private Map<Candidat, Integer> resultat;

    /**Nombre de votes blanc d'une election */
    private int nbVotesBlanc;

    /**Assotiation de la forme Position : Candidat */
    private Map<Integer,Candidat> classement;

    /**Vainqueur lors d'une election de type vote alternatif */
    private Candidat vainqueurAlternatif;

    /**
     * Constructeur de la classe
     * @param liste_candidats Liste des candidats de l'election
     */
    public ResultatScrutin(Vector<Candidat> liste_candidats){
        this.resultat = new HashMap<Candidat, Integer>();
        this.classement = new HashMap<Integer, Candidat>();
        this.nbVotesBlanc = 0;
        for(Candidat c : liste_candidats){
            this.resultat.put(c, 0);
        }
    }

    /**Ajout d'un vote blanc */
    public void ajouterVoteBlanc(){this.nbVotesBlanc++;}

    /**
     * Ajout d'un vote au candidat c
     * @param c Candidat auquel ajouter un vote
     */
    public void ajouterVote(Candidat c){
        int oldvalue = this.resultat.get(c);
        this.resultat.replace(c, oldvalue+1);
    }

    /**
     * Ajout de n votes au candidat c
     * @param n nombre de votes 
     * @param c Candidat auquel ajouter les votes
     */
    public void ajouterNVote(int n, Candidat c){
        int oldvalue = this.resultat.get(c);
        this.resultat.replace(c, oldvalue+n);
    }

    /**Remplit le mapping de classement en fonction du nombre de votes par candidat */
    public void remplirClassement(){
        int place = 1;
        Map<Candidat, Integer> res2 = new HashMap<>(this.resultat);
        ArrayList<Candidat> restants = new ArrayList<Candidat>();
        for(Map.Entry<Candidat, Integer> entry : this.resultat.entrySet()){
            restants.add(entry.getKey());
        }      
        while(!res2.isEmpty()){
            Candidat max = restants.get(0);
            int maxValue = res2.get(max);
            for(Map.Entry<Candidat, Integer> entry : res2.entrySet()){
                if(entry.getValue() > maxValue){
                    max = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            this.classement.put(place, max);
            place++;
            res2.remove(max);
            restants.remove(max);
        }
    }

    /**Affiche les résultats d'un sondage à la fin du sondage */
    public void afficherResultatSondage(){
        System.out.println("\tRésultat du sondage : ");
        for(Map.Entry<Integer, Candidat> entry : this.classement.entrySet()){
            System.out.println(entry.getValue().getNom() + " : " + this.resultat.get(entry.getValue()) + " Votes");
        }
        if(this.nbVotesBlanc>0){System.out.println("Nombre de votes blanc : " + this.nbVotesBlanc);}            
    }

    /**
     * Getter du résultat
     * @return Mapping Candidat : Nombre vote
     */
    public Map<Candidat, Integer> getResultat(){return this.resultat;}

    /**
     * Getter du classement
     * @return Mapping Classement : Candidat
     */
    public Map<Integer, Candidat> getClassement(){return this.classement;}

    /**
     * Getter du nombre de votes blanc
     * @return le nombre de votes blanc
     */
    public int getNbVotesBlanc(){return this.nbVotesBlanc;}

    /**
     * Setter du vainqueur alternatif
     * @param c Candidat vaiqueur de l'election alternative
     */
    public void setVainqueurAlternatif(Candidat c) {this.vainqueurAlternatif = c;}

    /**
     * Getter du vainqueur alternatif 
     * @return Candidat ayant gagné l'election alternative
     */
    public Candidat getVainqueurAlternatif(){return this.vainqueurAlternatif;}

    
}
