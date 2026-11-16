import java.util.List;

public class Main {
    public static void main(String[] args) {
        String testo = "esercizio medio!";
        List<Formattazione> strategie = List.of(new Maiuscolo(), new Inverti(), new mPrimaLettera());

        for(Formattazione strategia : strategie){
            String risultato = strategia.applica(testo);
            System.out.println(risultato);
        }
    }
}
