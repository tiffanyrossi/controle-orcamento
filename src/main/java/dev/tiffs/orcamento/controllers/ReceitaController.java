package dev.tiffs.orcamento.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.tiffs.orcamento.dtos.ReceitaDTO;
import dev.tiffs.orcamento.services.ReceitaService;

@RestController
@RequestMapping("receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaService service;
	
	@GetMapping()
	public ResponseEntity<List<ReceitaDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ReceitaDTO> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
	}
	
	@PostMapping
	public ResponseEntity<ReceitaDTO> save(@Valid @RequestBody ReceitaDTO receita) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(receita.toEntity()));		
	}
	
	@PatchMapping
	public ResponseEntity<ReceitaDTO> update(@PathVariable Integer id, @Valid @RequestBody ReceitaDTO receita) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(receita.toEntity(), id));
	}
	
	@DeleteMapping
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}