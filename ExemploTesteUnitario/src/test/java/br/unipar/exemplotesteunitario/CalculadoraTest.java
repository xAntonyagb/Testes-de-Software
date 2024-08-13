package br.unipar.exemplotesteunitario;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Antony
 */
public class CalculadoraTest {
    
    private Calculadora calc;
    
    public CalculadoraTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        calc = new Calculadora();
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testSomar() {
        assertEquals(4, calc.soma(2,2));
    }

    @Test
    public void testSubtrair() {
        assertEquals(0, calc.subtracao(2,2));
        assertEquals(-3, calc.subtracao(2,5));
        assertEquals(3, calc.subtracao(5,2));
    }

    @Test
    public void testMultiplicar() {
        assertEquals(4, calc.multiplicacao(2,2));
        assertEquals(5, calc.multiplicacao(2.5,2));
        assertEquals(5, calc.multiplicacao(2,2.5));
        assertEquals(0, calc.multiplicacao(2,0));
        assertEquals(0, calc.multiplicacao(0,2));
    }

    @Test
    public void testDividir() {
        assertEquals(1, calc.divisao(2,2));
        assertEquals(2.5, calc.divisao(5,2));
        assertEquals(0.8, calc.divisao(2,2.5));
        assertEquals(0, calc.divisao(0,2));
        assertEquals(Double.POSITIVE_INFINITY, calc.divisao(2,0));

    }
    
}
