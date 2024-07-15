package org.schroh.generics;

import org.schroh.interfaces.modelo.Cliente;
import org.schroh.interfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Antonio", "Herrera"));

        Cliente antonio = clientes.iterator().next();

        Cliente[] clientesArreglo = {new Cliente("Antonio", "Herrera"), new Cliente("Agustin", "Arrieta")};

        Integer[] enteros = {1, 2, 3};

        List<Cliente> clientes2 = fromArrayToList(clientesArreglo);
        List<Integer> enteros2 = fromArrayToList(enteros);

        clientes2.forEach(System.out::println);
        enteros2.forEach(System.out::println);

        List<ClientePremium> clientePremiums = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Jorge", "Maceda")});

        imprimirClientes(clientePremiums);

        List<String> nombres = fromArrayToList(new String[]{"Jorge", "Almiron", "Dandi"}, enteros);

        System.out.println("Maxmimo de 1, 9 y 4 es: " + maximo(1,9,4));
    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] g) {
        for (G elementos : g) {
            System.out.println(elementos);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends ClientePremium> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
