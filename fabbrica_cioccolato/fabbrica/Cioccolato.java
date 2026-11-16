public abstract class Cioccolato {
    private String tipoCioccolato;
    private double percentualeCacao;

    public Cioccolato(String tipoCioccolato, double percentualeCacao){
        super();
        this.tipoCioccolato = tipoCioccolato;
        this.percentualeCacao = percentualeCacao;
    }
    
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ tipoCioccolato);
        System.out.println();
        System.out.println("percentuale di cacao: "+ percentualeCacao);
    }

    public abstract int getQuantitaCioccolato();
    public abstract double getCosto();

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
