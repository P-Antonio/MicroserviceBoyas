package com.boyas.ventas.Imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boyas.ventas.Entity.Ventas;
import com.boyas.ventas.Repository.VentasRepository;
import com.boyas.ventas.service.VentasService;

@Service
public class VentasIMP implements VentasService{

	@Autowired
	private VentasRepository ventasRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ventas> findAll() {
		return ventasRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ventas findById(Long id) {
		return ventasRepository.findById(id).orElseThrow();
	}

	@Override
	@Transactional
	public void save(Ventas ventas) {
		ventasRepository.save(ventas);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		ventasRepository.deleteById(id);
	}

	@Override
	public Page<Ventas> findAllByFechaPedido(Pageable pageable) {
		return ventasRepository.findAllByFechaPedidoIsNotEmpty(pageable);
	}

}
