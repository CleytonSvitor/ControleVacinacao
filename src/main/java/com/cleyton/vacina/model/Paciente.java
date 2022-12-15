package com.cleyton.vacina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter



public class Paciente extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	Integer qtdDoses;
	boolean imunizacaoCompleta;

	@OneToMany(mappedBy = "paciente")
	private List<Vacinacao> vacinacaoPaciente = new ArrayList<>();

	public Paciente(Integer id, String nome, String sobreNome, String CPF, String email, String Contato,
			Endereco endereco, Integer qtdDoses, boolean imunizacaoCompleta, Vacinacao vacinacaoPaciente) {
		
		super(id, nome, sobreNome, CPF, email, Contato, endereco);
		this.qtdDoses = qtdDoses;
		this.imunizacaoCompleta = imunizacaoCompleta;
		this.vacinacaoPaciente.add(vacinacaoPaciente);
	}

	public void setVacinacaoPaciente(Vacinacao vacinacaoPaciente) {
		this.vacinacaoPaciente.add(vacinacaoPaciente);
	}
	
	

}
