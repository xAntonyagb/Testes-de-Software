package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
Testes Unitários:
● Teste o cálculo da média de uma lista de números.
● Teste o cálculo da mediana para listas com tamanho par e ímpar.
● Teste o cálculo do desvio padrão para uma lista de números.
● Verifique o comportamento com listas vazias ou contendo valores nulos.
 */
class EstatisticasDeListaTest {
    EstatisticasDeLista estatisticasDeLista;

    @BeforeEach
    void setUp() {
        estatisticasDeLista = new EstatisticasDeLista();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calcularMedia() {
        List<Double> lista1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> lista2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        List<Double> lista3 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        List<Double> lista4 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        List<Double> lista5 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);

        assertEquals(3.0, estatisticasDeLista.calcularMedia(lista1));
        assertEquals(3.5, estatisticasDeLista.calcularMedia(lista2));
        assertEquals(4.0, estatisticasDeLista.calcularMedia(lista3));
        assertEquals(4.5, estatisticasDeLista.calcularMedia(lista4));
        assertEquals(5.0, estatisticasDeLista.calcularMedia(lista5));

        List<Double> listaVazia = Arrays.asList();
        assertThrows(ValidationException.class, () -> estatisticasDeLista.calcularMedia(listaVazia));

        List<Double> listaNula = null;
        assertThrows(ValidationException.class, () -> estatisticasDeLista.calcularMedia(listaNula));
    }

    @Test
    void calcularMediana() {
        List<Double> listaPar1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        List<Double> listaPar2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        List<Double> listaPar3 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0);

        List<Double> listaImpar1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> listaImpar2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        List<Double> listaImpar3 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);

        assertEquals(3.5, estatisticasDeLista.calcularMediana(listaPar1));
        assertEquals(4.5, estatisticasDeLista.calcularMediana(listaPar2));
        assertEquals(5.5, estatisticasDeLista.calcularMediana(listaPar3));

        assertEquals(3.0, estatisticasDeLista.calcularMediana(listaImpar1));
        assertEquals(4.0, estatisticasDeLista.calcularMediana(listaImpar2));
        assertEquals(5.0, estatisticasDeLista.calcularMediana(listaImpar3));

        List<Double> listaVazia = Arrays.asList();
        assertThrows(ValidationException.class, () -> estatisticasDeLista.calcularMediana(listaVazia));

        List<Double> listaNula = null;
        assertThrows(ValidationException.class, () -> estatisticasDeLista.calcularMediana(listaNula));
    }

    @Test
    void calcularDesvioPadrao() {
        List<Double> lista1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        assertEquals(2.0, estatisticasDeLista.calcularDesvioPadrao(lista1));

        List<Double> lista2 = Arrays.asList(10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
        assertEquals(0.0, estatisticasDeLista.calcularDesvioPadrao(lista2));

        List<Double> lista3 = Arrays.asList(2.0, 2.0, 1.0, 1.0);
        assertEquals(0.5, estatisticasDeLista.calcularDesvioPadrao(lista3));

        List<Double> lista4 = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        assertEquals(0.0, estatisticasDeLista.calcularDesvioPadrao(lista4));

        List<Double> lista5 = Arrays.asList();
        assertThrows(ValidationException.class, () -> estatisticasDeLista.calcularDesvioPadrao(lista5));

        List<Double> lista6 = null;
        assertThrows(ValidationException.class, () -> estatisticasDeLista.calcularDesvioPadrao(lista6));
    }
}