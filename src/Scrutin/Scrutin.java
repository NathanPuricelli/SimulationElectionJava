package Scrutin;
import Personnes.*;
import java.util.Vector;

abstract class Scrutin {
    abstract ResultatScrutin voter( Vector<Electeur> liste_electeur,  Vector<Candidat> liste_candidats);
}
