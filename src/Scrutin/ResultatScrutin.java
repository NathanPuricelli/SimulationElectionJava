package Scrutin;
import Personnes.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;
import java.util.Vector;

public class ResultatScrutin {
    private Map<Candidat, Integer> resultat;
    private int nbVotesBlanc;
    private Map<Integer,Candidat> classement; // classement des candidarts avec le mapping : Candidat ID, Classement

    public ResultatScrutin(Vector<Candidat> liste_candidats){
        this.resultat = new HashMap<Candidat, Integer>();
        this.classement = new HashMap<Integer, Candidat>();
        this.nbVotesBlanc = 0;
        for(Candidat c : liste_candidats){
            this.resultat.put(c, 0);
        }
    }

    public void ajouterVoteBlanc(){this.nbVotesBlanc++;}

    public void ajouterVote(Candidat c){
        int oldvalue = this.resultat.get(c);
        this.resultat.replace(c, oldvalue+1);
    }

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
            System.out.println(this.classement);
        }
    }

    public Map<Candidat, Integer> getResultat(){return this.resultat;}
    public Map<Integer, Candidat> getClassement(){return this.classement;}
    public int getNbVotesBlanc(){return this.nbVotesBlanc;}

    
}
