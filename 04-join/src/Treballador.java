import java.util.Random;

public class Treballador extends Thread {
    private float souAnualBrut;
    private int edatIniciTreball;
    private int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private Random rnd;

    public int getEdatActual() {
        return edatActual;
    }

    public void setEdatActual(int edatActual) {
        this.edatActual = edatActual;
    }

    public float getCobrat() {
        return cobrat;
    }

    public void setCobrat(float cobrat) {
        this.cobrat = cobrat;
    }

    public int getEdatIniciTreball() {
        return edatIniciTreball;
    }

    public void setEdatIniciTreball(int edatIniciTreball) {
        this.edatIniciTreball = edatIniciTreball;
    }

    public int getEdatFiTreball() {
        return edatFiTreball;
    }

    public void setEdatFiTreball(int edatFiTreball) {
        this.edatFiTreball = edatFiTreball;
    }

    public float getSouAnualBrut() {
        return souAnualBrut;
    }

    public void setSouAnualBrut(float souAnualBrut) {
        this.souAnualBrut = souAnualBrut;
    }

    public Treballador(String name, float souAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(name);
        this.souAnualBrut = souAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0;
    }

    public void cobra() {
        setCobrat(getCobrat() + getSouAnualBrut() / 12);
    }

    public void pagaImpostos() {
        float souMensual = getSouAnualBrut() / 12;
        float impostos = (souMensual * 24) / 100;

        setCobrat(getCobrat() - impostos);
    }

    @Override
    public void run() {
        int mes = 1;
        while (true) {
            if (edatActual == 0) {
                edatActual = edatIniciTreball;
            } else if (edatActual == edatFiTreball) break;
            cobra();
            pagaImpostos();
            if (mes < 12) {
                mes += 1;
            } else {
                mes = 1;
                edatActual += 1;
            }
            
        }
        System.out.printf("%s -> edat: %d / total: %.2f%n", getName(), getEdatActual(), getCobrat() );
    }
    
}
