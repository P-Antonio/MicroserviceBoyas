package com.boyas.Registro.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.boyas.Registro.Controller.DTO.ActualizarRegistro;
import com.boyas.Registro.Controller.DTO.DatosRegistro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegistroCosecha {

	@Id
	private String id;
	private Float kilogramosCosechados;
	private EnumModulos modulos;
	private EnumArandanos tipoArandano;
	private LocalDate fechaCosecha = LocalDate.now();
	private Long idCosechador;
	
	
	public RegistroCosecha(DatosRegistro datos) {
		this.kilogramosCosechados = datos.kilogramosCosechados();
		this.modulos = datos.modulos();
		this.tipoArandano = datos.tipoArandano();
	}


	public void actualizarDatos(ActualizarRegistro actualizar) {
		if(actualizar.kilogramosCosechados() != null) {
			this.kilogramosCosechados = actualizar.kilogramosCosechados();
		}
		if(actualizar.modulos() != null) {
			this.modulos = actualizar.modulos();
		}
		if(actualizar.tipoArandano() != null) {
			this.tipoArandano = actualizar.tipoArandano();
		}
	}
}
