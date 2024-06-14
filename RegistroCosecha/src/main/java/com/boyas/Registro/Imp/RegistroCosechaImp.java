package com.boyas.Registro.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boyas.Registro.Controller.DTO.CosechadorDTO;
import com.boyas.Registro.Entity.RegistroCosecha;
import com.boyas.Registro.Repository.RegistroRepository;
import com.boyas.Registro.Service.RegistroService;
import com.boyas.Registro.client.CosechadorClient;
import com.boyas.Registro.http.response.CosechadorByCosechaResponse;

@Service
public class RegistroCosechaImp implements RegistroService{

	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Autowired
	private CosechadorClient cosechadorClient;
	
	@Override
	public List<RegistroCosecha> findAll() {
		return registroRepository.findAll();
	}

	@Override
	public RegistroCosecha findById(String id) {
		return registroRepository.findById(id).orElseThrow();
	}

	@Override
	public void save(RegistroCosecha cosecha) {
		registroRepository.save(cosecha);
		
	}

	@Override
	public void deleteById(String id) {
		registroRepository.deleteById(id);
	}

	@Override
	public Page<RegistroCosecha> findById(Pageable page) {
		return registroRepository.findByFechaCosecha(page);
	}

	@Override
	public List<RegistroCosecha> findByIdCosechador(Long idCosechador) {
		return registroRepository.findByIdCosechador(idCosechador);
	}

	@Override
	public CosechadorByCosechaResponse findCosechadorByIdCosecha(String idCosecha) {
		// buscar la cosecha
		RegistroCosecha cosecha = registroRepository.findById(idCosecha).orElseThrow();
		
		//consultar cosechador
		CosechadorDTO cosechador= cosechadorClient.findAllByIdCosecha(idCosecha);
		
		return CosechadorByCosechaResponse.builder()
				.id(cosecha.getId())
				.kilogramosCosechados(cosecha.getKilogramosCosechados())
				.fechaCosecha(cosecha.getFechaCosecha())
				.cosechador(cosechador)
				.build();
	}
	
	
}
