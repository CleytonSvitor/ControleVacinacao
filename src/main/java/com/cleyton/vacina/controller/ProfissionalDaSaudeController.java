package com.cleyton.vacina.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cleyton.vacina.dtos.ProfissionalDaSaudeDTO;
import com.cleyton.vacina.model.ProfissionalDaSaude;
import com.cleyton.vacina.service.ProfissionalDaSaudeService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalDaSaudeController {

	@Autowired
	private ProfissionalDaSaudeService profissionalDaSaudeService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfissionalDaSaudeDTO> findById(@PathVariable Integer id) {
		ProfissionalDaSaudeDTO objDTO = new ProfissionalDaSaudeDTO(profissionalDaSaudeService.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@GetMapping
	public ResponseEntity<List<ProfissionalDaSaudeDTO>> findALL() {

		List<ProfissionalDaSaude> list = profissionalDaSaudeService.findAll();
		List<ProfissionalDaSaudeDTO> listDTO = new ArrayList<>();

		for (ProfissionalDaSaude obj : list) {
			listDTO.add(new ProfissionalDaSaudeDTO(obj));
		}
		return ResponseEntity.ok().body(listDTO);

	}
	
	@PostMapping
	public ResponseEntity<ProfissionalDaSaudeDTO> create(@RequestBody ProfissionalDaSaudeDTO obj){
		obj = new ProfissionalDaSaudeDTO(profissionalDaSaudeService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

}
