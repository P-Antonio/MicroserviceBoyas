package com.boyas.cosechador.http.Response;

import java.util.List;

import com.boyas.cosechador.Controller.DTO.RegistroCosechaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCosechaByIdCosechador {

	private Long id;
	private String nombre;
	private Integer identificacion;
	private List<RegistroCosechaDTO> listaRegistro;
}
