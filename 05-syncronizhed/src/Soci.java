import java.util.Random;

public class Soci extends Thread {
    private Compte compte;

    private float aportacio;

    private long esperaMax;

    private Random rand;

    private int maxAnys;

    public Soci() {
        this.compte = Compte.getCompte();
        this.aportacio = 10;
        this.esperaMax = 100;
        this.rand = new Random();
        this.maxAnys = 10;
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxAnys; i++) {
            for (int j = 1; j <= 12; j++) {
                synchronized (compte) {
                    if (j % 2 == 0) {
                        compte.setSaldo(compte.getSaldo() + aportacio);
                    } else {
                        compte.setSaldo(compte.getSaldo() - aportacio);
                    }
                }
                try {
                    sleep(rand.nextLong(esperaMax));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }
    }
}
