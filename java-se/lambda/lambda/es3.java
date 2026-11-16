import java.util.Comparator;
import java.util.List;

public class es3 {
    public static void main(String[] args) {
        List<Ordine> ordini = List.of(
            new Ordine("Anna", "Mouse", 2, 25.0),
            new Ordine("Luca", "Monitor", 1, 199.0),
            new Ordine("Anna", "Tastiera", 1, 45.0),
            new Ordine("Marta", "Mouse", 3, 25.0),
            new Ordine("Luca", "Webcam", 2, 60.0),
            new Ordine("Paolo", "Monitor", 2, 199.0));
        
            // nomi prodotti senza doppi e in ordine alfabetico
            ordini.stream()
                .map(ordine->ordine.prodotto())
                .distinct()
                .sorted()
                .forEach(System.out :: println);

            System.out.println();

            // totale incassato 
            double totale = ordini.stream()
                .mapToDouble(ordine->ordine.totale())
                .sum();
            System.out.println(totale);
            System.out.println();

            // clienti con ordine totale piu alto di 100 e
            ordini.stream()
                .filter(ordine -> ordine.totale() > 100)
                .map(ordine->ordine.cliente())
                .distinct()
                .sorted()
                .forEach(System.out :: println);
            System.out.println();

            // oriine con totale piu alto
            String migliore = ordini.stream()
                .max(Comparator.comparingDouble(ordine -> ordine.totale()))
                .map(ordine -> ordine.cliente() + " - " + ordine.prodotto())
                .orElse("Nessun ordine");
                System.out.println(migliore);

            System.out.println();
    }
}
