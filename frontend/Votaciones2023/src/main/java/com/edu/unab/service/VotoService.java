package com.edu.unab.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.unab.entity.Voto;

@Repository
public interface VotoService extends JpaRepository<Voto, Integer> {
	
	Voto findByIdentificacion(int identificacion);

}
