package com.cleyton.vacina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
