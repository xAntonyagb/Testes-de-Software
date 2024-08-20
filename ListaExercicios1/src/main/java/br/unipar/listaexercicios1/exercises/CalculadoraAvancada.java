package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;

public class CalculadoraAvancada {

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double raizQuadrada(double numero) {
        if(numero < 0) {
            throw new ValidationException("Não é possível calcular raiz quadrada de número negativo");
        }
        return Math.sqrt(numero);
    }

    public double logaritmoNatural(double numero) {
        if(numero < 0) {
            throw new ValidationException("Não é possível calcular logaritmo natural de número negativo");
        }

        if(numero == 0) {
            return 0;
        }

        return Math.log(numero);
    }
}
