/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.contabancaria.security;

import com.ufes.contabancaria.model.Usuario;

/**
 *
 * @author talle
 */
public interface IGerenciadorSeguranca {
    boolean autoriza(String operacao, Usuario usuario);    
}
