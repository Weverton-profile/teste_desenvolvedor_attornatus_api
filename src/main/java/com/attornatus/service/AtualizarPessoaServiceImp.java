package com.attornatus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@Service
public class AtualizarPessoaServiceImp {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void atualizarPessoa(String nome_pessoa,Pessoa pessoa) {
		Pessoa novaPessoa = pessoaRepository.findByNome(nome_pessoa);
		System.out.println(novaPessoa.getEnderecos().get(0).getId());
		if (novaPessoa.getNome() != null ) {
			novaPessoa.setNome(pessoa.getNome());
			novaPessoa.setData_nascimento(pessoa.getData_nascimento());
		}
		pessoaRepository.save(novaPessoa);
	}
}
