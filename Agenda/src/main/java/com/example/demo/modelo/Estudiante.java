package com.example.demo.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern; 
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    @Pattern(regexp = "\\d+", message = "El celular debe contener solo números")
    private Long celular;

	/**
	 *  Constructores, getters y setters
    */
	public Estudiante() {
		super();
	}

	public Estudiante(Long codigo, String nombre, String apellido, Long celular) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	// Método para validar un objeto Estudiante y retornar un mensaje de error
	public static String validarEstudiante(Estudiante estudiante, BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        StringBuilder errorMessage = new StringBuilder();
	        for (FieldError error : bindingResult.getFieldErrors()) {
	            errorMessage.append(error.getDefaultMessage()).append(",   
	 ");
	        }
	        return   
	 errorMessage.toString();
	    }
	    return null;
	} 
    
}
