package com.cleyton.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleyton.vacina.dtos.ProfissionalDaSaudeDTO;
import com.cleyton.vacina.model.Endereco;
import com.cleyton.vacina.model.ProfissionalDaSaude;
import com.cleyton.vacina.repositories.ProfissionalSaudeRepository;
import com.cleyton.vacina.service.execeptions.ObjectNotFoundException;

@Service
public class ProfissionalDaSaudeService {

	@Autowired
	private ProfissionalSaudeRepository profissionalSaudeRepository;
	@Autowired
	private EnderecoService enderecoService;

	public ProfissionalDaSaude findById(Integer id) {
		Optional<ProfissionalDaSaude> obj = profissionalSaudeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ProfissionalDaSaude.class.getName()));
	}

	public List<ProfissionalDaSaude> findAll() {
		return profissionalSaudeRepository.findAll();
	}
	
	public ProfissionalDaSaude create(ProfissionalDaSaudeDTO obj) {		
		return fromDTO(obj);
	}
	
	private ProfissionalDaSaude fromDTO(ProfissionalDaSaudeDTO obj) {
		ProfissionalDaSaude newObj = new ProfissionalDaSaude();
		newObj.setId(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setSobreNome(obj.getSobreNome());
		newObj.setCPF(obj.getCpf());
		newObj.setEmail(obj.getEmail());		
		newObj.setRegConselho(obj.getRegConselho());;
		newObj.setProfissao(obj.getProfissao());
		
		Endereco end = enderecoService.findById(obj.getEndereco());
		
		newObj.setEndereco(end);
		
		return profissionalSaudeRepository.save(newObj);
	}

}
