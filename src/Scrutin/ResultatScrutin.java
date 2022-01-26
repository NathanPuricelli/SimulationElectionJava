package Scrutin;

import java.util.HashMap;
import java.util.Map;

public class ResultatScrutin {
    private Map<Integer, Integer> resultat;
    private int nbVotesBlanc;

    public ResultatScrutin(){
        this.resultat = new HashMap<Integer, Integer>();
        this.nbVotesBlanc = 0;
    }

    public void ajouterVoteBlanc(){this.nbVotesBlanc++;}

    public void ajouterVote(int idCandidat){
        int oldvalue = resultat.get(idCandidat);
        resultat.replace(idCandidat, oldvalue+1);
    }

    public Map<Integer, Integer> getResultat(){return this.resultat;}
    public int getNbVotesBlanc(){return this.nbVotesBlanc;}

    
}
