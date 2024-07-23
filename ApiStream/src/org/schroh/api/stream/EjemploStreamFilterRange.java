package org.schroh.api.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;


public class EjemploStreamFilterRange {
    public static void main(String[] args) {
        // Stream no tiene por si solo a RANGE

        IntStream num = IntStream.range(5, 20).peek(System.out::println);  // NO INCLUYE EL 20 PERO SI EL 5
//        Integer resultado = nombres.reduce(0,(a,b) -> a + b);


        IntSummaryStatistics stats = num.summaryStatistics(); // Podemos obtener parametros de estadistcias, promedio, suma, mayor, menor
        System.out.println("MAX: " + stats.getMax());
        System.out.println("MIN: " + stats.getMin());
        System.out.println("SUM: " + stats.getSum());
        System.out.println("PROMEDIO: " + stats.getAverage());
        System.out.println("TOTAL: " + stats.getCount());
    }
}
