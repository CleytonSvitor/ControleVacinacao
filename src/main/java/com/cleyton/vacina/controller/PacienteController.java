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

import com.cleyton.vacina.dtos.PacienteDTO;
import com.cleyton.vacina.model.Paciente;
import com.cleyton.vacina.service.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> findById(@PathVariable Integer id) {
		PacienteDTO objDTO = new PacienteDTO(pacienteService.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findALL() {

		List<Paciente> list = pacienteService.findAll();
		List<PacienteDTO> listDTO = new ArrayList<>();

		for (Paciente obj : list) {
			listDTO.add(new PacienteDTO(obj));
		}

		return ResponseEntity.ok().body(listDTO);

	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO obj){
		obj = new PacienteDTO(pacienteService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	

}
