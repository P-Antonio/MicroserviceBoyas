package com.boyas.Registro.http.response;

import java.time.LocalDate;
import java.util.List;

import com.boyas.Registro.Controller.DTO.CosechadorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CosechadorByCosechaResponse {

	private String id;
	private Float kilogramosCosechados;
	private LocalDate fechaCosecha;
	private CosechadorDTO cosechador;
}
