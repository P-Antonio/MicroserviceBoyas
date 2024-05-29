package com.boyas.cosechador.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boyas.cosechador.Entity.Cosechador;
import com.boyas.cosechador.Repository.CosechadorRepository;

@Service
public class CosechadorIMP implements CosechadorService {

	@Autowired
	private CosechadorRepository cosechadorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cosechador> findAll() {
		return cosechadorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cosechador findById(Long id) {
		return cosechadorRepository.findById(id).orElseThrow();
	}

	@Override
	@Transactional
	public void save(Cosechador cosechador) {
		cosechadorRepository.save(cosechador);
	}

	@Override
	@Transactional
	public void eliminarById(Long id) {
		cosechadorRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cosechador findByIdentificacion(Integer identificacion) {
		return cosechadorRepository.findByIdentificacion(identificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cosechador> findAllByNombre(Pageable page) {
		return cosechadorRepository.findAllByNombre(page);
	}

}
