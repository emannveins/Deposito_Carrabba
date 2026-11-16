
// distributore con credito in euro
public enum Distributore {

    INSTANCE;

    private double credito = 0.0;

    public synchronized void inserisci(double importo) {
        credito += importo;
    }

    public boolean eroga(double prezzo) {
        if (credito >= prezzo) {
            credito -= prezzo;
            return true;
        }
        return false;
    }

    public double getCredito() {
        return credito;
    }
}
