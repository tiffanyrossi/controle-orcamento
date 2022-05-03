package dev.tiffs.orcamento.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import dev.tiffs.orcamento.entities.Despesa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespesaDTO {
	
	private int id;
	
	@NotNull(message="Preenchimento obrigatório.")
	private String descricao;
	
	@NotNull(message="Preenchimento obrigatório")
	private double valor;
	
	private Date data;
	
	public Despesa toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Despesa.class);
	}

}
