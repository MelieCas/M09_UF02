import java.util.Random;
import java.util.Scanner;

public class Coet {
    private Motor[] motors;
    private Random rand = new Random();

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i, rand);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: La potència ha de ser entre 0 i 10.");
        } else {
            System.out.println("Passant a potència " + p);
            for (Motor motor : motors) {
                motor.setPotencia(p);
            }
        }
    }

    public void arranca() {
        Scanner scanner = new Scanner(System.in);
        int potenciaObjectiu;
        System.out.print("Introdueix la potència objectiu (0 per aturar): ");
        potenciaObjectiu = scanner.nextInt();
        passaAPotencia(potenciaObjectiu);
        for (Motor motor : motors) {
            motor.start();
        }
        
        while (true) {
            potenciaObjectiu = scanner.nextInt();

            if (potenciaObjectiu == 0) {
                passaAPotencia(0); // Atura tots els motors.
                break; // Sortim del bucle quan la potència és 0.
            }

            passaAPotencia(potenciaObjectiu);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();
    }

}