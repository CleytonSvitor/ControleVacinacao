package com.cleyton.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleyton.vacina.dtos.EnderecoDTO;
import com.cleyton.vacina.model.Endereco;
import com.cleyton.vacina.repositories.EnderecoRepository;
import com.cleyton.vacina.service.execeptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco findById(Integer id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return enderecoRepository.findAll();
	}

	public Endereco create(EnderecoDTO objDTO) {
		Endereco obj = new Endereco(
				null, objDTO.getRua(), objDTO.getCidade(), objDTO.getEstado(), 
				objDTO.getCep(),objDTO.getComentario());
		return enderecoRepository.save(obj);
	}

	public Endereco update(Integer id, EnderecoDTO objDTO) {
		Endereco oldObj = findById(id);
		
		oldObj.setRua(objDTO.getRua());
		oldObj.setCidade(objDTO.getCidade());
		oldObj.setEstado(objDTO.getEstado());
		oldObj.setCep(objDTO.getCep());
		oldObj.setComentario(objDTO.getComentario());
		
		return enderecoRepository.save(oldObj);
				
	}

	public void delete(Integer id) {
		Endereco obj = findById(id);
		enderecoRepository.deleteById(id);		
		
	}

}
