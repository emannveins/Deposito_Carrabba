public class MoltiplicaComando implements Comando {
    @Override
    public String esegui(int a, int b) {
        return String.valueOf(a * b);
    }
}