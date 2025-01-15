import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual;
    private int potenciaObjectiu;
    private Random rand;
    private final int id;

    public Motor(int id, Random rand) {
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.id = id;
        this.rand = rand;
    }

    public void setPotencia(int potenciaObjectiu) {
            this.potenciaObjectiu = potenciaObjectiu;
    }

    @Override
    public void run() {
        while (true) {
            while (potenciaActual != potenciaObjectiu) {
                if (potenciaActual < potenciaObjectiu) {
                    System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n", id, potenciaObjectiu, potenciaActual);
                    potenciaActual += 1;
                    if (potenciaActual == potenciaObjectiu) {
                        System.out.printf("Motor %d: Fer res Objectiu: %d Actual: %d%n", id, potenciaObjectiu, potenciaActual);
                    }
                    try {
                        sleep(rand.nextLong(100, 300));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (potenciaActual > potenciaObjectiu) {
                    System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n", id, potenciaObjectiu, potenciaActual);
                    potenciaActual -= 1;
                    if (potenciaActual == potenciaObjectiu) {
                        System.out.printf("Motor %d: Fer res Objectiu: %d Actual: %d%n", id, potenciaObjectiu, potenciaActual);
                    }
                    try {
                        sleep(rand.nextLong(100,300));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (potenciaActual == 0) break;
        }
    }
}