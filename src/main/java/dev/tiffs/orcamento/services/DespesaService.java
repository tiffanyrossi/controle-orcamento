package dev.tiffs.orcamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.tiffs.orcamento.dtos.DespesaDTO;
import dev.tiffs.orcamento.entities.Despesa;
import dev.tiffs.orcamento.repositories.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository repo;
	
	public List<DespesaDTO> getAll() {
		List<Despesa> listaEntity = repo.findAll();
		List<DespesaDTO> listaDTO = new ArrayList<>();
		
		for(Despesa entity : listaEntity) {
			listaDTO.add(entity.toDTO());
		}
		return listaDTO;
	}
	
	public DespesaDTO getOne(Integer id) {
		Optional<Despesa> optional = repo.findById(id);
		Despesa despesa = optional.orElse(new Despesa());
		
		return despesa.toDTO();
	}
	
	public DespesaDTO save(Despesa despesa) {
		return repo.save(despesa).toDTO();
	}
	
	public DespesaDTO update(Despesa despesaAltera, Integer id) {
		Optional<Despesa> despesaDb = repo.findById(id);
		
		if (despesaDb.isPresent()) {
			Despesa obj = despesaDb.get();
			
			obj.setData(despesaAltera.getData());
			obj.setDescricao(despesaAltera.getDescricao());
			obj.setValor(despesaAltera.getValor());
			
			return repo.save(obj).toDTO();
		} else {
			return new Despesa().toDTO();
		}
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	

}
