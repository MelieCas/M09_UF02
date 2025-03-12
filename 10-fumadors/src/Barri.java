import java.util.Random;

public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors; 
    private Random rand = new Random();

    public Barri() {
        estanc = new Estanc(rand);
        fumadors = new Fumador[3];
        for(int i = 0; i < fumadors.length; i++) {
            fumadors[i] = new Fumador(rand, estanc, i + 1);
        }
        
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.estanc.start();
        for (Fumador fumador : barri.fumadors) {
            fumador.start();
        }
        while (true) {
            if (!barri.fumadors[0].isAlive() && !barri.fumadors[1].isAlive() && !barri.fumadors[2].isAlive()) {
                barri.estanc.tancarEstanc();
                break;
            }
        }
        
    
    }

}
