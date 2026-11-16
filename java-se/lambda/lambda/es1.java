
import java.util.Arrays;
import java.util.List;

/*
Esercizio 1 (Facile): lambda con zero, uno e più parametri

**Obiettivo:** scrivere lambda con un parametro e con due parametri, usando solo liste e array. Niente stream e niente interfacce funzionali da dichiarare o nominare.

**Compito:** in una classe `Esercizio1` con un `main` (con gli import necessari), scrivi tre lambda e usale:

1. **Un parametro:** crea `List<Integer> numeri = List.of(1, 2, 3)` e usa `forEach` con una lambda che stampa ogni numero moltiplicato per 2.
2. **Due parametri:** crea l'array `String[] parole = {"mondo", "a", "ciao"}` e ordinalo per lunghezza con `Arrays.sort(parole, (x, y) -> ...)`. Poi stampa `Arrays.toString(parole)`.

*/

public class es1 {
    public static void main(String[] args){

        // lambda 1 (stampa il doppio)
        List<Integer> numeri = List.of(1,2,3);
        numeri.forEach(numero ->System.out.println(numero*2));

        // lambda 2 (ordine in base alla lunghezza delle parole)
        String[] parole = {"mondo","a","ciao"};
        Arrays.sort(parole,(x,y) -> x.length()-y.length());
        System.out.println(Arrays.toString(parole));


    }

}
