/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.contabancaria.proxy;

import com.ufes.contabancaria.model.ContaCorrente;
import com.ufes.contabancaria.model.IContaCorrenteProxy;
import com.ufes.contabancaria.model.Operacao;
import com.ufes.contabancaria.model.Usuario;
import com.ufes.contabancaria.security.IGerenciadorSeguranca;
import com.ufes.contabancaria.singleton.UsuarioLogado;
import java.util.Stack;

/**
 *
 * @author talle
 */
public class ContaCorrenteProxy implements IContaCorrenteProxy {

    private ContaCorrente conta;
    private IGerenciadorSeguranca autorizador;
    private Usuario usuarioLogado;

    public ContaCorrenteProxy(double saldo, IGerenciadorSeguranca autorizador) {
        this.conta = new ContaCorrente(saldo);
        this.autorizador = autorizador;
        usuarioLogado = UsuarioLogado.getInstance().getUsuario();
    }

    @Override
    public void depositar(double valor) {
        if (autorizador.autoriza("depositar", usuarioLogado)) {
            conta.depositar(valor);
        } else {
            throw new RuntimeException("O usuário " + usuarioLogado.getNome() + " não tem autorização para realizar a operação depósito");
        }
    }

    @Override
    public void sacar(double valor) {
        if (autorizador.autoriza("sacar", usuarioLogado)) {
            conta.sacar(valor);
        } else {
            throw new RuntimeException("O usuário " + usuarioLogado.getNome() + " não tem autorização para realizar a operação saque");
        }
    }

    @Override
    public Stack<Operacao> emitirExtrado() {
        return conta.emitirExtrado();
    }
}