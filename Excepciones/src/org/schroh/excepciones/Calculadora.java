package org.schroh.excepciones;

public class Calculadora {

    public double dividir(int numerador, int dividendo) throws DivisionPorZeroException{
        if (dividendo == 0){
            throw new DivisionPorZeroException("No se puede dividir por 0");
        }
        return numerador/(double)dividendo;
    }

    public double dividir(String numerador, String divisor) throws DivisionPorZeroException, FormatoNumeroException {
        try {
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        } catch (NumberFormatException nf){
            throw new FormatoNumeroException("Debe ingresar un numero en el numerador y divisor");
        }

    }
}
