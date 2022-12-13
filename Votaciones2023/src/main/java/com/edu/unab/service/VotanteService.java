package com.edu.unab.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.unab.entity.Votante;

@Repository
public interface VotanteService extends JpaRepository<Votante, Integer>  {

}
