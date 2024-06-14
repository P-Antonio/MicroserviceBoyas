package com.boyas.cosechador.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.boyas.cosechador.Controller.DTO.RegistroCosechaDTO;

@FeignClient (name = "mscv-RegistroCosecha",url = "localhost:8080/registro")
public interface CosechaClient{

	@GetMapping("/search-cosecha/{idCosechador}")
	List<RegistroCosechaDTO> findAllByIdCosechador (Long idCosechador);
	
}
