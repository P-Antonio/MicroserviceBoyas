package com.boyas.Registro.Service;

import java.util.List;

import com.boyas.Registro.Entity.RegistroCosecha;

public interface RegistroService {

	List<RegistroCosecha> findAll();
	RegistroCosecha findById (Long id);
	void save (RegistroCosecha cosecha);
	void deleteById(Long id);
}
