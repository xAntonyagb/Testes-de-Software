package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;
import br.unipar.listaexercicios1.models.Conta;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeContas {
    public List<Conta> contas;

    public GerenciadorDeContas() {
        this.contas = new ArrayList<>();
    }

    //Adiciona uma conta na lista
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    //Para buscar uma conta pelo identificador
    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    //Para transferir saldo entre a conta de origem e a conta de destino
    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = buscarContaPorNumero(numeroContaOrigem);
        Conta contaDestino = buscarContaPorNumero(numeroContaDestino);

        if (contaOrigem == null) {
            throw new ValidationException("Conta de origem  não encontrada");
        }
        if(contaDestino == null) {
            throw new ValidationException("Conta de destino não encontrada");
        }
        if (contaOrigem.getSaldo() < valor) {
            throw new ValidationException("Saldo insuficiente");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        int posOrigem = retornaPosLista(contaOrigem);
        int posDest = retornaPosLista(contaDestino);

        if(posOrigem == -1 || posDest == -1) {
            throw new ValidationException("Erro interno ao transferir: Não foi possivel encontrar uma das contas!");
        }

        contas.set(posOrigem, contaOrigem);
        contas.set(posDest, contaDestino);
    }

    //Para retornar a posição da conta na lista
    private int retornaPosLista(Conta conta) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero() == conta.getNumero()) {
                return i;
            }
        }
        return -1;
    }
}
