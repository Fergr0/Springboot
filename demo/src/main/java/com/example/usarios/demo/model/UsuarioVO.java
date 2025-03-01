package com.example.usarios.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Document(collection = "contactos")
public class UsuarioVO {

    @Id
    private String id;
    private final String nombre;
    private final String apellido;
    private final String calle;
    private final String codPostal;
    private final String ciudad;
    private final String cumpleanos;
    private List<String> tutorialIds; // 🔹 Lista de IDs de tutoriales asociados
}
