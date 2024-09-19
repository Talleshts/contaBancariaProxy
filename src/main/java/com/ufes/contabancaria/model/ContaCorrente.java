/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.contabancaria.model;

import java.util.Stack;

/**
 *
 * @author talle
 */
public class ContaCorrente implements IContaCorrenteProxy{
        private double saldo;
    private Stack<Operacao> historico;

    public ContaCorrente(double saldoInicial) {
        this.saldo = saldoInicial;
        this.historico = new Stack<>();
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            this.historico.add(new Operacao("Deposito", TipoOperacao.DEPOSITO, valor));
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            this.historico.add(new Operacao("Saque", TipoOperacao.SAQUE, valor));
        } else {
            throw new RuntimeException("Saldo insuficiente para saque.");
        }
    }

    @Override
    public Stack<Operacao> emitirExtrado() {
        return historico;
    }
}
