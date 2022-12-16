package com.cleyton.vacina.dtos;

import java.io.Serializable;

import com.cleyton.vacina.model.ProfissionalDaSaude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProfissionalDaSaudeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String sobreNome;
	private String cpf;
	private String email;
	private String regConselho;
	private String  profissao;
	private Integer endereco;

	public ProfissionalDaSaudeDTO(ProfissionalDaSaude profissional) {
		super();
		this.id = profissional.getId();
		this.nome = profissional.getNome();
		this.sobreNome = profissional.getSobreNome();
		this.cpf = profissional.getCPF();
		this.email = profissional.getEmail();
		this.regConselho = profissional.getRegConselho();
		this.profissao = profissional.getProfissao();
		this.endereco = profissional.getEndereco().getId();
	}

}
