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

import com.attornatus.model.Pessoa;
import com.attornatus.service.AdicionarNovaPessoaServiceImp;
import com.attornatus.service.AtualizarPessoaServiceImp;
import com.attornatus.service.BuscarPessoaPorIdServiceImp;
import com.attornatus.service.ListarPessoasServiceImp;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private ListarPessoasServiceImp listarPessoasServiceImp;
	@Autowired
	private BuscarPessoaPorIdServiceImp buscarPessoaPorIdServiceImp;
	@Autowired
	private AdicionarNovaPessoaServiceImp adicionarNovaPessoaServiceImp;
	@Autowired
	private AtualizarPessoaServiceImp atualizarPessoaServiceImp;

	@GetMapping(path = "/listar")
	public List<Pessoa> listarPessoas() {
		return listarPessoasServiceImp.listarPessoas();
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Optional<Pessoa>> buscarPessoaPorId(@PathVariable(name = "id", required = true) Long id_pessoa) {
		return ResponseEntity.ok(buscarPessoaPorIdServiceImp.buscarPessoaPorId(id_pessoa));
	}
	
	@PostMapping(path = "/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionarPessoa(@RequestBody Pessoa pessoa) {
		adicionarNovaPessoaServiceImp.adicionarPessoa(pessoa);
	}
	
	@PutMapping(path = "/atualizar/{nome}")
	public void atualizarPessoa(@PathVariable(name = "nome", required = true) String nome_pessoa, @RequestBody Pessoa pessoa) {
		atualizarPessoaServiceImp.atualizarPessoa(nome_pessoa, pessoa);
	}

}
