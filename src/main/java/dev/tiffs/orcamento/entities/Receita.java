package dev.tiffs.orcamento.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import dev.tiffs.orcamento.dtos.ReceitaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private double valor;
	private Date data;
	
	public ReceitaDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ReceitaDTO.class);
	}

}
