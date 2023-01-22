package com.attornatus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.datasource.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping(path = "/listar")
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Optional<Pessoa>> buscarPessoaPorId(@PathVariable(name = "id", required = true) Long id_pessoa) {
		return ResponseEntity.ok(pessoaRepository.findById(id_pessoa));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionarPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	@PutMapping(path = "/atualizar/{nome}")
	public void atualizarPessoa(@PathVariable(name = "nome", required = true) String nome_pessoa, @RequestBody Pessoa pessoa) {
		Pessoa novaPessoa = pessoaRepository.findByNome(nome_pessoa);
		novaPessoa.setNome(pessoa.getNome());
		novaPessoa.setData_nascimento(pessoa.getData_nascimento());
		pessoaRepository.save(novaPessoa);
	}

}
