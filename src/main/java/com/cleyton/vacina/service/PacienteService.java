package com.cleyton.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleyton.vacina.model.Paciente;
import com.cleyton.vacina.repositories.PacienteRepository;
import com.cleyton.vacina.service.execeptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente findById(Integer id) {
		Optional<Paciente> obj = pacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+ Paciente.class.getName()));
	}

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}
	
	
	
}
