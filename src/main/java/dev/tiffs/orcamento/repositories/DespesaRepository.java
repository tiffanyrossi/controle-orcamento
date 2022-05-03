package dev.tiffs.orcamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.tiffs.orcamento.entities.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}
