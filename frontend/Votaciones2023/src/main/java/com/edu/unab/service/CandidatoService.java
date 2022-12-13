package com.edu.unab.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.unab.entity.Candidato;

@Repository
public interface CandidatoService extends JpaRepository<Candidato, Integer> {

}
