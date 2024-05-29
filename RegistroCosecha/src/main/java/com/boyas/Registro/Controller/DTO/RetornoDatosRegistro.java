package com.boyas.Registro.Controller.DTO;

import java.time.LocalDate;

import com.boyas.Registro.Entity.EnumArandanos;
import com.boyas.Registro.Entity.EnumModulos;
import com.boyas.Registro.Entity.RegistroCosecha;

public record RetornoDatosRegistro(String id, float kilogramosCosechados, EnumModulos modulos,
		EnumArandanos tipoArandano, LocalDate fechaCosecha) {

	public RetornoDatosRegistro(RegistroCosecha cosecha) {
		this(cosecha.getId(), cosecha.getKilogramosCosechados(), cosecha.getModulos(), cosecha.getTipoArandano(), cosecha.getFechaCosecha());
	}
}
