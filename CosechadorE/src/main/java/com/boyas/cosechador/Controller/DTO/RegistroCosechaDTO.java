package com.boyas.cosechador.Controller.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroCosechaDTO{

	private String id;
	private Float kilogramosCosechados;
	private EnumModulos modulos;
	private EnumArandanos tipoArandano;
	private LocalDate fechaCosecha = LocalDate.now();
}
