package com.boyas.ventas.Controller.DTO;

import com.boyas.ventas.Entity.EstadoPedido;

public record DatosVenta(String empresa, Integer pedidoCantidad, EstadoPedido estadoPedido) {

}
