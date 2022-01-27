package Personnes;

public class Electeur extends Personnes {
    
    protected void fill(){
    }

    /**
     * Calcule la distance entre les opinions de deux personnes
     * Se base sur la norme 2 en dimension 6
     */
    public float getDistanceFromOtherPerson(Personnes pers){
        
        float distance = 0;
        distance += Math.pow(this.Capitalisme.getValue() - pers.Capitalisme.getValue(), 2);
        distance += Math.pow(this.Conservatisme.getValue() - pers.Conservatisme.getValue(), 2);
        distance += Math.pow(this.Reformisme.getValue() - pers.Reformisme.getValue(), 2);
        distance += Math.pow(this.Justice.getValue() - pers.Justice.getValue(), 2);
        distance += Math.pow(this.Nationalisme.getValue() - pers.Nationalisme.getValue(), 2);
        distance += Math.pow(this.Productivisme.getValue() - pers.Productivisme.getValue(), 2);
        distance = (float)Math.sqrt(distance);
        return distance;

    }
}
