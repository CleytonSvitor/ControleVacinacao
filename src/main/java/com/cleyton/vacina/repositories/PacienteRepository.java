package com.cleyton.vacina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cleyton.vacina.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
