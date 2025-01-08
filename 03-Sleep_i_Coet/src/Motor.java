import java.util.Random;

public class Motor extends Thread {
    public Random rand;
    
    private int power = 0;

    public Motor(Random rand) {
        this.rand = rand;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int objectivePower) {
        if (power < objectivePower) {
            for(int i = power ; power < objectivePower ; i++ ) {
                power = i;
                try {
                    sleep(rand.nextLong(3));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } else {
            for(int i = power ; power > objectivePower ; i-- ) {
                power = i;
                try {
                    sleep(rand.nextLong(3));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }



}
