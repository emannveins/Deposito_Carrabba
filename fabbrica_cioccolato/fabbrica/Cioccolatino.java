public class Cioccolatino extends Cioccolato{
    private String forma;
    private String ripieno;
    private int costo = 2;
    private int calcolo;

    public Cioccolatino(){
        super();
    }
    @Override 
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ getTipoCioccolato());
        System.out.println();
        System.out.println("percentuale di cacao: "+ getPercentualeCacao());
    }
   
}
