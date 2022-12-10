package com.cleyton.vacina.model;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Integer qtdDoses;
	boolean imunizacaoCompleta;
	
		

}