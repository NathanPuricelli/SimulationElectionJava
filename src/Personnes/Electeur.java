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
        distance += Math.pow(this.Capitalisme.getValue() - pers.getCapitalisme().getValue(), 2);
        distance += Math.pow(this.Conservatisme.getValue() - pers.getConservatisme().getValue(), 2);
        distance += Math.pow(this.Reformisme.getValue() - pers.getReformisme().getValue(), 2);
        distance += Math.pow(this.Justice.getValue() - pers.getJustice().getValue(), 2);
        distance += Math.pow(this.Nationalisme.getValue() - pers.getNationalisme().getValue(), 2);
        distance += Math.pow(this.Productivisme.getValue() - pers.getProductivisme().getValue(), 2);
        distance = (float)Math.sqrt(distance);
        return distance;

    }
}
