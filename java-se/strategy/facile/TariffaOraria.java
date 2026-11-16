public class TariffaOraria implements Tariffa {
    @Override 
    public double Costo(double orario){
        return orario*2.0;
    }

}
