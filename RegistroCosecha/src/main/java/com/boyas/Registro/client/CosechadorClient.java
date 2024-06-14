package com.boyas.Registro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.boyas.Registro.Controller.DTO.CosechadorDTO;

@FeignClient (name ="mscv-Cosechador", url = "localhost:8080/cosechador")
public interface CosechadorClient {

	@GetMapping("/search/registroCosecha/{idCosecha}")
	CosechadorDTO findAllByIdCosecha (@PathVariable String idCosecha);
	
}
