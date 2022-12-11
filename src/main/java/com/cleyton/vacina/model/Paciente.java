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
@AllArgsConstructor
@NoArgsConstructor

public class Paciente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Integer qtdDoses;
	boolean imunizacaoCompleta;
	
	@OneToMany(mappedBy = "paciente")
	private List<Vacinacao> vacinacaoPaciente = new ArrayList<>();
	
		

}
