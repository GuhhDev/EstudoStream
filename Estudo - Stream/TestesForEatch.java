import java.util.Arrays;
import java.util.List;

public class TestesForEatch {

    public static void main(String[] args) {

        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);

        // Versão mais simples
        for (Integer integer : asList) {
            System.out.println(integer);
        }

        System.out.println();

        // Versão STREAM
       asList.stream().forEach(System.out::println);
    }
}