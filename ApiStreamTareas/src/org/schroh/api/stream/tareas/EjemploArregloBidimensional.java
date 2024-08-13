package org.schroh.api.stream.tareas;

import java.util.Arrays;
import java.util.stream.Stream;

public class EjemploArregloBidimensional {
    public static void main(String[] args) {
        String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};

        Stream<String> arr =  Arrays.stream(lenguajes)
                 .flatMap(Arrays::stream)
                 .distinct();

        arr.forEach(System.out::println);

//        String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};
//
//        Function<String[][], List<String>> flatten = arr ->  Arrays.stream(arr).flatMap(a -> Arrays.stream(a))
//                .distinct()
//                .collect(Collectors.toList());
//
//        flatten.apply(lenguajes).forEach(e -> System.out.println(e));
    }
}
