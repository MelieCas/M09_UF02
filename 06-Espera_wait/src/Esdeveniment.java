import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private List<Assistent> assistents = new ArrayList<Assistent>();
    private int placesDisponibles;
    

    public Esdeveniment(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
    }

    public synchronized void ferReserva(Assistent assistent) {
        
        while (placesDisponibles <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        placesDisponibles = placesDisponibles - 1;
        System.out.printf("%s ha fet una reserva. Places disponibles: %d%n", assistent.getName(), placesDisponibles);
        assistents.add(assistent);        
        
    }
    
    public synchronized void cancelaReserva(Assistent assistent) {
        if (assistents.indexOf(assistent) == -1) {
            System.out.printf("%s no ha pogut cancel·lar una reserva inexistent. Places disponibles: %d%n", assistent.getName(), placesDisponibles);
        } else {
            assistents.remove(assistent);
            placesDisponibles = placesDisponibles + 1;
            System.out.printf("%s ha cancelat una reserva. Places disponibles: %d%n", assistent.getName(), placesDisponibles);
            notifyAll();
        }
        
    }
}