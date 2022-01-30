package Personnes;

/**
 * Représente un axe politique avec une valeur entre 0 et 1
 * @author Nathan Puricelli, Aymeric Leto
 */
public class Axe_politique {
    /**Valeur entre 0 et 1 de l'axe politique */
    private float value;

    /**
     * Constructeur par défaut, donne une valeur aléatoire entre 0 et 1 à l'axe
     */
    public Axe_politique(){
        this.value = (float)Math.random();
    }

    /**
     * Constructeur de la classe
     * @param value valeur pour l'axe politique
     */
    public Axe_politique(float value){
        this.value = value;
    }

    /**
     * Getter de la valeur de l'axe
     * @return Valeur de l'axe
     */
    public float getValue(){
        return this.value;
    }

    /**
     * Setter de la valeur
     * @param p_value nouvelle valeur 
     */
    public void setValue(float p_value){
        this.value = p_value;
    }
}
