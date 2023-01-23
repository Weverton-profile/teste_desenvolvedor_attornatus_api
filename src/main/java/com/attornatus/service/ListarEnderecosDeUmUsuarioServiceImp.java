package com.attornatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@Service
public class ListarEnderecosDeUmUsuarioServiceImp {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Endereco> listarEnderecoPessoa(String nome_pessoa) {
		Pessoa novaPessoa = pessoaRepository.findByNome(nome_pessoa);
		List<Endereco> enderecos = novaPessoa.getEnderecos();
		return enderecos;
	}
}
