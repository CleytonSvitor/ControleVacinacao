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
@Getter
@Setter
@NoArgsConstructor

public class ProfissionalDaSaude extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	String regConselho;
	String profissao;

	@OneToMany(mappedBy = "profissionlDaSaude")
	private List<Vacinacao> vacinacaoProfissionalSaude = new ArrayList<>();

	public ProfissionalDaSaude(Integer id, String nome, String sobreNome, String CPF, String email, String Contato,
			Endereco endereco, String regConselho, String profissao, Vacinacao vacinacaoProfissionalSaude) {
		super(id, nome, sobreNome, CPF, email, Contato, endereco);
		this.regConselho = regConselho;
		this.profissao = profissao;
		this.vacinacaoProfissionalSaude.add(vacinacaoProfissionalSaude);
	}

	public void setVacinacaoProfissionalSaude(Vacinacao vacinacaoProfissionalSaude) {
		this.vacinacaoProfissionalSaude.add(vacinacaoProfissionalSaude);
	}

}
