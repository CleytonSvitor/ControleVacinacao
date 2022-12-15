package com.cleyton.vacina.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cleyton.vacina.dtos.EnderecoDTO;
import com.cleyton.vacina.model.Endereco;
import com.cleyton.vacina.service.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
		Endereco obj = enderecoService.findById(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findALL() {
	
		List<Endereco> list = enderecoService.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@PostMapping
	public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO objDTO){
		Endereco obj = enderecoService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> update(@PathVariable Integer id, @RequestBody EnderecoDTO objDTO){
		EnderecoDTO obj = new EnderecoDTO(enderecoService.update(id, objDTO));
		return ResponseEntity.ok().body(obj);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		enderecoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
