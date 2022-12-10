package com.cleyton.vacina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cleyton.vacina.model.ProficionalDaSaude;

@Repository
public interface ProficionalSaudeRepository extends JpaRepository<ProficionalDaSaude, Integer>{

}
