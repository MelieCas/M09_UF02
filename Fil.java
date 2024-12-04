
public class Fil extends Thread {
    public String name;
    public Fil(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el fill " + name);
    }
    
}