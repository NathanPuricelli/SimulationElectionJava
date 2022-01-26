package Personnes;

public class Political_axis {
    private float value;

    public Political_axis(){
        this.value = (float)Math.random();
    }

    public Political_axis(float value){
        this.value = value;
    }

    public float getValue(){
        return this.value;
    }

    public void setValue(float p_value){
        this.value = p_value;
    }
}
