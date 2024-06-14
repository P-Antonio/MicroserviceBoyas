package com.boyas.cosechador.Entity;

import java.util.Date;

import com.boyas.cosechador.Controller.DTO.ActualizarCosechador;
import com.boyas.cosechador.Controller.DTO.DatosCosechador;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity (name = "Cosechador")
@Table (name = "Cosechadores")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Cosechador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private Integer identificacion;
	private String email;
	private Integer telefono;
	@OneToOne(targetEntity = Direccion.class ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Direccion direccion;
	@Column(name = "Fecha_Inicio_Contrato")
	private Date fechaInicioContrato;
	@Column(name = "Fecha_Fin_Contrato")
	private Date fechaFinContrato;
	private boolean habil = true;
	private Long idCosecha;
	
	
	public Cosechador(@Valid DatosCosechador datos) {
		this.nombre = datos.nombre();
		this.apellido = datos.apellido();
		this.identificacion = datos.identificacion();
		this.email = datos.email();
		this.telefono = datos.telefono();
		this.direccion = datos.direccion();
		this.fechaInicioContrato = datos.fechaInicioContrato();
	}


	public void actualizarDatos(ActualizarCosechador actualizar) {
		if(actualizar.idenficacion() != null) {
			this.identificacion = actualizar.idenficacion();
		}
		if(actualizar.email() != null) {
			this.email = actualizar.email();
		}
		if(actualizar.telefono() != null) {
			this.telefono = actualizar.telefono();
		} 	
	}


	public void eliminar() {
		this.habil = false;
	}

}
