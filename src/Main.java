import java.io.IOException;
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
