public class Cioccolato {
    private String tipoCioccolato;
    private double percentualeCacao;
    private int quantita; // max (100 x day)

    public Cioccolato(){
        super();
    }
    
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ tipoCioccolato);
        System.out.println();
        System.out.println("percentuale di cacao: "+ percentualeCacao);
    }
    public String getTipoCioccolato() {
        return tipoCioccolato;
    }

    public void setTipoCioccolato(String tipoCioccolato) {
        this.tipoCioccolato = tipoCioccolato;
    }

    public double getPercentualeCacao() {
        return percentualeCacao;
    }

    public void setPercentualeCacao(double percentualeCacao) {
        this.percentualeCacao = percentualeCacao;
    }

}
