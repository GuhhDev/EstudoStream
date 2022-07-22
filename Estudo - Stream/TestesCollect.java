import java.util.*;
import java.util.stream.Collectors;

/**
 * testes
 */
public class TestesCollect {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // fornecedor - acumulação - combinação
        List<Integer> collect = list.stream().collect(() -> new ArrayList<>(),(l, e) -> l.add(e),(l1, l2) -> l1.addAll(l2));
        System.out.println(list);
        System.out.println(collect);



        // toList usando filter - trazendo uma lista personalizada
        List<Integer> collect2 = list.stream().filter((n) -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(collect2);



        // Joining - traz tudo em string
        String join = list.stream().map(n -> n.toString()).collect(Collectors.joining());
        System.out.println(join);
        String join2 = list.stream().map(n -> n.toString()).collect(Collectors.joining(","));
        System.out.println(join2);



        // Averaging - transformando em int e média dos números
        Double media = list.stream().collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);



        // Summing - transformando em int e soma dos números
        Integer soma = list.stream().collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(soma);



        // summarizing - transformando em int e soma dos números
        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(stats.getAverage()); // media
        System.out.println(stats.getCount()); // quantidade de itens
        System.out.println(stats.getMax()); // valor maximo
        System.out.println(stats.getMin()); // valor mínimo
        System.out.println(stats.getSum()); // soma



        // Summing - transformando em int e soma dos números
        Long count = list.stream().filter((n) -> n % 2 == 0).collect(Collectors.counting());
        System.out.println(count);



        // MaxBy / MinBy
        list.stream().filter((n) -> n % 2 == 0).collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);
        list.stream().filter((n) -> n % 2 == 0).collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);



        //groupingBy - retorna integer agrupado em maps
        Map<Integer, List<Integer>> groupingBy = list.stream().collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(groupingBy);



        //partitioningBy - retorna booleano
        Map<Boolean, List<Integer>> partitioningBy = list.stream().collect(Collectors.partitioningBy((n) -> n % 3 == 0));
        System.out.println(groupingBy);



        // ToMap - mais personalizável
        Map<Integer, Double> toMap = list.stream().collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5)));
        System.out.println(toMap);
    }
}