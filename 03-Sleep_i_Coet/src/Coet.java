import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Coet {

    public static Random rand = new Random();
    public static Motor[] engines = new Motor[4];

    public static void passaAPotencia(int p) {
        if (p >= 0 && p <= 10) {
            System.out.printf("Pasant a potencia %d", p);
            for (Motor engine : engines) {
                engine.setPower(p);
            }
        } else {
            System.out.println("Potencia no valida");
        }
    }
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++ ) {
            engines[i] = new Motor(rand);
            engines[i].start();
        }

        while (true) {
            try {
                String strPower = reader.readLine();
                int objectivePower = Integer.parseInt(strPower);
                passaAPotencia(objectivePower);
                if (objectivePower == 0) break;
            } catch (Exception e) {
                e.printStackTrace();
            } 
            
        }
    }
}
