public class Maiuscolo implements Formattazione {
    @Override 
    public String applica(String testo){
        return testo.toUpperCase();
    }
}
