import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    private List<Tabac> tabacs;
    private List<Llumi> llumis;
    private List<Paper> papers;
    private Random rand;
    private boolean open = true;

    public Estanc(Random rand) {
        tabacs = new ArrayList<Tabac>();
        llumis = new ArrayList<Llumi>();
        papers = new ArrayList<Paper>();
        this.rand = rand;
    }

    public synchronized void nouSubministrament() {
        int option = rand.nextInt(1,4);
        switch (option) {
            case 1:
                addLlumi();
                System.out.println("Afegint Llumí");
                break;
            case 2:
                addPaper();
                System.out.println("Afegint Paper");
                break;
            case 3:
                addTabac();
                System.out.println("Afegint Tabac");
                break;
        }
        notifyAll();
    }

    public void addTabac() {
        tabacs.add(new Tabac());
    }

    public void addLlumi() {
        llumis.add(new Llumi());
    }

    public void addPaper() {
        papers.add(new Paper());
    }

    public synchronized Tabac venTabac() {
        if (tabacs.size() > 0) {
            return tabacs.removeLast();
        } else {
            try {
                wait();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized Llumi venLlumi() {
        if (llumis.size() > 0) {
            return llumis.removeLast();
        } else {
            try {
                wait();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized Paper venPaper() {
        if (papers.size() > 0) {
            return papers.removeLast();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void tancarEstanc() {
        open = false;
    }

    @Override
    public void run() {
        while (open) {
            try {
                sleep(rand.nextInt(500, 1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nouSubministrament();
            try {
                sleep(rand.nextInt(500, 1501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
