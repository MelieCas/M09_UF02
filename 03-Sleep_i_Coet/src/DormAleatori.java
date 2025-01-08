import java.util.Random;

public class DormAleatori extends Thread {

    public Random rand = new Random();
    
    public long timeConst;
    
    public long sleepTime;

    public DormAleatori(String name) {
        super(name);
        sleepTime = rand.nextLong(1000);
        timeConst = System.currentTimeMillis();
        System.out.printf("%s(0) a dormir %dms total 1%n", getName(), sleepTime);
        try {
            sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            sleepTime = rand.nextLong(1000);
            System.out.printf("%s(%d) a dormir %dms total %d%n", getName(), i, sleepTime, System.currentTimeMillis() - timeConst);
            try {
                sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");
        joan.start();
        pep.start();
        System.out.println("--- Fi de main -------");
        
    }
}
