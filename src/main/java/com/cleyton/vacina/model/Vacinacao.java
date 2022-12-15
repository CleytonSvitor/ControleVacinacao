package com.cleyton.vacina.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vacinacao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "vacina_id")
	private FabricanteVacina vacina;
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	@ManyToOne
	@JoinColumn(name = "profissionlDaSaude_id")
	private ProfissionalDaSaude profissionlDaSaude;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime data_aplicacao;
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco local;
	private Integer dose;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacinacao other = (Vacinacao) obj;
		return Objects.equals(id, other.id);
	}
	

	
}
