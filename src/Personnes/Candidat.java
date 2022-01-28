package Personnes;

public class Candidat extends Personnes {

    private static int identifiant = 1;
    private int id;
    private String nom;

    //public float popularite; // Cette valeur sera a entre O et 1. 1 par défaut, peut etre jouer dans les sondages plus tard.
    
    public Candidat(float p_reformisme, float p_productivisme, float p_conservatisme,
                    float p_justice, float p_nationalisme, float p_capitalisme){
        Reformisme = new Axe_politique(p_reformisme);
        Productivisme = new Axe_politique(p_productivisme);
        Conservatisme = new Axe_politique(p_conservatisme);
        Justice = new Axe_politique(p_justice);
        Nationalisme = new Axe_politique(p_nationalisme);
        Capitalisme = new Axe_politique(p_capitalisme);                        
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