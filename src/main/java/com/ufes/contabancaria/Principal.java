/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufes.contabancaria;

import com.ufes.contabancaria.model.Operacao;
import com.ufes.contabancaria.model.Usuario;
import com.ufes.contabancaria.proxy.ContaCorrenteProxy;
import com.ufes.contabancaria.security.GerenciadorSeguranca;
import com.ufes.contabancaria.security.IGerenciadorSeguranca;
import com.ufes.contabancaria.singleton.UsuarioLogado;
import java.util.Stack;

/**
 *
 * @author talle
 */
public class Principal {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("João", true);
        UsuarioLogado.getInstance().setUsuario(usuario);

        IGerenciadorSeguranca autorizador = new GerenciadorSeguranca();
        ContaCorrenteProxy conta = new ContaCorrenteProxy(1000, autorizador);

        conta.sacar(100);
        conta.depositar(200);

        Stack<Operacao> extrato = conta.emitirExtrado();
        for (Operacao op : extrato) {
            System.out.println(op.getNome() + ": " + op.getValor());
        }
    }
}
