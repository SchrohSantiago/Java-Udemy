
import models.Mamiferos;
import models.felinos.tiposfelinos.*;
import models.caninos.tiposcaninos.*;

public class EjemploMamiferos {
    public static void main(String[] args) {
        Mamiferos[] mamiferos = new Mamiferos[8];

        Leon leon1 = new Leon(0.89F, "Sector A", 1.32F, "LeonA2C", 132F, 3.43F, 43, 1, 32.2F);
        Leon leon2 = new Leon(0.79F, "Sector A", 1.31F, "LeonA2F", 121.32F, 3.12F, 42, 2, 26.2F);

        Tigre tigre1 = new Tigre(0.65F,"Sector B", 1.12F, "Tigre33D", 94F, 2.43F, 37, "BENGALA");
        Tigre tigre2 = new Tigre(0.65F,"Sector C-2", 1.10F, "Tigre31D", 88F, 2.10F, 40, "Normal");

        Guepardo guepardo1 = new Guepardo(0.55F,"Sector C-3", 1.10F, "Guep31", 58F, 2.10F, 67);

        Lobo lobo1 = new Lobo(0.32F,"Sector D-3", 0.96F, "Lob36", 56F, "Negro", 2.32F, 1);

        Perro perro1 = new Perro(0.38F,"Sector H-1", 1.16F, "PerAfricTw36", 76F, "Marron", 4.32F, 11);
        Perro perro2 = new Perro(0.37F,"Sector H-1", 1.10F, "PerAfricTw31", 75.2F, "Marron/Blanco", 3.92F, 8);

        mamiferos[0] = leon1;
        mamiferos[1] = leon2;

        mamiferos[2] = tigre1;
        mamiferos[3] = tigre2;

        mamiferos[4] = guepardo1;
        mamiferos[5] = lobo1;

        mamiferos[6] = perro1;
        mamiferos[7] = perro2;

        for (Mamiferos m: mamiferos){
            System.out.println(m);
        }

        System.out.println(leon1.dormir());

        System.out.println(leon2.comer());

        System.out.println(tigre1.correr());

        System.out.println(tigre2.correr());
    }
}