import java.util.Random;

public class Filosof extends Thread {
    private Random rand;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    
    
    public Filosof(String nom, Random rand) {
        super(nom);
        this.rand = rand;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int getGana() {
        return gana;
    }

    public void setGana(int gana) {
        this.gana = gana;
    }


    public void menjar() {
        while (true) {
            if (!forquillaEsquerra.isEnUs()) {
                forquillaEsquerra.setEnUs(true);
                System.out.printf("Filòsof: %s agafa la forquilla esquerra %d%n", getName(), forquillaEsquerra.getNumero());
                if (!forquillaDreta.isEnUs()) {
                    forquillaDreta.setEnUs(true);
                    System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", getName(), forquillaDreta.getNumero());
                    System.out.printf("Filòsof: %s menja%n", getName());
                    try {
                        sleep(rand.nextLong(1000, 2000));
                        gana = 0;
                        System.out.printf("Filòsof: %s ha acabat de menjar%n", getName());
                        forquillaEsquerra.setEnUs(false);
                        forquillaDreta.setEnUs(false);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    forquillaEsquerra.setEnUs(false);
                    System.out.printf("Filòsof: %s deixa l'esquerra(%d) i espera (dreta ocupada)%n", getName(), forquillaEsquerra.getNumero());
                    gana++;
                    System.out.printf("Filòsof: %s gana=%d%n", getName(), gana);
                    try {
                        sleep(rand.nextLong(500, 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.printf("Filòsof: %s no ha agafat forquilla%n", getName());
                gana++;
                System.out.printf("Filòsof: %s gana=%d%n", getName(), gana);
                try {
                    sleep(rand.nextLong(500, 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pensar() {
        System.out.printf("Filòsof: %s pensant%n", getName());
        try {
            sleep(rand.nextLong(1000, 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            int opcio = rand.nextInt(1, 3);
            if (opcio == 1) {
                menjar();
            } else {
                pensar();
            }
        }
    }

}
