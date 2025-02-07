package com.example.usarios.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder
public class UsuarioDTO {
	
	private String id;
    private final String nombre;
    private final String apellido;
    private final String calle;
    private final String codPostal;
    private final String ciudad;
    private final String cumpleanos;

}
