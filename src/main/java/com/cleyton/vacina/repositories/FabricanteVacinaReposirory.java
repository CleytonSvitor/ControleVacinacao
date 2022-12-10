package com.cleyton.vacina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cleyton.vacina.model.FabricanteVacina;

@Repository
public interface FabricanteVacinaReposirory extends JpaRepository<FabricanteVacina, Integer>{

}
