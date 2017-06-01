package com.oficial.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Trabalho;
import com.oficial.domain.repository.TrabalhoRepository;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoResource {
	
	private TrabalhoRepository repositorio;

	public TrabalhoResource(TrabalhoRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@PostMapping
	public Trabalho saveTrabalho(@RequestBody Trabalho trabalho) {
		return repositorio.save(trabalho);
	}

	@GetMapping
	public Iterable<Trabalho> getAllTrabalhos() {
		return repositorio.findAll();
	}

	@GetMapping(value = "/{id}")
	public Trabalho getById(@PathVariable Long id) {
		return repositorio.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void removeTrabalho(@PathVariable Long id) {
		repositorio.delete(id);
	}

	@PutMapping(value = "/{id}")
	public Trabalho updateTrabalho(@PathVariable Long id, @RequestBody Trabalho trabalho) {
		return repositorio.save(trabalho);
	}

}
