package com.boyas.ventas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.boyas.ventas.Controller.DTO.ActualizarVenta;
import com.boyas.ventas.Controller.DTO.DatosVenta;
import com.boyas.ventas.Controller.DTO.RetornoDatosVentas;
import com.boyas.ventas.Entity.Ventas;
import com.boyas.ventas.service.VentasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ventas")
class VentasController {
	
	@Autowired
	private VentasService ventasService;

	@GetMapping
	public ResponseEntity<?> obtenerVentas (@PageableDefault (size = 4, sort = "{fecha}") Pageable page){
		var pagina = ventasService.findAllByFechaPedido(page).map(RetornoDatosVentas :: new);
		return ResponseEntity.ok(pagina);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> obtenerVenta(@PathVariable Long id){
		var obtenerVenta = ventasService.findById(id);
		return ResponseEntity.ok(new RetornoDatosVentas(obtenerVenta));
	}
	
	@PostMapping
	public ResponseEntity<?> añadirVenta(@RequestBody @Valid DatosVenta venta, UriComponentsBuilder componentsBuilder){
		var nuevaVenta = new Ventas(venta);
		ventasService.save(nuevaVenta);
		
		var uri = componentsBuilder.path("ventas/{id}").buildAndExpand(nuevaVenta.getId()).toUri();
		return ResponseEntity.created(uri).body(new RetornoDatosVentas(nuevaVenta));
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarVenta(@RequestBody ActualizarVenta actualizar){
		var venta = ventasService.findById(actualizar.id());
		venta.actualizarVenta(actualizar);
		
		return ResponseEntity.ok(new RetornoDatosVentas(venta));
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> eliminarVenta(@PathVariable Long id){
		ventasService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
