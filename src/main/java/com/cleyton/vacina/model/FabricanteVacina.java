package com.cleyton.vacina.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FabricanteVacina implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String lote;
	private String validade;
	private Integer quantidade;
	
	@OneToMany(mappedBy = "vacina")
	private List<Vacinacao> vacinacaoVacina = new ArrayList<>();
	
	public FabricanteVacina(Integer id, String descricao, String lote, String validade, Integer quantidade,
			Vacinacao vacinacaoVacina) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.lote = lote;
		this.validade = validade;
		this.quantidade = quantidade;
		this.vacinacaoVacina.add(vacinacaoVacina);
	}
	
	
	public void setVacinacaoVacina(Vacinacao vacinacaoVacina) {
		this.vacinacaoVacina.add(vacinacaoVacina);
	}
	
	
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
		FabricanteVacina other = (FabricanteVacina) obj;
		return Objects.equals(id, other.id);
	}



	
	
	

}
