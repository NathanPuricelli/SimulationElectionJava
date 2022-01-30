import java.io.IOException;
/**
 * <b>Classe principale du programme appelée lors de l'execution
 * @author Nathan Puricelli, Aymeric Leto
 */
public class Main {

    public static void main(String[] args){       
        try{
            Simulation s = new Simulation(); 
            s.simuler();
        }
        catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

}
