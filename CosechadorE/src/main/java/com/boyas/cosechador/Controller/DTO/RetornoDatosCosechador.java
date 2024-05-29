package com.boyas.cosechador.Controller.DTO;

import java.util.Date;

import com.boyas.cosechador.Entity.Cosechador;
import com.boyas.cosechador.Entity.Direccion;

public record RetornoDatosCosechador(String nombre, String apellido, Integer identificacion, String email, Integer telefono, Direccion direccion,
		Date fechaInicioContrato, Date fechaFinContrato) {

	public RetornoDatosCosechador(Cosechador cosechador) {
		this(cosechador.getNombre(), cosechador.getApellido(), cosechador.getIdentificacion(), cosechador.getEmail(), cosechador.getTelefono(), cosechador.getDireccion(),
				cosechador.getFechaInicioContrato(), cosechador.getFechaFinContrato());
	}
}
