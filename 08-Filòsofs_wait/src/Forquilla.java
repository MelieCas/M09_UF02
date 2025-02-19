public class Forquilla {
    private static final int LLIURE = -1;

    private int propietari;
    private boolean enUs;
    private int numero;

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public static int getLliure() {
        return LLIURE;
    }
    
    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}
