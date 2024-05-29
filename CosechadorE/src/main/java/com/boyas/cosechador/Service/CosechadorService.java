package com.boyas.cosechador.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boyas.cosechador.Entity.Cosechador;

public interface CosechadorService {

	List<Cosechador> findAll();
	Cosechador findById (Long id);
	void save(Cosechador cosechador);
	void eliminarById(Long id);
	Cosechador findByIdentificacion (Integer identificacion);
	Page<Cosechador>  findAllByNombre (Pageable page);
}
