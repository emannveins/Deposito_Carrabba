public class Termostato {
    // dichiaro l'istanza come static 
    private static final Termostato INSTANCE = new Termostato();
    // temperatura iniziale
    private double temperatura = 20.0;
    // costruttore  privato
    private Termostato() {
    }

    public static Termostato getInstance() {
        return INSTANCE;
    }

    // getter e setter
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}