package com.edu.unab.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.unab.entity.Voto;
import com.edu.unab.service.VotoService;

@Controller
public class VotoController {
	
	@Autowired
	private VotoService votoService;

	@PostMapping("/voto")
	public String regVoto(@Validated Voto voto, Model model) {
		String retorno = "";
		try {
			Voto objVoto = votoService.findByIdentificacion(voto.getIdentificacion());
			if (objVoto != null) {
				retorno = "/message_vot";
			} else {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		        String date = dateFormat.format(new Date());
				voto.setFechaHora(date);
				votoService.save(voto);
				retorno = "/message_fin";
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return retorno;
	}

}
