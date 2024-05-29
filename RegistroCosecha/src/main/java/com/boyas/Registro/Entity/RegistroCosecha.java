package com.boyas.Registro.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class RegistroCosecha {

	@Id
	private String id;
}
