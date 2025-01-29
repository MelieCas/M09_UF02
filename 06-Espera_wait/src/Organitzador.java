public class Organitzador {
    public static void main(String[] args) {
        Assistent[] assistents = new Assistent[10];
        Esdeveniment esdeveniment = new Esdeveniment(5);
        for (int i = 0; i < 10; i++) {
            String nomAssistent = String.format("Assistent-%d", i);
            assistents[i] = new Assistent(nomAssistent, esdeveniment);
        }

        for (Assistent assistent : assistents) {
            assistent.start();
        }
    }
}
