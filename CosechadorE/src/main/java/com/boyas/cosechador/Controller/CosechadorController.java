package com.boyas.cosechador.Controller;

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

import com.boyas.cosechador.Controller.DTO.ActualizarCosechador;
import com.boyas.cosechador.Controller.DTO.DatosCosechador;
import com.boyas.cosechador.Controller.DTO.RetornoDatosCosechador;
import com.boyas.cosechador.Entity.Cosechador;
import com.boyas.cosechador.Service.CosechadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/cosechador")
public class CosechadorController {
	
	@Autowired
	private CosechadorService cosechadorService;
	
	@GetMapping
	public ResponseEntity<?> obtenerCosechadores (@PageableDefault (size = 4, sort = "{nombre}") Pageable page){
		var pagina = cosechadorService.findAllByNombre(page).map(RetornoDatosCosechador :: new);
		return ResponseEntity.ok(pagina);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<RetornoDatosCosechador> obtenerUnCosechador (@PathVariable Long id){
		var cosechador = cosechadorService.findById(id);
		return ResponseEntity.ok(new RetornoDatosCosechador(cosechador));
	}
	
	@PostMapping
	public ResponseEntity<?> añadirCosechador(@RequestBody @Valid DatosCosechador datos, UriComponentsBuilder componentsBuilder){
		var cosechadorGuardado = new Cosechador(datos);
		cosechadorService.save(cosechadorGuardado);
		
		var uri = componentsBuilder.path("cosechador/{id}").buildAndExpand(cosechadorGuardado.getId()).toUri();
		return ResponseEntity.created(uri).body(new RetornoDatosCosechador(cosechadorGuardado));
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarCosechador(@RequestBody ActualizarCosechador actualizar){
		var cosechador = cosechadorService.findById(actualizar.id());
		cosechador.actualizarDatos(actualizar);
		return ResponseEntity.ok(new RetornoDatosCosechador(cosechador));
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> eliminarCosechador(@PathVariable Long id){
		var inhabilitarTrabajador = cosechadorService.findById(id);
		inhabilitarTrabajador.eliminar();
		
		return ResponseEntity.noContent().build();
	}
}
