
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class difficile {

    public static void main(String[] args) {

        // TreeMap: ordina automaticamente i titoli alfabeticamente.
        Map<String, Double> alfabetico = new TreeMap<>();

        // LinkedHashMap: mantiene l'ordine di inserimento dei dati.
        Map<String, Double> ordineArrivo = new LinkedHashMap<>();

        // Inserimento degli incassi
        alfabetico.put("Avatar", 15000.0);
        alfabetico.put("Dune", 12000.0);
        alfabetico.put("Barbie", 18000.0);
        alfabetico.put("Oppenheimer", 14000.0);

        ordineArrivo.put("Avatar", 15000.0);
        ordineArrivo.put("Dune", 12000.0);
        ordineArrivo.put("Barbie", 18000.0);
        ordineArrivo.put("Oppenheimer", 14000.0);

        // Stampo elenco alfabetico
        System.out.println("ORDINE ALFABETICO:");
        alfabetico.forEach((film, incasso) ->
            System.out.println(film + ": " + incasso)
        );

        // Stampo ordine di arrivo
        System.out.println("\nORDINE DI ARRIVO:");
        ordineArrivo.forEach((film, incasso) ->
            System.out.println(film + ": " + incasso)
        );
    }
}
