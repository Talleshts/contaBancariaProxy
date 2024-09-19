/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.contabancaria.model;

import java.util.Stack;

/**
 *
 * @author talle
 */
public interface IContaCorrenteProxy {
    void depositar(double valor);
    void sacar(double valor);
    Stack<Operacao> emitirExtrado();
}
