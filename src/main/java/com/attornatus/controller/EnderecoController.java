package com.attornatus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import com.attornatus.service.AdicionarEnderecoPessoaServiceImp;
import com.attornatus.service.BuscarEnderecoPrincipalServiceImp;
import com.attornatus.service.ListarEnderecosDeUmUsuarioServiceImp;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private AdicionarEnderecoPessoaServiceImp serviceAdicionar;
	@Autowired 
	private BuscarEnderecoPrincipalServiceImp serviceBuscarEnderecoPrincipal;
	@Autowired 
	private ListarEnderecosDeUmUsuarioServiceImp listarEnderecosDeUmUsuario;
	
	@GetMapping(path = "/listar/pessoa/{nome}")
	public ResponseEntity<List<Endereco>> listarEnderecoPessoa(@PathVariable(name = "nome", required = true) String nome_pessoa, @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(listarEnderecosDeUmUsuario.listarEnderecoPessoa(nome_pessoa, pessoa));
	}
	
	@GetMapping(path = "/principal/pessoa/{nome}")
	public ResponseEntity<List<Endereco>> enderecoPrincipalPessoa(@PathVariable(name = "nome", required = true) String nome_pessoa, @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(serviceBuscarEnderecoPrincipal.buscarEnderecoPrincipal(nome_pessoa, pessoa));
	}
	
	@PutMapping(path = "/adicionar/pessoa/{nome}")
	public void adicionarEnderecoPessoa(@PathVariable(name = "nome", required = true) String nome_pessoa, @RequestBody Endereco endereco) {
		serviceAdicionar.adicionarNovoEndereco(nome_pessoa, endereco);
	}
}
