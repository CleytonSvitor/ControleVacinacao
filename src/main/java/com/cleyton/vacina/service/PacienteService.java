package com.cleyton.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleyton.vacina.dtos.PacienteDTO;
import com.cleyton.vacina.model.Endereco;
import com.cleyton.vacina.model.Paciente;
import com.cleyton.vacina.repositories.PacienteRepository;
import com.cleyton.vacina.service.execeptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private EnderecoService enderecoService;
	
	public Paciente findById(Integer id) {
		Optional<Paciente> obj = pacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+ Paciente.class.getName()));
	}

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	public Paciente create(PacienteDTO obj) {		
		return fromDTO(obj);
	}
	
	private Paciente fromDTO(PacienteDTO obj) {
		Paciente newObj = new Paciente();
		newObj.setId(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setSobreNome(obj.getSobreNome());
		newObj.setCPF(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setQtdDoses(obj.getQtdDoses());
		newObj.setImunizacaoCompleta(obj.isImunizacaoCompleta());
		
		Endereco end = enderecoService.findById(obj.getEndereco());
		
		newObj.setEndereco(end);
		
		return pacienteRepository.save(newObj);
	}
	

	
}
