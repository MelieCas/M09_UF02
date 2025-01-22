public class Associacio {
    private int numSocis;
    private Soci[] socis;

    public Associacio () {
        numSocis = 1000;
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis() {
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f", socis[0].getCompte().getSaldo());
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
    
}