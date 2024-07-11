import models.Gerente;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Juarez", "Angel Brunel", "Jorge", "323124", 187560.23, 1, 230000D);
        Gerente.aumentarRemuneracion(230000);

        System.out.print(gerente);
        System.out.print(gerente.getRemuneracion());
    }
}