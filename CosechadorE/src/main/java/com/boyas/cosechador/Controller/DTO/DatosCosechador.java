package com.boyas.cosechador.Controller.DTO;

import java.util.Date;

import com.boyas.cosechador.Entity.Direccion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCosechador(
		@NotBlank
		String nombre, 
		@NotBlank
		String apellido,
		@NotNull
		Integer identificacion,
		@Email
		String email,
		@NotNull
		Integer telefono,
		@Valid
		Direccion direccion,
		@NotNull
		Date fechaInicioContrato) {

}
