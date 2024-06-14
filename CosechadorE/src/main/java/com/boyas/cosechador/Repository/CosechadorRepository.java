package com.boyas.cosechador.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boyas.cosechador.Entity.Cosechador;

@Repository
public interface CosechadorRepository extends JpaRepository<Cosechador, Long> {

	Cosechador findByIdentificacion(Integer identificacion);
	
	//@Query ("SELECT c FROM Cosechadores c WHERE a.nombre = ?1")
	Page<Cosechador> findByNombreIsNotNull(Pageable page);
	List<Cosechador> findByIdCosecha (Long idCosecha);
}
