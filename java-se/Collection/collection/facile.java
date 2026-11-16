import java.util.Arrays;
import java.util.stream.IntStream;

public class facile {

    public static void main(String[] args) {

        // trovare il valore massimo
        double[] temperature = {
            12.5, 15.0, 9.8, 18.2, 14.0, 11.3, 16.7
        };

        String[] giorni = {
            "Lunedì", "Martedì", "Mercoledì",
            "Giovedì", "Venerdì", "Sabato", "Domenica"
        };

        // temperatura più alta
        double max = Arrays.stream(temperature)
                           .max()
                           .getAsDouble();

        // giorno in cui si è registrata
        int indice = IntStream.range(0, temperature.length)
                              .filter(i -> temperature[i] == max)
                              .findFirst()
                              .getAsInt();

        // stampa
        System.out.println("Temperatura massima: " + max);
        System.out.println("Giorno: " + giorni[indice]);
    }
}