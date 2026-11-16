public class TariffaGiornaliera implements Tariffa {
    @Override 
    public double Costo(double orario){
        return orario*10.0;
    }

}