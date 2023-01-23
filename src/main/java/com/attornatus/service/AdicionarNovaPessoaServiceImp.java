package com.attornatus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@Service
public class AdicionarNovaPessoaServiceImp {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void adicionarPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
}
