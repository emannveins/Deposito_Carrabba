public class mPrimaLettera implements Formattazione {
    @Override
    public String applica(String testo) {

        String[] parole = testo.split(" ");
        String risultato = "";

        for (String parola : parole) {
            String prima = parola.substring(0, 1).toUpperCase();
            String resto = parola.substring(1).toLowerCase();
            risultato += prima + resto + " ";
        }
        return risultato.trim();
    }
}