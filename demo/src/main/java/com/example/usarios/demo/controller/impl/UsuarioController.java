package com.example.usarios.demo.controller.impl;

import com.example.usarios.demo.controller.UsuariosAPI;
import com.example.usarios.demo.model.UsuarioDTO;
import com.example.usarios.demo.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@Tag(name = "Usuarios", description = "API para gestionar usuarios")
public class UsuarioController implements UsuariosAPI {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios.
     */
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna una lista de todos los usuarios registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    })
    @GetMapping("/usuarios")
    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /**
     * Obtiene un usuario por su ID.
     */
    @Operation(summary = "Obtener usuario por ID", description = "Busca un usuario por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
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
    @Operation(summary = "Guardar un nuevo usuario", description = "Crea y guarda un nuevo usuario en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @CrossOrigin
    @PostMapping("/usuarios")
    @Override
    public UsuarioDTO save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del usuario a guardar", required = true,
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class)))
            @RequestBody UsuarioDTO usuarioDTO) {  // SOLO QUEDA LA ANOTACIÓN DE SPRING
        return usuarioService.save(usuarioDTO);
    }

    /**
     * Actualiza un usuario por su ID.
     */
    @Operation(summary = "Actualizar un usuario", description = "Modifica los datos de un usuario ya existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PutMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<UsuarioDTO> updateUsuario(
            @PathVariable String id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del usuario actualizados", required = true,
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class)))
            @RequestBody UsuarioDTO usuarioDTO) {  // SOLO QUEDA LA ANOTACIÓN DE SPRING
        usuarioDTO.setId(id);
        UsuarioDTO updatedUsuario = usuarioService.updateUsuario(usuarioDTO);
        return updatedUsuario != null ? ResponseEntity.ok(updatedUsuario) : ResponseEntity.notFound().build();
    }

    /**
     * Elimina un usuario por su ID.
     */
    @Operation(summary = "Eliminar un usuario", description = "Borra un usuario por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Usuario eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @DeleteMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        return usuarioService.deleteUsuario(id);
    }

    /**
     * Elimina todos los usuarios.
     */
    @Operation(summary = "Eliminar todos los usuarios", description = "Borra todos los usuarios registrados en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Todos los usuarios han sido eliminados"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/usuarios")
    @Override
    public ResponseEntity<Void> deleteAllUsuarios() {
        return usuarioService.deleteAllUsuarios();
    }
}
