package com.example.usarios.demo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder
public class UsuarioDTO {
	
	private String id;
    private String nombre;
    private String apellido;
    private String calle;
    private String codPostal;
    private String ciudad;
    private String cumpleanos;

}
