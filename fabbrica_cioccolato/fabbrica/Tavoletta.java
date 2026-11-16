public class Tavoletta extends Cioccolato{
    private double peso;
    private boolean aggiunte;
    private int numeroCioccolatini;

    public Tavoletta() {
        super();
    }

    @Override 
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ getTipoCioccolato());
        System.out.println();
        System.out.println("percentuale di cacao: "+ getPercentualeCacao());
        System.out.println("numero cioccolatini: "+ numeroCioccolatini);
    }


}
