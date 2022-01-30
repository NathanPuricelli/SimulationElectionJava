package Personnes;

/**
 * Extension de la classe Personnes pour représenter un candidat
 * @author Nathan Puricelli, Aymeric Leto
 */
public class Candidat extends Personnes {

    /**Variable de classe qui suit le numéro des candidats */
    private static int identifiant = 1;

    /**Numéro du candidat */
    private int id;

    /**Nom du candidat */
    private String nom;

    /**
     * Constructeur de Candidat, utile si on veut rentrer des candidats manuellement depuis les fichiers de config
     * @param p_reformisme Valeur de l'axe reformisme
     * @param p_productivisme Valeur de l'axe Productivisme
     * @param p_conservatisme Valeur de l'axe Conservatisme
     * @param p_justice Valeur de l'axe Justice
     * @param p_nationalisme Valeur de l'axe Nationalisme
     * @param p_capitalisme Valeur de l'axe Capitalisme
     * @param p_nom Nom du candidat
     */    
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

    /**
     * Constructeur de candidat
     */
    public Candidat(){
        super();
        this.id = Candidat.identifiant;
        this.nom = "Candidat " + String.valueOf(Candidat.identifiant);
        Candidat.identifiant++;
    }

    @Override
    public void afficherOpinions(){
        System.out.println("\tCandidat numéro : " + this.id);
        System.out.println("\tNom candidat : " + this.nom);
        super.afficherOpinions();
    }

    /**
     * Getter de l'id du candidat
     * @return l'id du candidat
     */
    public int getID(){return this.id;}

    /**
     * Getter du nom du candidat
     * @return le nom du candidat
     */
    public String getNom(){return this.nom;}
}