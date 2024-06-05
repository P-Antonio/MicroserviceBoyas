package com.boyas.ventas.Controller.DTO;

import java.time.LocalDate;

import com.boyas.ventas.Entity.EstadoPedido;
import com.boyas.ventas.Entity.Ventas;

public record RetornoDatosVentas(String empresa, Integer pedidoCantidad, EstadoPedido estadoPedido, LocalDate fechaPedido) {

	public RetornoDatosVentas(Ventas ventas) {
		this(ventas.getEmpresa(), ventas.getPedidoCantidad(), ventas.getEstadoPedido(), ventas.getFechaPedido());
	}
}
