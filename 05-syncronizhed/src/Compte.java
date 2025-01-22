public class Compte {
    private float saldo;
    private static Compte compte = new Compte();

    private Compte() {
        this.saldo = 0;
    }

    public static Compte getCompte() {
        return compte;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
