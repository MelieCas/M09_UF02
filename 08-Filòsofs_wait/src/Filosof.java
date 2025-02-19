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

    public void agafarForquilles() {
        if (!forquillaEsquerra.isEnUs()) {
            agafarForquillaEsquerra();
            System.out.printf("Filòsof: fil%s agafa la forquilla esquerra %d%n", getName(), forquillaEsquerra.getNumero());
            if (!forquillaDreta.isEnUs()) {
                agafarForquillaDreta();
                System.out.printf("Filòsof: fil%s agafa la forquilla dreta %d%n", getName(), forquillaDreta.getNumero());
                System.out.printf("Filòsof: fil%s menja%n", getName());
                try {
                    sleep(rand.nextLong(1000, 2000));
                    gana = 0;
                    System.out.printf("Filòsof: fil%s ha acabat de menjar%n", getName());
                    deixarForquilles();
                    
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                deixarForquilles();
                System.out.printf("Filòsof: fil%s deixa l'esquerra(%d) i espera (dreta ocupada)%n", getName(), forquillaEsquerra.getNumero());
                gana++;
                System.out.printf("Filòsof: fil%s gana=%d%n", getName(), gana);
                try {
                    synchronized(this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.printf("Filòsof: fil%s no ha agafat forquilla%n", getName());
            gana++;
            System.out.printf("Filòsof: fil%s gana=%d%n", getName(), gana);
            try {
                synchronized(this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    public synchronized void agafarForquillaEsquerra() {
        forquillaEsquerra.setEnUs(true);
        forquillaEsquerra.setPropietari(Integer.parseInt(getName()));
        
    }

    public synchronized void agafarForquillaDreta() {
        forquillaDreta.setEnUs(true);
        forquillaDreta.setPropietari(Integer.parseInt(getName()));

    }

    public synchronized void deixarForquilles() {
        if (forquillaEsquerra.getPropietari() == Integer.parseInt(getName())) {
            forquillaEsquerra.setEnUs(false);
            forquillaEsquerra.setPropietari(Forquilla.getLliure());
        }
        if (forquillaDreta.getPropietari() == Integer.parseInt(getName())) {
            forquillaDreta.setEnUs(false);
            forquillaDreta.setPropietari(Forquilla.getLliure());
        }
        notifyAll();
    }


    public void menjar() {
        while (true) {
            agafarForquilles();
            break;
        }
    }

    public void pensar() {
        System.out.printf("Filòsof: fil%s pensant%n", getName());
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
