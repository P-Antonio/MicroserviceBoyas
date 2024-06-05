package com.boyas.ventas.Controller.DTO;

import com.boyas.ventas.Entity.EstadoPedido;

public record ActualizarVenta(Long id, Integer pedidoCantidad, EstadoPedido estadoPedido) {

}
