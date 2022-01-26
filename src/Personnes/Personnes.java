package Personnes;

abstract class Personnes {
    protected Political_axis Reformisme;//Revolution(0) ou Reformisme(1)
    protected Political_axis Productivisme; //Ecologie(0) ou productivisme(1) 
    protected Political_axis Conservatisme;//Progressisme(0) ou conservatisme(1)
    protected Political_axis Justice; // Justice réhabilitative (0) ou punitive(1) 
    protected Political_axis Nationalisme;// Internationalisme (0) ou nationalisme(1)
    protected Political_axis Capitalisme; //Communisme(0) ou capitalisme(1)

    public Personnes(){
        Reformisme = new Political_axis();
        Productivisme = new Political_axis();
        Conservatisme = new Political_axis();
        Justice = new Political_axis();
        Nationalisme = new Political_axis();
        Capitalisme = new Political_axis();
    }

    public void afficherOpinions(){
        System.out.println("Reformisme : " + Reformisme.getValue());
        System.out.println("Productivisme : " + Productivisme.getValue());
        System.out.println("Conservatisme : " + Conservatisme.getValue());
        System.out.println("Justice : " + Justice.getValue());
        System.out.println("Nationalisme : " + Nationalisme.getValue());
        System.out.println("Capitalisme : " + Capitalisme.getValue());
    }
}
