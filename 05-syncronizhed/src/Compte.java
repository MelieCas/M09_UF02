public class Compte {
    private float saldo;
    private static Compte compte = null;

    private Compte() {
        this.saldo = 0;
    }

    public static Compte getCompte() {
        if (compte == null) compte = new Compte();
        return compte;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
