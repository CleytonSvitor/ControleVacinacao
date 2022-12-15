package com.cleyton.vacina.dtos;

import java.io.Serializable;

import com.cleyton.vacina.model.Paciente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String sobreNome;
	private String email;
	private Integer qtdDoses;
	private boolean imunizacaoCompleta;

	public PacienteDTO(Paciente paciente) {
		super();
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.sobreNome = paciente.getSobreNome();
		this.email = paciente.getEmail();
		this.qtdDoses = paciente.getQtdDoses();
		this.imunizacaoCompleta = paciente.isImunizacaoCompleta();
	}

}
