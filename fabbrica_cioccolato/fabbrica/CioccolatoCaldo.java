public class CioccolatoCaldo extends Cioccolato {

    private double temperatura;
    private double densita;
    private int quantita;

    public CioccolatoCaldo(String tipo, double cacao,double temperatura, double densita, int quantita) {
          super(tipo, cacao);

        if (quantita < 20) {
            throw new IllegalArgumentException("La quantita minima è 20!");
        }

        this.temperatura = temperatura;
        this.densita = densita;
        this.quantita = quantita;
    }

    @Override
    public void produce() {
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Densita: " + densita);
        System.out.println("Quantita di cioccolato: " + quantita);
    }

    @Override
    public int getQuantitaCioccolato() {
        return quantita;
    }

    @Override
    public double getCosto() {
        return 20;
    }

}
