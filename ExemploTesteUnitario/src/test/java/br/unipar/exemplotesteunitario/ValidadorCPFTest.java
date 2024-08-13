/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
public class ValidadorCPFTest {
    private ValidadorCPF validadorCPF;

    public ValidadorCPFTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        validadorCPF = new ValidadorCPF();
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testValidarCPF() {
        String cpf = "123.123.123-12";
        assertFalse(validadorCPF.validarCPF(cpf));

        cpf = "22081155036";
        assertFalse(validadorCPF.validarCPF(cpf));

        cpf = "220.811.550.36";
        assertFalse(validadorCPF.validarCPF(cpf));

        cpf = "220-811-550-36";
        assertFalse(validadorCPF.validarCPF(cpf));

        cpf = "220.811.550-36";
        assertTrue(validadorCPF.validarCPF(cpf));
    }
    
}
