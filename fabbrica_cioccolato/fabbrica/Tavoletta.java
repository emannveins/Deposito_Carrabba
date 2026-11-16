public class Tavoletta extends Cioccolato{

    private int peso;
    private boolean aggiunte;
    private int numeroCioccolatini;

    public Tavoletta(String tipo, double cacao, int peso, boolean aggiunte, int numeroCioccolatini) {
        super(tipo,cacao);
        this.peso = peso;
        this.aggiunte = aggiunte;
        this.numeroCioccolatini = numeroCioccolatini;
    }

    @Override 
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ getTipoCioccolato());
        System.out.println("percentuale di cacao: "+ getPercentualeCacao());
        System.out.println("numero cioccolatini: "+ numeroCioccolatini);
    }
     @Override
    public int getQuantitaCioccolato() {
        return peso;
    }

    @Override
    public double getCosto() {
        return peso*4;
    }


}
