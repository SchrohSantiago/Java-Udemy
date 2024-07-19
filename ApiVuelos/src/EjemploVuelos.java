import models.Vuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EjemploVuelos {
    public static void main(String[] args) throws ParseException {
        List<Vuelo> vuelos = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        vuelos.add(new Vuelo(62, "Santiago", format.parse("2021-08-29 05:39"), "AAL 933", "New York"));
        vuelos.add(new Vuelo(47, "Santiago", format.parse("2021-08-31 04:45"), "LAT 755", "Sao Paulo"));
        vuelos.add(new Vuelo(52, "Santiago", format.parse("2021-08-30 16:00"), "SKU 621", "Rio De Janeiro"));
        vuelos.add(new Vuelo(59, "Santiago", format.parse("2021-08-29 13:22"), "DAL 147", "Atlanta"));
        vuelos.add(new Vuelo(25, "Santiago", format.parse("2021-08-31 14:05"), "AVA 241", "Bogota"));
        vuelos.add(new Vuelo(29, "Santiago", format.parse("2021-08-31 05:20"), "AMX 10", "Mexico City"));
        vuelos.add(new Vuelo(55, "Santiago", format.parse("2021-08-30 08:45"), "IBE 6833", "Londres"));
        vuelos.add(new Vuelo(51, "Santiago", format.parse("2021-08-29 07:41"), "LAT 2479", "Frankfurt"));
        vuelos.add(new Vuelo(48, "Santiago", format.parse("2021-08-30 10:35"), "SKU 803", "Lima"));
        vuelos.add(new Vuelo(59, "Santiago", format.parse("2021-08-29 09:14"), "LAT 533", "Los Ángeles"));
        vuelos.add(new Vuelo(31, "Santiago", format.parse("2021-08-31 08:33"), "LAT 1447", "Guayaquil"));
        vuelos.add(new Vuelo(29, "Santiago", format.parse("2021-08-31 15:15"), "CMP 111", "Panama City"));
        vuelos.add(new Vuelo(47, "Santiago", format.parse("2021-08-30 08:14"), "LAT 705", "Madrid"));
        vuelos.add(new Vuelo(60, "Santiago", format.parse("2021-08-29 22:53"), "AAL 957", "Miami"));
        vuelos.add(new Vuelo(32, "Santiago", format.parse("2021-08-31 09:57"), "ARG 5091", "Buenos Aires"));
        vuelos.add(new Vuelo(35, "Santiago", format.parse("2021-08-31 04:00"), "LAT 1283", "Cancún"));
        vuelos.add(new Vuelo(61, "Santiago", format.parse("2021-08-29 07:45"), "LAT 579", "Barcelona"));
        vuelos.add(new Vuelo(58, "Santiago", format.parse("2021-08-30 07:12"), "AAL 945", "Dallas-Fort Worth"));
        vuelos.add(new Vuelo(49, "Santiago", format.parse("2021-08-29 18:29"), "LAT 501", "París"));
        vuelos.add(new Vuelo(39, "Santiago", format.parse("2021-08-30 15:45"), "LAT 405", "Montevideo"));

        vuelos.sort(Comparator.comparing(Vuelo::getFechaLlegada));

        vuelos.forEach(System.out::println);

        Vuelo ultimoVuelo = vuelos.getLast();

        System.out.println("El ultimo vuelo en llegar es: " + ultimoVuelo.getNombre() + ": " + ultimoVuelo.getOrigen() + ", aterriza el " + ultimoVuelo.getFechaLlegada() + "\n");

        Vuelo vueloConMenosPasajeros = null;

        for (Vuelo vuelo : vuelos) {
            if (vueloConMenosPasajeros == null || vuelo.getCantidadPasajeros() < vueloConMenosPasajeros.getCantidadPasajeros()) {
                vueloConMenosPasajeros = vuelo;
            }
        }

        System.out.println("El vuelo con menos pasajeros es: " + vueloConMenosPasajeros.getNombre() + ": " + vueloConMenosPasajeros.getDestino() + ", con " + vueloConMenosPasajeros.getCantidadPasajeros() + " pasajeros." );

    }

}