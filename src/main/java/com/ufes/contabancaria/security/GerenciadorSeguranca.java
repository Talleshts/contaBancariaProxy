/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.contabancaria.security;

import com.ufes.contabancaria.model.Usuario;

/**
 *
 * @author talle
 */
public class GerenciadorSeguranca implements IGerenciadorSeguranca {

    @Override
    public boolean autoriza(String operacao, Usuario usuario) {
        // Logica de autorização fictícia
        return usuario.isAutorizado();
    } 
}
