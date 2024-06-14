package com.boyas.ventas.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boyas.ventas.Entity.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

	Page<Ventas> findAllByFechaPedidoIsNotEmpty (Pageable pageable);

}
