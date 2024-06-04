package com.sustentacion.cerveza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentacion.cerveza.Domain.Cerveceria;

public interface CervezaRepository extends JpaRepository<Cerveceria, Long> {
    List<Cerveceria> findByMarca(String marca);
    List<Cerveceria> findByNombre_cerveceria(String nombre_cerveceria);



}
