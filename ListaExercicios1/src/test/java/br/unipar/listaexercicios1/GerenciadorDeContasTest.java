package br.unipar.listaexercicios1;

import br.unipar.listaexercicios1.exercises.GerenciadorDeContas;
import br.unipar.listaexercicios1.models.Conta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorDeContasTest {
    
    private GerenciadorDeContas gerenciador;
    
    public GerenciadorDeContasTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        gerenciador = new GerenciadorDeContas();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAdicionarConta() {
        System.out.println("adicionarConta");
        Conta conta = null;
        GerenciadorDeContas instance = new GerenciadorDeContas();
        instance.adicionarConta(conta);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarContaPorNumero() {
        System.out.println("buscarContaPorNumero");
        int numero = 0;
        GerenciadorDeContas instance = new GerenciadorDeContas();
        Conta expResult = null;
        Conta result = instance.buscarContaPorNumero(numero);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTransferir() {
        System.out.println("transferir");
        int numeroContaOrigem = 0;
        int numeroContaDestino = 0;
        double valor = 0.0;
        GerenciadorDeContas instance = new GerenciadorDeContas();
        instance.transferir(numeroContaOrigem, numeroContaDestino, valor);
        fail("The test case is a prototype.");
    }
    
}
