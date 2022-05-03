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

import dev.tiffs.orcamento.dtos.DespesaDTO;
import dev.tiffs.orcamento.services.DespesaService;

@RestController
@RequestMapping("despesas")
public class DespesaController {
	@Autowired
	private DespesaService service;
	
	@GetMapping()
	public ResponseEntity<List<DespesaDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DespesaDTO> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
	}
	
	@PostMapping()
	public ResponseEntity<DespesaDTO> save(@Valid @RequestBody DespesaDTO despesa) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(despesa.toEntity()));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<DespesaDTO> update(@PathVariable Integer id, @Valid @RequestBody DespesaDTO despesa) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(despesa.toEntity(), id));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
