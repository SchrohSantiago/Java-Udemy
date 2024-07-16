import org.schroh.excepciones.Calculadora;
import org.schroh.excepciones.DivisionPorZeroException;
import org.schroh.excepciones.FormatoNumeroException;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        String denominador = JOptionPane.showInputDialog("Ingrese un entero denominador: ");
        String numerador = JOptionPane.showInputDialog("Ingrese un entero numerador: ");

        try {
            double division2 = cal.dividir(numerador,denominador);
            System.out.println(division2);
        } catch(NumberFormatException n){
            System.out.println("El tipo de dato de entrada no es de tipo number" + n.getMessage());
            main(args);
        } catch (FormatoNumeroException e){
            System.out.println("Ingresar un numero valido: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch(DivisionPorZeroException ae){
            System.out.println("Capturamos la excepcion en tiempo de ejec: " + ae.getMessage());
            main(args);
        } finally {
            System.out.println("Cerramos pool de conexion");
        }
        System.out.println("das");
    }
}