import java.util.Optional;
public class Main {

    public static void main(String[] args) {
        eseguiComando("somma 2 3");
        eseguiComando("moltiplica 4 5");
        eseguiComando("divisione 10 2");
    }

    public static void eseguiComando(String input) {

        String[] parti = input.trim().split("\\s+");

        if (parti.length != 3) {
            System.out.println("Formato non valido");
            return;
        }

        String nome = parti[0];

        int a;
        int b;

        try {

            a = Integer.parseInt(parti[1]);
            b = Integer.parseInt(parti[2]);

        } catch (NumberFormatException e) {

            System.out.println("Numeri non validi");
            return;

        }

        Optional<Comando> comandoOpt = ComandoFactory.crea(nome);

        if (comandoOpt.isPresent()) {

            Comando comando = comandoOpt.get();

            String risultato = comando.esegui(a, b);

            System.out.println("Risultato: " + risultato);

        } else {

            System.out.println("Comando sconosciuto!");

        }
    }
}