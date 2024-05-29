package com.boyas.Registro.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class RegistroController {

	@GetMapping
	public ResponseEntity<?> obtenerCosechadores (@PageableDefault (size = 4, sort = "{nombre}") Pageable page){
		var pagina = cosechadorService.findAllByNombre(page).map(RetornoDatosCosechador :: new);
		return ResponseEntity.ok(pagina);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> obtenerUnCosechador (){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> añadirCosechador(){
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarCosechador(){
		return null;
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> eliminarCosechador(){
		return null;
	}
}
