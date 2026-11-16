public abstract class Cioccolato {
    private String tipoCioccolato;
    private double percentualeCacao;

    public Cioccolato(String tipoCioccolato, double percentualeCacao){
        this.tipoCioccolato = tipoCioccolato;
        this.percentualeCacao = percentualeCacao;
    }
    
    public void prpoduce(){
        System.out.println("tipo di cioccolato: "+ tipoCioccolato);
        System.out.println("percentuale di cacao: "+ percentualeCacao +"%");
    }


    // metodi abstract
    public abstract int getQuantitaCioccolato();
    public abstract double getCosto();



    // getter e setter
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
