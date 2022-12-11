package com.cleyton.vacina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalDaSaude extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String regConselho;
	String profissao;
	
	@OneToMany(mappedBy = "profissionlDaSaude")
	private List<Vacinacao> vacinacaoProfissionalSaude = new ArrayList<>();
	
	

}
