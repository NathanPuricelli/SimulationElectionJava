package Personnes;

public class Axe_politique {
    private float value;

    public Axe_politique(){
        this.value = (float)Math.random();
    }

    public Axe_politique(float value){
        this.value = value;
    }

    public float getValue(){
        return this.value;
    }

    public void setValue(float p_value){
        this.value = p_value;
    }
}
