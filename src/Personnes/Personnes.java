package Personnes;

/**
 * Classe abstraite représentant une personne
 */
public abstract class Personnes {
    /**Axe politique : Revolution(0) ou Reformisme(1)  */
    protected Axe_politique Reformisme;

    /**Axe politique : Ecologie(0) ou productivisme(1)  */
    protected Axe_politique Productivisme;

    /**Axe politique : Progressisme(0) ou conservatisme(1) */
    protected Axe_politique Conservatisme;

    /**Axe politique : Justice réhabilitative (0) ou punitive(1) */
    protected Axe_politique Justice;

    /**Axe politique : Internationalisme (0) ou nationalisme(1) */
    protected Axe_politique Nationalisme;

    /**Axe politique : Communisme(0) ou capitalisme(1)*/
    protected Axe_politique Capitalisme;

    /**
     * Constructeur par défaut de personnes
     */
    public Personnes(){
        Reformisme = new Axe_politique();
        Productivisme = new Axe_politique();
        Conservatisme = new Axe_politique();
        Justice = new Axe_politique();
        Nationalisme = new Axe_politique();
        Capitalisme = new Axe_politique();
    }

    /**
     * Affiche les opinions politique de la personne
     */
    public void afficherOpinions(){
        System.out.println("Reformisme : " + Reformisme.getValue());
        System.out.println("Productivisme : " + Productivisme.getValue());
        System.out.println("Conservatisme : " + Conservatisme.getValue());
        System.out.println("Justice : " + Justice.getValue());
        System.out.println("Nationalisme : " + Nationalisme.getValue());
        System.out.println("Capitalisme : " + Capitalisme.getValue());
    }

    /**
     * Définition abstraite d'une fonction qui retourne le nom de la personne.
     * @return nom de la personne
     */
    public abstract String getNom();

    /**
     * Getter de Réformisme
     * @return Valeur de l'axe Réformisme
     */
    public Axe_politique getReformisme(){return this.Reformisme;}

    /**
     * Getter de Productivisme
     * @return Valeur de l'axe Productivisme
     */
    public Axe_politique getProductivisme(){return this.Productivisme;}

    /**
     * Getter de Conservatisme
     * @return Valeur de l'axe Conservatisme
     */
    public Axe_politique getConservatisme(){return this.Conservatisme;}

    /**
     * Getter de Justice
     * @return Valeur de l'axe Justice
     */
    public Axe_politique getJustice(){return this.Justice;}

    /**
     * Getter de Nationalisme
     * @return Valeur de l'axe Nationalisme
     */
    public Axe_politique getNationalisme(){return this.Nationalisme;}

    /**
     * Getter de Capitalisme
     * @return Valeur de l'axe Capitalisme
     */
    public Axe_politique getCapitalisme(){return this.Capitalisme;}
}
