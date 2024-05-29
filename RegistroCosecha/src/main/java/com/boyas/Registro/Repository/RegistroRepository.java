package com.boyas.Registro.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boyas.Registro.Entity.RegistroCosecha;

@Repository
public interface RegistroRepository extends MongoRepository<RegistroCosecha, Long> {

	Page<RegistroCosecha> findByFechaCosecha(Pageable page);

	Optional<RegistroCosecha> findById(String id);

	void deleteById(String id);

}
