package com.cleyton.vacina.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vacinacao implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDate data_aplicacao;
	private Integer dose;
	private Endereco local;
	
	private List<FabricanteVacina> vacina = new ArrayList<>();
	private List<ProficionalDaSaude> ps = new ArrayList<>();
	private List<Paciente> paciente  = new ArrayList<>();
	

}
