/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.contabancaria.model;

import java.time.LocalDateTime;

/**
 *
 * @author talle
 */
public class Operacao {
    private LocalDateTime dataHora;
    private String nome;
    private TipoOperacao tipo;
    private double valor;

    public Operacao(String nome, TipoOperacao tipo, double valor) {
        this.dataHora = LocalDateTime.now();
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    // Getters
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getNome() {
        return nome;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
