public class Main {

    public static void main(String[] args) {

        Distributore distributore = Distributore.INSTANCE;

        distributore.inserisci(5.0);

        // acquisti
        boolean acquisto_1 = distributore.eroga(2.0);
        boolean acquisto_2 = distributore.eroga(4.0);

        // stampa
        System.out.println("acquisto 1: " + acquisto_1);
        System.out.println("acquisto 2: " + acquisto_2);

        System.out.println("credito residuo: " +  distributore.getCredito());
    }
}