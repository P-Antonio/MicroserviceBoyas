package com.boyas.Registro.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boyas.Registro.Entity.RegistroCosecha;
import com.boyas.Registro.Repository.RegistroRepository;
import com.boyas.Registro.Service.RegistroService;

public class RegistroCosechaImp implements RegistroService{

	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Override
	public List<RegistroCosecha> findAll() {
		return registroRepository.findAll();
	}

	@Override
	public RegistroCosecha findById(Long id) {
		return registroRepository.findById(id).orElseThrow();
	}

	@Override
	public void save(RegistroCosecha cosecha) {
		registroRepository.save(cosecha);
		
	}

	@Override
	public void deleteById(Long id) {
		registroRepository.deleteById(id);
	}
	
	
}
