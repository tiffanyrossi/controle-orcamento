package dev.tiffs.orcamento.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import dev.tiffs.orcamento.dtos.DespesaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private double valor;
	private Date data;
	
	public DespesaDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, DespesaDTO.class);
	}
}
