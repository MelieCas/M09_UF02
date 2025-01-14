import java.util.Random;

public class Motor implements Runnable {
    private int potenciaActual;
    private int potenciaObjectiu;
    private final int id;

    public Motor(int id) {
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.id = id;
    }

    public synchronized void setPotencia(int p) {
        if (p >= 0 && p <= 10) {
            this.potenciaObjectiu = p;
            new Thread(this).start(); // Llença un nou fil per simular el canvi de potència.
        } else {
            System.out.println("Potència no vàlida. Ha de ser entre 0 i 10.");
        }
    }

    @Override
    public void run() {
        try {
            if (potenciaObjectiu == potenciaActual) {
                System.out.println("Motor " + id + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                return;
            }

            System.out.println("Motor " + id + ": Passant a potència " + potenciaObjectiu);
            while (potenciaActual != potenciaObjectiu) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.println("Motor " + id + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                } else {
                    potenciaActual--;
                    System.out.println("Motor " + id + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }

                // Espera aleatòria entre 1 i 2 segons.
                Random random = new Random();
                int delay = 1000 + random.nextInt(1000); // 1 a 2 segons
                Thread.sleep(delay);
            }

            System.out.println("Motor " + id + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}