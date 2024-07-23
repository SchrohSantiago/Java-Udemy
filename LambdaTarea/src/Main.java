import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> transformar = (a) -> a.replace(".","")
                .replace(",","")
                .replace(" ", "" )
                .toUpperCase();

        String resultado = transformar.apply("Hola como andas?");

        System.out.println(resultado);

    }
}