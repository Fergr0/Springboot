package com.example.usarios.demo.controller;

import com.example.usarios.demo.model.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UsuariosAPI {

    List<UsuarioDTO> getAllUsuarios();

    ResponseEntity<UsuarioDTO> getUsuarioById(String id);

    UsuarioDTO save(UsuarioDTO usuarioDTO);

    ResponseEntity<UsuarioDTO> updateUsuario(String id, UsuarioDTO usuarioDTO);

    ResponseEntity<UsuarioDTO> addTutorialsToUser(String id, List<String> tutorialIds); // 🔹 Nuevo método

    ResponseEntity<Void> deleteUsuario(String id);

    ResponseEntity<Void> deleteAllUsuarios();
}
