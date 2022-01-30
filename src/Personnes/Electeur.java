package Personnes;

/**
 * Extension de la classe personne pour un électeur
 * @author Nathan Puricelli, Aymeric Leto
 */
public class Electeur extends Personnes {
    /**Variable de classe qui suit le numéro des electeurs */
    private static int identifiant = 1;

    /**Numéro (identifiant) de l'electeur */
    private int id;

    /**Nom de l'electeur */
    private String nom;
    
    /**Constructeur de Electeur */
    public Electeur(){
        super();
        this.id = Electeur.identifiant;
        this.nom = "Electeur " + String.valueOf(Electeur.identifiant);
        Electeur.identifiant++;
    }


    /**
     * Calcule la distance entre les opinions de deux personnes
     * Se base sur la norme 2 en dimension 6
     * @param pers Personne avec laquelle la distance est mesurée
     * @return Distance entre 2 personnes
     */
    public float getDistanceFromOtherPerson(Personnes pers){
        
        float distance = 0;
        distance += Math.pow(this.Capitalisme.getValue() - pers.getCapitalisme().getValue(), 2);
        distance += Math.pow(this.Conservatisme.getValue() - pers.getConservatisme().getValue(), 2);
        distance += Math.pow(this.Reformisme.getValue() - pers.getReformisme().getValue(), 2);
        distance += Math.pow(this.Justice.getValue() - pers.getJustice().getValue(), 2);
        distance += Math.pow(this.Nationalisme.getValue() - pers.getNationalisme().getValue(), 2);
        distance += Math.pow(this.Productivisme.getValue() - pers.getProductivisme().getValue(), 2);
        distance = (float)Math.sqrt(distance);
        return distance;
    }

    /**
     * Rapproche les opinions de l'electeur vers ceux d'une personne p
     * @param p personne de qui l'electeur se rapproche
     * @param force inverse de Intensité avec laquelle l'electeur se rapproche 
     */
    public void Rapprochement(Personnes p, float force){
        float distanceConservatisme = this.Conservatisme.getValue() - p.getConservatisme().getValue();
        this.Conservatisme.setValue(((this.Conservatisme.getValue() - distanceConservatisme) * force) / (5*force));
        float distanceJustice = this.Justice.getValue() - p.getJustice().getValue();
        this.Justice.setValue(this.Justice.getValue() - distanceJustice / (5*force));
        float distanceProductivisme = this.Productivisme.getValue() - p.getProductivisme().getValue();
        this.Productivisme.setValue(this.Productivisme.getValue() - distanceProductivisme / (5*force));
        float distanceReformisme = this.Reformisme.getValue() - p.getReformisme().getValue();
        this.Reformisme.setValue(this.Reformisme.getValue() - distanceReformisme / (5*force));
        float distanceNationalisme = this.Nationalisme.getValue() - p.getNationalisme().getValue();
        this.Nationalisme.setValue(this.Nationalisme.getValue() - distanceNationalisme / (5*force));
        float distanceCapitalisme = this.Capitalisme.getValue() - p.getCapitalisme().getValue();
        this.Capitalisme.setValue(this.Capitalisme.getValue() - distanceCapitalisme / (5*force));    
    }

    /**
     * Eloigne les opinions de l'electeur de ceux d'une personne p
     * @param p personne de qui l'electeur s'éloigne
     */
    public void Eloignement(Personnes p){
        float distanceConservatisme = this.Conservatisme.getValue() - p.getConservatisme().getValue();
        this.Conservatisme.setValue(this.Conservatisme.getValue() + distanceConservatisme / 5);
        float distanceJustice = this.Justice.getValue() - p.getJustice().getValue();
        this.Justice.setValue(this.Justice.getValue() + distanceJustice / 5);
        float distanceProductivisme = this.Productivisme.getValue() - p.getProductivisme().getValue();
        this.Productivisme.setValue(this.Productivisme.getValue() + distanceProductivisme / 5);
        float distanceReformisme = this.Reformisme.getValue() - p.getReformisme().getValue();
        this.Reformisme.setValue(this.Reformisme.getValue() + distanceReformisme / 5);
        float distanceNationalisme = this.Nationalisme.getValue() - p.getNationalisme().getValue();
        this.Nationalisme.setValue(this.Nationalisme.getValue() + distanceNationalisme / 5);
        float distanceCapitalisme = this.Capitalisme.getValue() - p.getCapitalisme().getValue();
        this.Capitalisme.setValue(this.Capitalisme.getValue() + distanceCapitalisme / 5);    
        if (this.Capitalisme.getValue() < 0){this.Capitalisme.setValue(0);}
        if (this.Conservatisme.getValue() < 0){this.Conservatisme.setValue(0);}
        if (this.Justice.getValue() < 0){this.Justice.setValue(0);}
        if (this.Productivisme.getValue() < 0){this.Productivisme.setValue(0);}
        if (this.Reformisme.getValue() < 0){this.Reformisme.setValue(0);}
        if (this.Nationalisme.getValue() < 0){this.Nationalisme.setValue(0);}
        if (this.Capitalisme.getValue() > 1){this.Capitalisme.setValue(1);}
        if (this.Conservatisme.getValue() > 1){this.Conservatisme.setValue(1);}
        if (this.Justice.getValue() > 1){this.Justice.setValue(1);}
        if (this.Productivisme.getValue() > 1){this.Productivisme.setValue(1);}
        if (this.Reformisme.getValue() > 1){this.Reformisme.setValue(1);}
        if (this.Nationalisme.getValue() > 1){this.Nationalisme.setValue(1);}

    }

    /**
     * Getter de l'id de l'electeur
     * @return L'id de l'electeur
     */
    public int getID(){return this.id;}

    /**
     * Getter du nom de l'electeur
     * @return le nom de l'electeur
     */
    public String getNom(){return this.nom;}
}
