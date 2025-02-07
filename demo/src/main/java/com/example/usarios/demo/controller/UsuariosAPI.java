package com.example.usarios.demo.controller;

import com.example.usarios.demo.model.UsuarioDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;


public interface UsuariosAPI {

    List<UsuarioDTO> getAllUsuarios();

    ResponseEntity<UsuarioDTO> getUsuarioById(String id);

    UsuarioDTO save(UsuarioDTO usuarioDTO);

    ResponseEntity<UsuarioDTO> updateUsuario(String id, UsuarioDTO usuarioDTO);

    ResponseEntity<Void> deleteUsuario(String id);

    ResponseEntity<Void> deleteAllUsuarios();
}
