import java.util.Optional;

public class ComandoFactory {

    public static Optional<Comando> create(String nome) {

        if (nome == null) {return Optional.empty();}

        switch (nome) {
            case "somma":
                return Optional.of(new SommaComando());

            case "moltiplica":
                return Optional.of(new MoltiplicaComando());
            default:
                return Optional.empty();
        }
    }
}