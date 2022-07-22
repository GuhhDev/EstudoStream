import java.util.Arrays;
import java.util.List;

public class TestesFilter {

    public static void main(String[] args) {

        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);

        // Versão mais simples
        for (Integer integer : asList) {
            if (integer.intValue() % 2 == 0) {
                System.out.println(integer);
            }
        }

        System.out.println();

        // Versão STREAM
       asList.stream().filter(e -> e % 2 == 0).forEach(System.out::println);
    }
}