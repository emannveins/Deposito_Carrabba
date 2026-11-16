public class Inverti implements Formattazione {
    @Override
    public String applica(String testo) {
        return new StringBuilder(testo).reverse().toString();
    }
}
