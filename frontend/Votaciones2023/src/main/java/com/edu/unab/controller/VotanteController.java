package com.edu.unab.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.unab.entity.Votante;
import com.edu.unab.service.VotanteService;

import ch.qos.logback.core.model.Model;

@Controller
public class VotanteController {

	@Autowired
	private VotanteService votanteService;
	Votante objVot = new Votante();

	@PostMapping("/validar")
	public String valida(@Validated Votante votante, Model model) {
		try {
			Optional<Votante> objVotante = votanteService.findById(votante.getIdentificacion());
			if (objVotante.isEmpty()) {
				return "/message";
			} else {
				objVot = objVotante.get();
				if (objVot.getIdentificacion() == votante.getIdentificacion()
						&& objVot.getClave().equals(votante.getClave())) {
					
					return "/index";
				} else {
					return "/message";
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return "redirect:/validar";
	}

}
