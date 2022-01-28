package Personnes;

public class Candidat extends Personnes {

    private static int identifiant = 1;
    private int id;
    private String nom;

    //public float popularite; // Cette valeur sera a entre O et 1. 1 par défaut, peut etre jouer dans les sondages plus tard.
    
    public Candidat(float p_reformisme, float p_productivisme, float p_conservatisme,
                    float p_justice, float p_nationalisme, float p_capitalisme, String p_nom){
        this.Reformisme = new Axe_politique(p_reformisme);
        this.Productivisme = new Axe_politique(p_productivisme);
        this.Conservatisme = new Axe_politique(p_conservatisme);
        this.Justice = new Axe_politique(p_justice);
        this.Nationalisme = new Axe_politique(p_nationalisme);
        this.Capitalisme = new Axe_politique(p_capitalisme);
        this.nom = p_nom;
        this.id = Candidat.identifiant;
        Candidat.identifiant++;
                                
    }

    public void afficherOpinions(){
        System.out.println("\tCandidat numéro : " + this.id);
        System.out.println("\tNom candidat : " + this.nom);
        super.afficherOpinions();
    }

    public Candidat(){
        super();
        this.id = Candidat.identifiant;
        this.nom = "Candidat " + String.valueOf(Candidat.identifiant);
        Candidat.identifiant++;
    }

    public Candidat(int identifiant, String name){
        super();
        this.id = identifiant;
        this.nom = name;    
    }

    public int getID(){return this.id;}
    public String getNom(){return this.nom;}
}