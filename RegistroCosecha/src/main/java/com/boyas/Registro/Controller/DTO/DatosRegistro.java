package com.boyas.Registro.Controller.DTO;

import java.time.LocalDate;

import com.boyas.Registro.Entity.EnumArandanos;
import com.boyas.Registro.Entity.EnumModulos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistro(
		@NotBlank
		float kilogramosCosechados,
		@NotBlank
		EnumModulos modulos,
		@NotBlank
		EnumArandanos tipoArandano) {

}
