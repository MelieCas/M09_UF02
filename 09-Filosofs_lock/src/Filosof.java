import java.util.Random;

public class Filosof extends Thread {
    private Random rand;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    private int iniciGana;
    private int fiGana;
    
    public Filosof(String nom, Random rand) {
        super(nom);
        this.rand = rand;
    }
    
    public int getIniciGana() {
        return iniciGana;
    }

    public void setIniciGana(int iniciGana) {
        this.iniciGana = iniciGana;
    }

    public int getFiGana() {
        return fiGana;
    }

    public void setFiGana(int fiGana) {
        this.fiGana = fiGana;
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
            if (!forquillaDreta.isEnUs()) {
                agafarForquillaDreta();
                System.out.printf("Filòsof: fil%s te forquilles esq(%d) dreta(%d)%n", getName(), forquillaEsquerra.getNumero(), forquillaDreta.getNumero());
                System.out.printf("Filòsof: fil%s menja%n", getName());
                try {
                    fiGana = (int) (System.currentTimeMillis() / 1000);
                    gana = calcularGana();
                    sleep(rand.nextLong(1000, 2000));
                    System.out.printf("Filòsof: fil%s ha acabat de menjar amb gana %d%n", getName(), getGana());
                    System.out.printf("Fil%s deixa les forquilles%n", getName());
                    deixarForquilles();
                    resetGana();
                    
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                deixarForquilles();
                try {
                    sleep(rand.nextLong(500, 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                sleep(rand.nextLong(500, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    public synchronized void agafarForquillaEsquerra() {
        forquillaEsquerra.setEnUs(true);
        forquillaEsquerra.agafar();
        forquillaEsquerra.setPropietari(Integer.parseInt(getName()));
        
    }

    public synchronized void agafarForquillaDreta() {
        forquillaDreta.setEnUs(true);
        forquillaDreta.agafar();
        forquillaDreta.setPropietari(Integer.parseInt(getName()));

    }

    public synchronized void deixarForquilles() {
        if (forquillaDreta.getPropietari() == Integer.parseInt(getName())) {
            forquillaDreta.setEnUs(false);
            forquillaDreta.deixar();
            forquillaDreta.setPropietari(Forquilla.getLliure());
        }
    
        if (forquillaEsquerra.getPropietari() == Integer.parseInt(getName())) {
            forquillaEsquerra.setEnUs(false);
            forquillaEsquerra.deixar();
            forquillaEsquerra.setPropietari(Forquilla.getLliure());
        }
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

    public int calcularGana() {
        if (fiGana != 0 && iniciGana != 0) {
            gana = fiGana - iniciGana; 
        }
        return gana;
    }

    public void resetGana() {
        iniciGana = (int) (System.currentTimeMillis() / 1000); 
        gana = 0; 
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
