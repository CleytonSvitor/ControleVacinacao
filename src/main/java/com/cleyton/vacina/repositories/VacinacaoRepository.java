package com.cleyton.vacina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cleyton.vacina.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Integer>{

}
