package com.boyas.Registro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.boyas.Registro.Controller.DTO.ActualizarRegistro;
import com.boyas.Registro.Controller.DTO.DatosRegistro;
import com.boyas.Registro.Controller.DTO.RetornoDatosRegistro;
import com.boyas.Registro.Entity.RegistroCosecha;
import com.boyas.Registro.Service.RegistroService;

import jakarta.validation.Valid;
import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroService registroService;

	@GetMapping
	public ResponseEntity<?> obtenerRegistro (@PageableDefault (size = 4, sort = "{id}") Pageable page){
		var pagina = registroService.findById(page).map(RetornoDatosRegistro :: new);
		return ResponseEntity.ok(pagina);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> obtenerUnRegistroById (@PathVariable String id){
		var registro = registroService.findById(id);
		return ResponseEntity.ok(new RetornoDatosRegistro(registro));
	}
	
	@PostMapping
	public ResponseEntity<?> añadirRegistro(@RequestBody @Valid DatosRegistro datos, UriComponentsBuilder componentsBuilder){
		var registro = new RegistroCosecha(datos);
		registroService.save(registro);
		
		var uri = componentsBuilder.path("registro/{id}").buildAndExpand(registro.getId()).toUri();
		return ResponseEntity.created(uri).body(new RetornoDatosRegistro(registro));
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarRegistro (@RequestBody ActualizarRegistro actualizar){
		var registroActualizado = registroService.findById(actualizar.id());
		registroActualizado.actualizarDatos(actualizar);
		return ResponseEntity.ok(new RetornoDatosRegistro(registroActualizado));
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> eliminarRegistroCosecha (@PathVariable String id){
		registroService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search-cosecha/{idCosechador}")
	public ResponseEntity<?> obtenerCosechaByIdCosechador (@PathVariable Long idCosechador){
		return ResponseEntity.ok(registroService.findByIdCosechador(idCosechador));
	}
	
	@GetMapping("/search-cosechador/{idCosecha}")
	public ResponseEntity<?> obtenerCosechadorByIdCosecha (@PathVariable String idCosecha){
		return ResponseEntity.ok(registroService.findCosechadorByIdCosecha(idCosecha));
	}
}
