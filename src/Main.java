import java.util.Vector;
import java.io.IOException;
import java.util.Map;

import Person.Candidat;
import Person.Electeur;
public class Main {

    private Vector<Electeur> liste_electeur;
    private Vector<Candidat> liste_candidat;

    public static void main(String[] args) throws IOException{
        ReadConfig properties = new ReadConfig();
        Map<String, Float> map = properties.getPropValues();
        Electeur e = new Electeur();
        System.out.println("Le début du projet.");
        e.afficherOpinions();
    }

}
