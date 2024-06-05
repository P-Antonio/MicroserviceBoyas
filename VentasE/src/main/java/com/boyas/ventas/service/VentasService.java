package com.boyas.ventas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boyas.ventas.Entity.Ventas;

public interface VentasService {

	List<Ventas> findAll();
	Page<Ventas> findAllByFechaPedido (Pageable page);
	Ventas findById (Long id);
	void save (Ventas ventas);
	void deleteById(Long id);
}
