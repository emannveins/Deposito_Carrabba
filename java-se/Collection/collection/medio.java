
import java.util.ArrayList;
import java.util.List;

public class medio {
    public static void main(String[] args) {

        List<String> brani = new ArrayList(List.of("intro","groove","ballad","finale"));

        brani.remove(2);
        brani.add(0,"sorpresa");

        // stampa playlist
        brani.forEach(System.out::println);
        // stampa numero brani
        System.out.println("Numero brani"+ brani.size());

    }
}
