package Personnes;

abstract class Personnes {
    protected Axe_politique Reformisme;//Revolution(0) ou Reformisme(1)
    protected Axe_politique Productivisme; //Ecologie(0) ou productivisme(1) 
    protected Axe_politique Conservatisme;//Progressisme(0) ou conservatisme(1)
    protected Axe_politique Justice; // Justice réhabilitative (0) ou punitive(1) 
    protected Axe_politique Nationalisme;// Internationalisme (0) ou nationalisme(1)
    protected Axe_politique Capitalisme; //Communisme(0) ou capitalisme(1)

    public Personnes(){
        Reformisme = new Axe_politique();
        Productivisme = new Axe_politique();
        Conservatisme = new Axe_politique();
        Justice = new Axe_politique();
        Nationalisme = new Axe_politique();
        Capitalisme = new Axe_politique();
    }

    public void afficherOpinions(){
        System.out.println("Reformisme : " + Reformisme.getValue());
        System.out.println("Productivisme : " + Productivisme.getValue());
        System.out.println("Conservatisme : " + Conservatisme.getValue());
        System.out.println("Justice : " + Justice.getValue());
        System.out.println("Nationalisme : " + Nationalisme.getValue());
        System.out.println("Capitalisme : " + Capitalisme.getValue());
    }

    public Axe_politique getReformisme(){return this.Reformisme;}
    public Axe_politique getProductivisme(){return this.Productivisme;}
    public Axe_politique getConservatisme(){return this.Conservatisme;}
    public Axe_politique getJustice(){return this.Justice;}
    public Axe_politique getNationalisme(){return this.Nationalisme;}
    public Axe_politique getCapitalisme(){return this.Capitalisme;}
}
