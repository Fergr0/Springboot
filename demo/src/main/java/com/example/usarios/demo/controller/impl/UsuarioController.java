package com.example.usarios.demo.controller.impl;

import com.example.usarios.demo.controller.UsuariosAPI;
import com.example.usarios.demo.model.UsuarioDTO;
import com.example.usarios.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController implements UsuariosAPI {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios.
     */
    @GetMapping("/usuarios")
    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /**
     * Obtiene un usuario por su ID.
     */
    @GetMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable String id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Guarda un nuevo usuario.
     */
    @CrossOrigin
    @PostMapping("/usuarios")
    @Override
    public UsuarioDTO save(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    /**
     * Actualiza un usuario por su ID.
     */
    @PutMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id);
        UsuarioDTO updatedUsuario = usuarioService.updateUsuario(usuarioDTO);
        return updatedUsuario != null ? ResponseEntity.ok(updatedUsuario) : ResponseEntity.notFound().build();
    }

    /**
     * Elimina un usuario por su ID.
     */
    @DeleteMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        return usuarioService.deleteUsuario(id);
    }

    /**
     * Elimina todos los usuarios.
     */
    @DeleteMapping("/usuarios")
    @Override
    public ResponseEntity<Void> deleteAllUsuarios() {
        return usuarioService.deleteAllUsuarios();
    }
}
