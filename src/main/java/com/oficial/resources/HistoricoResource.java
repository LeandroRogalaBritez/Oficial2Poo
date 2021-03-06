package com.oficial.resources;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficial.domain.entities.Disciplina;
import com.oficial.domain.entities.Historico;
import com.oficial.domain.repository.HistoricoRepository;
import com.oficial.domain.service.HistoricoService;

@RestController
@RequestMapping("/historico")
public class HistoricoResource {

	private HistoricoRepository historicoRepository;
	private HistoricoService service;

	public HistoricoResource(HistoricoRepository historicoRepository, HistoricoService service) {
		this.historicoRepository = historicoRepository;
		this.service = service;
	}

	@GetMapping
	public Iterable<Historico> getAllHistorico() {
		return historicoRepository.findAll();
	}

	@PostMapping
	public Historico saveHistorico(@RequestBody Historico historico) {
		return historicoRepository.save(historico);
	}

	@PostMapping(value = "/aprovado")
	public Collection<Historico> getAprovados(@RequestBody Collection<Disciplina> disciplinas) {
		return historicoRepository.findByDisciplinaInAndAprovadoTrue(disciplinas);
	}

	@GetMapping(value = "/aluno/{idAluno}")
	public Collection<Historico> getHistoricoAluno(@PathVariable Long idAluno) {
		return service.buscaHistoricoAluno(idAluno);
	}

}
