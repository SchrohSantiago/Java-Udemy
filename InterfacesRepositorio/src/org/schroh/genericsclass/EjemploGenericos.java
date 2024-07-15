package org.schroh.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T> camion){
        for (T t : camion){
            if (t instanceof Animal) {
                System.out.println(((Animal)t).getNombre() + "Tipo: " + ((Animal)t).getTipo());
            }
            if (t instanceof Automovil){
                System.out.println(((Automovil)t).getMarca());
            }
            if (t instanceof Maquinaria){
                System.out.println(((Maquinaria)t).getTipo());
            }
        }
    }
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);

        transporteCaballos.add(new Animal("Jorge", "Caballo"));
        transporteCaballos.add(new Animal("Well", "Caballo"));
        transporteCaballos.add(new Animal("Dutz", "Caballo"));
        transporteCaballos.add(new Animal("Phil", "Caballo"));
        transporteCaballos.add(new Animal("Esteban", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinaria = new Camion<>(3);
        transMaquinaria.add(new Maquinaria("Bulldozer"));
        transMaquinaria.add(new Maquinaria("Grua"));

        imprimirCamion(transMaquinaria);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Ford"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
    }
}
