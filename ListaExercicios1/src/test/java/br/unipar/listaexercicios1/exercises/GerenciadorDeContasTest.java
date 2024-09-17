package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;
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
        Conta conta = new Conta(1, 100, "Titular 1");
        gerenciador.adicionarConta(conta);
        assertNotNull(gerenciador.contas);
    }

    @Test
    public void testBuscarContaPorNumero() {
        Conta conta = new Conta(1, 100, "Titular 1");
        gerenciador.adicionarConta(conta);

        assertNotNull( gerenciador.buscarContaPorNumero(1));
        assertEquals(1, gerenciador.buscarContaPorNumero(1).getNumero());
    }

    @Test
    public void testTransferir() {
        Conta user1 = new Conta(1, 100, "Titular 1");
        gerenciador.adicionarConta(user1);
        Conta user2 = new Conta(2, -100, "Titular 2");
        gerenciador.adicionarConta(user2);

        //é pra dar exception se tentar transferir um valor maior que o saldo
        assertThrows(ValidationException.class, () -> {
            gerenciador.transferir(2,1, 100);
        });

        //não é pra dar exception
        gerenciador.transferir(1,2, 50);
        assertEquals(50, gerenciador.buscarContaPorNumero(1).getSaldo());
        assertEquals(-50, gerenciador.buscarContaPorNumero(2).getSaldo());

        //contas inexistentes
        assertThrows(ValidationException.class, () -> {
            gerenciador.transferir(3,4, 100);
        });

        assertThrows(ValidationException.class, () -> {
            gerenciador.transferir(1,3, 100);
        });
    }
}
