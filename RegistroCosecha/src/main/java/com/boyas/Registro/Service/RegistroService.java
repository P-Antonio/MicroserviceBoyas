package com.boyas.Registro.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boyas.Registro.Entity.RegistroCosecha;

public interface RegistroService {

	List<RegistroCosecha> findAll();
	RegistroCosecha findById (String id);
	void save (RegistroCosecha cosecha);
	void deleteById(String id);
	Page<RegistroCosecha> findById(Pageable page);
}
