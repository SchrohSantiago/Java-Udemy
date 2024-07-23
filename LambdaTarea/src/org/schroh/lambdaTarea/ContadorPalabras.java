package org.schroh.lambdaTarea;

import java.util.Map;

@FunctionalInterface
public interface ContadorPalabras {
    Map<String,Integer> contarPalabras(String frase);
}
