import java.util.Random;

public class Assistent extends Thread {
    private static Random rand = new Random();
    private Esdeveniment esdeveniment;
    

    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) {
            long randOpt = rand.nextLong(1, 11);
            if (randOpt <= 3) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                sleep(rand.nextLong(0, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
