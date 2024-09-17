package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraAvancadaTest {

    private CalculadoraAvancada calculadora;

    public CalculadoraAvancadaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        calculadora = new CalculadoraAvancada();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testPotencia() {
        assertEquals(4, calculadora.potencia(2, 2));
        assertEquals(1, calculadora.potencia(1, 0));
        assertEquals(0, calculadora.potencia(0, 1));
        assertEquals(1, calculadora.potencia(-1, 2));
    }

    @Test
    public void testRaizQuadrada() {
        assertEquals(2, calculadora.raizQuadrada(4));
        assertEquals(0, calculadora.raizQuadrada(0));

        //Para quando é negativo, lançar exceção
        assertThrows(ValidationException.class, () -> {
            calculadora.raizQuadrada(-1);
        });
    }

    @Test
    public void testLogaritmoNatural() {
        assertEquals(2.302585092994046, calculadora.logaritmoNatural(10));
        assertEquals(0, calculadora.logaritmoNatural(1));

        //validar 0
        assertEquals(0, calculadora.logaritmoNatural(0));

        //Para quando é negativo, lançar exceção
        assertThrows(ValidationException.class, () -> {
            calculadora.logaritmoNatural(-1);
        });
    }
    
}
