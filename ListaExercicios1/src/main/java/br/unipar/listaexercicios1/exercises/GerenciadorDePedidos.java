package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDePedidos {

    List<Pedido> listPedidos;

    public GerenciadorDePedidos() {
        this.listPedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        listPedidos.add(pedido);
    }

    public double calcularValorTotal(int idPedido) {
        double valorTotal = 0;
        for (Pedido pedido : listPedidos) {
            if (pedido.getNumero() == idPedido) {
                for (int i = 0; i < pedido.getItens().length; i++) {
                    valorTotal += pedido.getItens()[i].getValor() * pedido.getItens()[i].getQuantidade();
                }
            }
        }
        return valorTotal;
    }

    public List<Pedido> listarPedidosPorCliente(String nomeCliente) {
        List<Pedido> listPedidosCliente = new ArrayList<>();
        for (Pedido pedido : listPedidos) {
            if (pedido.getCliente().getNome().equals(nomeCliente)) {
                listPedidosCliente.add(pedido);
            }
        }
        return listPedidosCliente;
    }

    public Pedido buscarPedidoPorId(int idPedido) {
        for (Pedido pedido : listPedidos) {
            if (pedido.getNumero() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }
}
