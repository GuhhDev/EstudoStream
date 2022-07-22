import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

/**
 * testes
 */
public class TestesReduce {

    public static void main(String[] args) {

        String s = "Estudando reduce para melhor desenvolvimento de código";
        
        String[] split = s.split(" ");

        List<String> listStr = Arrays.asList(split);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // Soma reduce
        Optional<Integer> soma = list.stream().reduce((n1,n2) -> n1+ n2);

        System.out.println(soma.get());

        
        // multiplicação reduce
        Optional<Integer> multiplicacao = list.stream().reduce((n1,n2) -> n1*n2);

        System.out.println(multiplicacao.get());


        // concatenação reduce
        Optional<String> concatenacao = listStr.stream().reduce((s1,s2) -> s1.concat(s2));

        System.out.println(concatenacao.get());

        // NÃO FAZER!!
        // subtração reduce
        Optional<Integer> subtracao = list.stream().reduce((n1,n2) -> n1 - n2);
        System.out.println(subtracao.get());



        // Valor de identidade é o numero zero que é colocado no n1 para que, ao somar n1 + n2, essa soma dê o próprio n2


        // Soma reduce
        Integer soma2 = list.stream().reduce(0, (n1,n2) -> n1 + n2);
        System.out.println(soma2);

        
        // multiplicação reduce
        Integer multiplicacao2 = list.stream().reduce(1, (n1,n2) -> n1*n2);
        System.out.println(multiplicacao2);


        // concatenação reduce
        String concatenacao2 = listStr.stream().reduce("", (s1,s2) -> s1.concat(s2));
        System.out.println(concatenacao2);
    
    
    
        // Reduce - menorValor


        double menorValor = DoubleStream.of(-1.2, 3.5, 1.1, 6.9,2).reduce(Double.POSITIVE_INFINITY, (d1,d2) -> Math.min(d1,d2));
        System.out.println(menorValor);


        // reduce - map + combiner 

        Integer soma3 = list.stream().reduce(0, (n1,n2) -> n1 + n2, (n1,n2) -> n1 + n2);
        System.out.println(soma3);


        String reduce = list.stream().reduce(
            "",
         (n1,n2) -> n1.toString().concat(n2.toString()),
         (n1,n2) -> n1.concat(n2));
        System.out.println(soma3);



    }
}