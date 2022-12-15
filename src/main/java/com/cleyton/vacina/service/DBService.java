package com.cleyton.vacina.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleyton.vacina.model.Endereco;
import com.cleyton.vacina.model.FabricanteVacina;
import com.cleyton.vacina.model.Paciente;
import com.cleyton.vacina.model.ProfissionalDaSaude;
import com.cleyton.vacina.model.Vacinacao;
import com.cleyton.vacina.repositories.EnderecoRepository;
import com.cleyton.vacina.repositories.FabricanteVacinaReposirory;
import com.cleyton.vacina.repositories.PacienteRepository;
import com.cleyton.vacina.repositories.ProfissionalSaudeRepository;
import com.cleyton.vacina.repositories.VacinacaoRepository;

@Service
public class DBService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private FabricanteVacinaReposirory fabricanteVacinaRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ProfissionalSaudeRepository profissionalSaudeRepository;
	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	
	
	public void instanciaDB() {	
		Endereco end1 = new Endereco(
				null, "Rua das Alagoas", "Natal", "RN", "59034-856", "Numero 24 ");
		Endereco end2 = new Endereco(
				null, "Rua das Pitangas", "Campina Grande", "PB", "32034-634", "Engenho Velho ");
		Endereco end3 = new Endereco(
				null, "Rua das Oliveiras", "Macaiba", "RN", "59234-126", "Serra do Mato  grande ");	
		Endereco end4 = new Endereco(
				null, "Av. Romualdo Galvão", "Natal", "RN", "59022-205", "Posto Saúde São Joao");
		Endereco end5 = new Endereco(
				null, "R. São João de Deus, 80", "Natal", "RN", "59010-775", "Hospital dos Pescadores");
		Endereco end6 = new Endereco(
				null, "Rua das Pitangas", "Natal", "RN", "59056-832", "Numero 4");

		
		
		FabricanteVacina oxford = new FabricanteVacina(
				null, "Vacina contra covid", "093675", "25/04/2023", 30, null);
		FabricanteVacina janssen = new FabricanteVacina(
				null, "Vacina contra covid", "123E139", "25/02/2023", 90, null);
		FabricanteVacina pfizer = new FabricanteVacina(
				null, "Vacina contra covid", "9283Y32", "25/06/2023", 70, null);
		
		Paciente paciente1 = new Paciente(
				null, "Mauricio", "Gurgel", "801.989.820-46", "gurgel@gmail.com", "84 99367-9532", end3, 0, false, null);
		Paciente paciente2 = new Paciente(
				null, "Roberta", "Da Silva", "140.259.380-57", "berta@outlook.com", "83 3772-8754", end2, 0, false, null);
		
		ProfissionalDaSaude profSaude1 =new ProfissionalDaSaude(
				null, "Maria", "Cardoso", "863.963.730-09", "maria@ig.com.br", "84 99764-3659", end1, "COREM-3287",
				"Enfermeira", null);
		ProfissionalDaSaude profSaude2 =new ProfissionalDaSaude(
				null, "Alvaro", "Silva", "033.873.470-81", "alvaro@terra.com.br", "84 99711-0980", end6, "COREM-7321",
				"Enfermeiro", null);
		
		Vacinacao covid1 = new Vacinacao(null, pfizer, paciente2, profSaude2, LocalDateTime.now(), end4, 1);
		Vacinacao covid2 = new Vacinacao(null, janssen, paciente1, profSaude1, LocalDateTime.now(), end5, 2);
		
		paciente1.setVacinacaoPaciente(covid2);
		paciente2.setVacinacaoPaciente(covid1);
		
		profSaude1.setVacinacaoProfissionalSaude(covid2);
		profSaude2.setVacinacaoProfissionalSaude(covid1);
		
		oxford.setVacinacaoVacina(covid2);
		pfizer.setVacinacaoVacina(covid2);
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5, end6));
		fabricanteVacinaRepository.saveAll(Arrays.asList(oxford, janssen, pfizer));
		pacienteRepository.saveAll(Arrays.asList(paciente1, paciente2));
		profissionalSaudeRepository.saveAll(Arrays.asList(profSaude1, profSaude2));
		vacinacaoRepository.saveAll(Arrays.asList(covid1, covid2));
	}
}
