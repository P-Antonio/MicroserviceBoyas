package com.boyas.ventas.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.boyas.ventas.Controller.DTO.ActualizarVenta;
import com.boyas.ventas.Controller.DTO.DatosVenta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
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
	private EstadoPedido estadoPedido;
	private LocalDate fechaPedido = LocalDate.now();
	
	public Ventas(DatosVenta venta) {
		this.empresa = venta.empresa();
		this.pedidoCantidad = venta.pedidoCantidad();
		this.estadoPedido = venta.estadoPedido();
	}

	public void actualizarVenta(ActualizarVenta actualizar) {
		if(actualizar.pedidoCantidad() != null) {
			this.pedidoCantidad = actualizar.pedidoCantidad();
		}
		if(actualizar.estadoPedido() != null) {
			this.estadoPedido = actualizar.estadoPedido();
		}
	}
}
