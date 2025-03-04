import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Taula {
    private static Random rand = new Random();
    private List<Filosof> comensals = new ArrayList<Filosof>();
    private List<Forquilla> forquilles = new ArrayList<Forquilla>();

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }

    public Taula(int numeroFilosofs) {
        for (int i = 0; i < numeroFilosofs; i++) {
            comensals.add(new Filosof(String.format("%d", i), rand));
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numeroFilosofs; i++) {
            Filosof filosof = comensals.get(i);
            filosof.setForquillaEsquerra(forquilles.get(i));
            if (i < numeroFilosofs - 1) {
                filosof.setForquillaDreta(forquilles.get(i + 1));
            } else {
                filosof.setForquillaDreta(forquilles.get(0));
            }
        }
    }

    public void showTaula() {
        for (Filosof filosof : comensals) {
            System.out.printf("Comensal: fil%s esq: %d dret: %d%n", filosof.getName(), filosof.getForquillaEsquerra().getNumero(), filosof.getForquillaDreta().getNumero());

        }
        System.out.println("-------------------------");

    }

    public void cridarATaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }

}
