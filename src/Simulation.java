import java.util.Vector;
import java.io.IOException;
import java.util.Map;

import Person.Candidat;
import Person.Electeur;


public class Simulation {
    private Vector<Electeur> liste_electeur;
    private Vector<Candidat> liste_candidat;
    private int nbElecteurs;
    private int nbCandidats;

    public Simulation() throws IOException{
        ReadConfig properties = new ReadConfig(); //Classe pour la lecture du fichier de configuration
        
        Map<String, Float> map = properties.getPropValues(); // Données du fichier de configuration
        float nombreElecteurs = map.get("nombreElecteurs");
        float nombreCandidats = map.get("nombreCandidats");
        this.nbCandidats = (int)nombreCandidats;
        this.nbElecteurs = (int)nombreElecteurs;
        this.liste_candidat = new Vector<Candidat>();
        this.liste_electeur = new Vector<Electeur>();

        for (int i = 0; i<this.nbElecteurs; i++){
            liste_electeur.add(new Electeur());
        }
        for (int j = 0; j<this.nbCandidats; j++){
            liste_candidat.add(new Candidat());
        }

    }

    public void simuler(){
        this.afficherCandidats();
    }

    private void afficherCandidats(){
        for(int i = 0; i< this.nbCandidats; i++){
            liste_candidat.elementAt(i).afficherOpinions();
        }
    }
}
