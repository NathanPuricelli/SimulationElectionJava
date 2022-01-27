package Scrutin;
import Personnes.*;
import java.util.Vector;

public abstract class Scrutin {
    public abstract ResultatScrutin voter( Vector<Electeur> liste_electeur,  Vector<Candidat> liste_candidats);

    public void afficherResultats(ResultatScrutin res, Vector<Candidat> liste_candidats )
    {
        System.out.println("\tRésultat de l'élection \n");
        for(int i = 0; i<res.getResultat().size(); i++){
            System.out.print(i);
            System.out.print(" : ");
            System.out.print(res.getResultat().get(i));
        }
    }

    
}
