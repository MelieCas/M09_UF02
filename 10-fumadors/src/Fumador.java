import java.util.Random;

public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac = null;
    private Llumi llumi = null;
    private Paper paper = null;
    private int numFumades;
    private Random rand;

    public Fumador(Random rand, Estanc estanc, int id) {
        this.rand = rand;
        this.estanc = estanc;
        this.id = id;
        numFumades = 0;
    }

    public void fuma() {
        if (tabac != null && llumi != null && paper != null) {
            System.out.printf("Fumador %d fumant", id);
            paper = null;
            tabac = null;
            llumi = null;
            numFumades++;
            System.out.printf("Fumador %d ha fumat %d vegades%n", id, numFumades);
            try {
                sleep(rand.nextInt(500, 1501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void compraTabac() {
        tabac = estanc.venTabac();
        if (tabac != null) System.out.printf("Fumador %d comprant Tabac%n", id);
    }

    public void compraLlumi() {
        llumi = estanc.venLlumi();
        if (llumi != null) System.out.printf("Fumador %d comprant Llumi%n", id);
    }

    public void compraPaper() {
        paper = estanc.venPaper();
        if (paper != null) System.out.printf("Fumador %d comprant Paper%n", id);
    }

    @Override
    public void run() {
        while (numFumades < 3) {
            if (tabac == null) compraTabac();
            if (paper == null) compraPaper();
            if (llumi == null) compraLlumi();
            fuma();
            try {
                sleep(rand.nextInt(500, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
