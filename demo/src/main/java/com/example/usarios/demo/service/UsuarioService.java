package com.example.usarios.demo.service;

import com.example.usarios.demo.model.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioDTO> getAllUsuarios();

    Optional<UsuarioDTO> getUsuarioById(String id);

    List<UsuarioDTO> findByNombreContaining(String nombre);

    UsuarioDTO save(UsuarioDTO usuario);

    UsuarioDTO updateUsuario(UsuarioDTO usuario);

    ResponseEntity<Void> deleteUsuario(String id);

    ResponseEntity<Void> deleteAllUsuarios();

    UsuarioDTO addTutorialsToUser(String userId, List<String> tutorialIds); // Nuevo método para asignar tutoriales
}
