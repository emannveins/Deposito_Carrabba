public class Cioccolatino extends Cioccolato{
    private String forma;
    private String ripieno;
    private int quantita;

    public Cioccolatino(String tipo, double cacao, String forma, String ripieno, int quantita){
        super(tipo, cacao);
        this.forma = forma;
        this.ripieno = ripieno;
        this.quantita = quantita;
    }
    @Override 
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ getTipoCioccolato());
        System.out.println("percentuale di cacao: "+ getPercentualeCacao());
        System.out.println("quantita: "+ quantita);
    }
    @Override
    public int getQuantitaCioccolato() {
        return quantita;
    }
    @Override
    public double getCosto() {
        return quantita * 2;
    }
}
