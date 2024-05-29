package com.boyas.cosechador.Controller.DTO;

import java.util.Date;

import com.boyas.cosechador.Entity.Direccion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosCosechador(
		@NotBlank
		String nombre, 
		@NotBlank
		String apellido,
		@NotBlank
		Integer identificacion,
		@Email
		String email,
		@NotBlank
		Integer telefono,
		@Valid
		Direccion direccion,
		@NotBlank
		Date fechaInicioContrato) {

}
