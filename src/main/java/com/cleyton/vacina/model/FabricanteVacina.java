package com.cleyton.vacina.model;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteVacina implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String descricao;
	String lote;
	String validade;
	Integer quantidade;
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
