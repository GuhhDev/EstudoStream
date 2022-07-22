import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;

/**
 * testes
 */
public class TestesOptional {

    public static void main(String[] args) {

        String s = "1";
        Integer testeComum = converteEmNumero(s);
        System.out.println(testeComum);

       // testando com ifPresent - só retorna a expressão se tiver valor
        converteEmNumeroOptional(s).ifPresent(n -> System.out.println(n));

       // Testando método ou joga exception
       Integer numero = converteEmNumeroOptional(s).orElseThrow(() -> new NullPointerException("Valor null!"));
       // Variação de optional
        Integer numero2 = converteEmNumeroOptionalVariacao(s).orElseThrow(() -> new NullPointerException("Valor null!"));

    }

    // Método Comum
    public static Integer converteEmNumero(String numeroStr) {
        return Integer.valueOf(numeroStr);
    }

    // Método usando Optional
    public static Optional<Integer> converteEmNumeroOptional(String numeroStr) {
            return Optional.of(Integer.valueOf(numeroStr));
    }

    public static OptionalInt converteEmNumeroOptionalVariacao(String numeroStr) {
        return OptionalInt.of(Integer.parseInt(numeroStr));
    }
}