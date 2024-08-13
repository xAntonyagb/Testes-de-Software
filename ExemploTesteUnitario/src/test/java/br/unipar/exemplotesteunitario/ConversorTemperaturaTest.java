package br.unipar.exemplotesteunitario;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorTemperaturaTest {

    private ConversorTemperatura conv;

    public ConversorTemperaturaTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        conv = new ConversorTemperatura();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCelsiusParaFahrenheit() {
        assertEquals(32, conv.celsiusParaFahrenheit(0));
        assertEquals(50, conv.celsiusParaFahrenheit(10));
        // Zero absoluto
        assertEquals(-459.66999999999996, conv.celsiusParaFahrenheit(-273.15));
    }

    @Test
    public void testFahrenheitParaCelsius() {
        assertEquals(0, conv.fahrenheitParaCelsius(32));
        assertEquals(10, conv.fahrenheitParaCelsius(50));
        assertEquals(-17.77777777777778, conv.fahrenheitParaCelsius(0));
        // Zero absoluto
        assertEquals(-273.15, conv.fahrenheitParaCelsius(-459.67));
    }

    @Test
    public void testCelciusParaKelvin() {
        assertEquals(273.15, conv.celciusParaKelvin(0));
        assertEquals(283.15, conv.celciusParaKelvin(10));
        //Zero absoluto
        assertEquals(0, conv.celciusParaKelvin(-273.15));
    }

}
