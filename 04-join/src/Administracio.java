public class Administracio {
    private static int numPoblacioActiva = 50;
    private static Treballador[] poblacioActiva = new Treballador[numPoblacioActiva];


    public Administracio() {
        for (int i = 0; i < numPoblacioActiva; i++) {
            String nomCiutada = "Ciutada-" + i;
            poblacioActiva[i] = new Treballador(nomCiutada, 25000, 20, 65);
        }
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        for (Treballador ciutada : poblacioActiva) {
            ciutada.start();
            try {
                ciutada.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
