package com.boyas.Registro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boyas.Registro.Entity.RegistroCosecha;

@Repository
public interface RegistroRepository extends MongoRepository<RegistroCosecha, Long> {

}
