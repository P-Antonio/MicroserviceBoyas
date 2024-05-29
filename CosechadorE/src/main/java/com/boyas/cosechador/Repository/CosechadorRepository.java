package com.boyas.cosechador.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boyas.cosechador.Entity.Cosechador;

@Repository
public interface CosechadorRepository extends JpaRepository<Cosechador, Long> {

	Cosechador findByIdentificacion(Integer identificacion);
	Page<Cosechador> findAllByNombre (Pageable page);
}
