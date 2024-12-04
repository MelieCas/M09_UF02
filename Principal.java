

import java.util.concurrent.TimeUnit;

public class Principal {

    public static void main(String[] args) {
        
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        juan.start();
        pepe.start();
        
        
        System.out.println("Termina Thread Main");

        
    }
}