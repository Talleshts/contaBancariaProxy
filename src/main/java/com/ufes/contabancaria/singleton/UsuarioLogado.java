/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.contabancaria.singleton;

import com.ufes.contabancaria.model.Usuario;

/**
 *
 * @author talle
 */
public class UsuarioLogado {
    private static UsuarioLogado INSTANCE;
    private Usuario usuario;

    private UsuarioLogado() {}

    public static UsuarioLogado getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UsuarioLogado();
        }
        return INSTANCE;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
