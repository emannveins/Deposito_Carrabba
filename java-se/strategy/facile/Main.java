public class Main {
    public static void main(String[] args) {
        Tariffa tariffa_1 = new TariffaOraria();
        System.out.println("costo: "+ tariffa_1.Costo(5.0));

        // strategia 2
        tariffa_1 = new TariffaGiornaliera();
        System.out.println("costo: "+ tariffa_1.Costo(5.0));

    }
}
