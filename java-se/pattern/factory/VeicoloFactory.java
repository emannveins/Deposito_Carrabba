public class VeicoloFactory {

    public static Veicolo crea(String tipo) {

        if (tipo == null) {
            throw new IllegalArgumentException("Tipo non valido");
        }

        switch (tipo) {

            case "auto":
                return new Auto();

            case "moto":
                return new Moto();

            default:
            throw new IllegalArgumentException( "errore!");
        }
    }
}