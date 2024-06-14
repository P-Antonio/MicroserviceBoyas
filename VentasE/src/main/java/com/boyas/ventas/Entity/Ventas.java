package com.boyas.ventas.Entity;

import java.time.LocalDate;


import com.boyas.ventas.Controller.DTO.ActualizarVenta;
import com.boyas.ventas.Controller.DTO.DatosVenta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "Ventas")
@Table (name = "Ventas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ventas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empresa;
	private Integer pedidoCantidad;
	private EstadoPedido estadoPedido = EstadoPedido.PENDIENTE;
	private LocalDate fechaPedido = LocalDate.now();
	
	public Ventas(DatosVenta venta) {
		this.empresa = venta.empresa();
		this.pedidoCantidad = venta.pedidoCantidad();
	}

	public void actualizarVenta(ActualizarVenta actualizar) {
		if(estadoPedido == EstadoPedido.PENDIENTE) {
			if(actualizar.estadoPedido() == EstadoPedido.ENVIADO){
				this.estadoPedido = actualizar.estadoPedido();
			}
		}else if(estadoPedido == EstadoPedido.ENVIADO){
			if(actualizar.estadoPedido() == EstadoPedido.ENTREGADO) {
				this.estadoPedido = actualizar.estadoPedido();
			}
		}else if(estadoPedido != EstadoPedido.ENTREGADO){
			if(actualizar .estadoPedido() == EstadoPedido.CANCELADO) {
				this.estadoPedido = actualizar.estadoPedido();
			}
		}
		if(actualizar.pedidoCantidad() != null) {
			this.pedidoCantidad = actualizar.pedidoCantidad();
		}
	}
}
