package br.unipar.listaexercicios1.models;

import java.util.Arrays;

public class Pedido {
    private int numero;
    private String data;
    private double valorTotal;
    private Cliente cliente;
    private Item[] itens;

    public Pedido() {
    }

    public Pedido(int numero, String data, double valorTotal, Cliente cliente, Item[] itens) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.itens = itens;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", data='" + data + '\'' +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", itens=" + Arrays.toString(itens) +
                '}';
    }
}
