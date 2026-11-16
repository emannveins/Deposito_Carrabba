public class Main {

    public static void main(String[] args) {

        // termostati
        Termostato t1 = Termostato.getInstance();
        Termostato t2 = Termostato.getInstance();

        
        t1.setTemperatura(22.5);

        // stampa tutto
        System.out.println(t1.getTemperatura());
        System.out.println(t2.getTemperatura());
        System.out.println(t1 == t2);
    }
}