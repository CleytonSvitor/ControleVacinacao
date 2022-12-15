package com.cleyton.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleyton.vacina.model.ProfissionalDaSaude;
import com.cleyton.vacina.repositories.ProfissionalSaudeRepository;
import com.cleyton.vacina.service.execeptions.ObjectNotFoundException;

@Service
public class ProfissionalDaSaudeService {

	@Autowired
	private ProfissionalSaudeRepository profissionalSaudeRepository;

	public ProfissionalDaSaude findById(Integer id) {
		Optional<ProfissionalDaSaude> obj = profissionalSaudeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ProfissionalDaSaude.class.getName()));
	}

	public List<ProfissionalDaSaude> findAll() {
		return profissionalSaudeRepository.findAll();
	}

}
