package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;

import java.util.Collections;
import java.util.List;

public class EstatisticasDeLista {

    public double calcularMedia(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new ValidationException("Lista de números vazia");
        }

        double soma = 0;
        for (Double numero : numeros) {
            soma += numero;
        }
        return soma / numeros.size();
    }

    public double calcularMediana(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new ValidationException("Lista de números vazia");
        }

        //ordenar a lista primeiro
        Collections.sort(numeros);

        int tamanho = numeros.size(); // pegar o tamanho pra fazer o calculo

        //se o tamanho da lista for par, a mediana é a média dos dois números do meio
        if (tamanho % 2 == 0) {
            return (numeros.get(tamanho / 2 - 1) + numeros.get(tamanho / 2)) / 2;
        //se não, é o número do meio
        } else {
            return numeros.get(tamanho / 2);
        }
    }

    public double calcularDesvioPadrao(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new ValidationException("Lista de números vazia");
        }
        // variância = soma dos quadrados das diferenças entre cada número e a média dividido pelo total de números
        double media = calcularMedia(numeros);
        double somaTemp = 0;

        for (Double numero : numeros) {
            somaTemp += Math.pow(numero - media, 2);
        }

        //Desvio padrão = raiz quadrada da variância
        return Math.sqrt(somaTemp / numeros.size());
    }
}
