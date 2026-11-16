public class CioccolatoCaldo extends Cioccolato {

    private double temperatura;
    private double densita;
    private double cioccolatoUsato;

    public CioccolatoCaldo() {
        super();
    }

    @Override 
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ getTipoCioccolato());
        System.out.println();
        System.out.println("percentuale di cacao: "+ getPercentualeCacao());
        System.out.println("cioccolato usato: "+ cioccolatoUsato);
    }

}
