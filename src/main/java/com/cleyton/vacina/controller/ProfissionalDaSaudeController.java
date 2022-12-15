package com.cleyton.vacina.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleyton.vacina.dtos.ProfissionalDaSaudeDTO;
import com.cleyton.vacina.model.ProfissionalDaSaude;
import com.cleyton.vacina.service.ProfissionalDaSaudeService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalDaSaudeController {

	@Autowired
	private ProfissionalDaSaudeService prifissionalDaSaudeService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfissionalDaSaudeDTO> findById(@PathVariable Integer id) {
		ProfissionalDaSaudeDTO objDTO = new ProfissionalDaSaudeDTO(prifissionalDaSaudeService.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@GetMapping
	public ResponseEntity<List<ProfissionalDaSaudeDTO>> findALL() {

		List<ProfissionalDaSaude> list = prifissionalDaSaudeService.findAll();
		List<ProfissionalDaSaudeDTO> listDTO = new ArrayList<>();

		for (ProfissionalDaSaude obj : list) {
			listDTO.add(new ProfissionalDaSaudeDTO(obj));
		}
		return ResponseEntity.ok().body(listDTO);

	}

}
