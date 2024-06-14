package com.boyas.Registro.Controller.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CosechadorDTO {
	
	private String nombre;
	private String apellido;
	private Integer identificacion;
	private String email;
	private Integer telefono;
	private Date fechaInicioContrato;
	private Date fechaFinContrato;
	private boolean habil = true;
	private Long idCosecha;
}
