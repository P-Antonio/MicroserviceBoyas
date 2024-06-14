package com.boyas.Registro.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boyas.Registro.Entity.RegistroCosecha;
import com.boyas.Registro.http.response.CosechadorByCosechaResponse;

public interface RegistroService {

	List<RegistroCosecha> findAll();
	RegistroCosecha findById (String id);
	void save (RegistroCosecha cosecha);
	void deleteById(String id);
	Page<RegistroCosecha> findById(Pageable page);
	List<RegistroCosecha> findByIdCosechador (Long idCosechador);
	CosechadorByCosechaResponse findCosechadorByIdCosecha (String idCosecha);
}
