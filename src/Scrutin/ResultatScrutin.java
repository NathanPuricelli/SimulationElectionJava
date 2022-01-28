package Scrutin;
import Personnes.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ResultatScrutin {
    private Map<Integer, Integer> resultat;
    private int nbVotesBlanc;

    public ResultatScrutin(Vector<Candidat> liste_candidats){
        this.resultat = new HashMap<Integer, Integer>();
        this.nbVotesBlanc = 0;
        for(Candidat c : liste_candidats){
            this.resultat.put(c.getID(), 0);
        }
    }

    public void ajouterVoteBlanc(){this.nbVotesBlanc++;}

    public void ajouterVote(int idCandidat){
        int oldvalue = this.resultat.get(idCandidat);
        this.resultat.replace(idCandidat, oldvalue+1);
    }

    public Map<Integer, Integer> getResultat(){return this.resultat;}
    public int getNbVotesBlanc(){return this.nbVotesBlanc;}

    
}
