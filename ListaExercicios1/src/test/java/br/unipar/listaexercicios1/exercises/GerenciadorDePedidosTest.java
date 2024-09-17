package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.models.Cliente;
import br.unipar.listaexercicios1.models.Item;
import br.unipar.listaexercicios1.models.Pedido;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorDePedidosTest {

    GerenciadorDePedidos gerenciador;

    @BeforeEach
    void setUp() {
        gerenciador = new GerenciadorDePedidos();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void adicionarPedido() {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente("Cliente 1", "123456789", "Rua 1", "123456789"));
        pedido.setData("01/01/2024");
        pedido.setNumero(1);

        Item[] itens = new Item[2];
        itens[0] = new Item("Item 1", 50.0, 1);
        itens[1] = new Item("Item 2", 25.0, 2);

        pedido.setItens(itens);
        pedido.setValorTotal(100.0);

        gerenciador.adicionarPedido(pedido);
        assertNotNull(gerenciador.listPedidos);
    }

    @Test
    void calcularValorTotal() {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente("Cliente 1", "123456789", "Rua 1", "123456789"));
        pedido.setData("01/01/2024");
        pedido.setNumero(1);

        Item[] itens = new Item[2];
        itens[0] = new Item("Item 1", 50.0, 1);
        itens[1] = new Item("Item 2", 25.0, 2);

        pedido.setItens(itens);
        gerenciador.adicionarPedido(pedido);
        double total = gerenciador.calcularValorTotal(1);

        assertEquals(100.0, total);
    }

    @Test
    void listarPedidosPorCliente() {
        Item[] itens = new Item[2];
        itens[0] = new Item("Item 1", 50.0, 1);
        itens[1] = new Item("Item 2", 25.0, 2);

        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente("Cliente 1", "123456789", "Rua 1", "123456789"));
        pedido.setData("01/01/2024");
        pedido.setNumero(1);
        pedido.setItens(itens);
        gerenciador.adicionarPedido(pedido);

        Pedido pedido2 = new Pedido();
        pedido2.setCliente(new Cliente("Cliente 2", "987654321", "Rua 2", "987654321"));
        pedido2.setData("01/01/2024");
        pedido2.setNumero(2);
        pedido2.setItens(itens);
        gerenciador.adicionarPedido(pedido2);
        gerenciador.adicionarPedido(pedido2);

        assertEquals(1, gerenciador.listarPedidosPorCliente("Cliente 1").size());
        assertEquals(2, gerenciador.listarPedidosPorCliente("Cliente 2").size());
    }

    @Test
    void buscarPedidoPorId() {
        Item[] itens = new Item[2];
        itens[0] = new Item("Item 1", 50.0, 1);
        itens[1] = new Item("Item 2", 25.0, 2);

        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente("Cliente 1", "123456789", "Rua 1", "123456789"));
        pedido.setData("01/01/2024");
        pedido.setNumero(1);
        pedido.setItens(itens);
        gerenciador.adicionarPedido(pedido);

        assertEquals(1, gerenciador.buscarPedidoPorId(1).getNumero());
        assertNull(gerenciador.buscarPedidoPorId(2));
    }

    @Test
    void getListPedidos() {
    }
}