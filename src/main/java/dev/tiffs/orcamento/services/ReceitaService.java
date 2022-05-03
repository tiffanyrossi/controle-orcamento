package dev.tiffs.orcamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.tiffs.orcamento.dtos.ReceitaDTO;
import dev.tiffs.orcamento.entities.Receita;
import dev.tiffs.orcamento.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository repo;
	
	public List<ReceitaDTO> getAll() {
		List<Receita> receitas = repo.findAll();
		ArrayList<ReceitaDTO> receitasDTO = new ArrayList<>();
		
		for (Receita receita : receitas) {
			receitasDTO.add(receita.toDTO());			
		}		
		return receitasDTO;		
	}
	
	public ReceitaDTO getOne(Integer id) {
		Optional<Receita> optional = repo.findById(id);
		Receita receita = optional.orElse(new Receita());
		return receita.toDTO();		
	}
	
	public ReceitaDTO save(Receita receita) {
		return repo.save(receita).toDTO();
	}
	
	public ReceitaDTO update(Receita receitaAltera, Integer id) {
		Optional<Receita> receitaDb = repo.findById(id);
		
		if (receitaDb.isPresent()) {
			Receita obj = receitaDb.get();
			obj.setData(receitaAltera.getData());
			obj.setDescricao(receitaAltera.getDescricao());
			obj.setValor(receitaAltera.getValor());
			
			return repo.save(obj).toDTO();
		} else {
			return new Receita().toDTO();
		}
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
