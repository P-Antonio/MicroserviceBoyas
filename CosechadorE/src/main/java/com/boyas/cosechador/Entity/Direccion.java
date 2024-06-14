package com.boyas.cosechador.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity (name = "Direccion")
@Table (name = "Direcciones")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String direccion;
	private String barrio;
	private String ciudad;
	private String departamento;
	private String pais;
}
