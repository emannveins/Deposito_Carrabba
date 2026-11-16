
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class es2 {

    public static void main(String[] args) {

        List<String> frutta = new ArrayList<>( List.of("kiwi", "banana", "mela", "ananas","pera", "fico", "arancia") );

        // consumer (stampa una parola)
        Consumer<String> stampa = parola -> System.out.println(parola);
        frutta.forEach(stampa);

        // predicate (individua parole di 4 caratteri o meno)
        Predicate<String> corta = parola -> parola.length() <= 4;
        frutta.removeIf(corta);

        
        // comparator (ordina per, lunghezza decrescente a parità di lunghezza sempre ordine alfabetico)
        Comparator<String> ordinamento = (a, b) -> { int confrontoLunghezza =   Integer.compare(b.length(), a.length());
            if (confrontoLunghezza != 0) {
                return confrontoLunghezza;
            }
            return a.compareTo(b);
        };

        frutta.sort(ordinamento);


        // stampa finale
        System.out.println();
        frutta.forEach(stampa);
    }
}
