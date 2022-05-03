package dev.tiffs.orcamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.tiffs.orcamento.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

}
