package com.attornatus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@Service
public class BuscarEnderecoPrincipalServiceImp {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Endereco> buscarEnderecoPrincipal(String nome_pessoa) {
		Pessoa novaPessoa = pessoaRepository.findByNome(nome_pessoa);
		List<Endereco> enderecos = novaPessoa.getEnderecos();
		List<Endereco> endereco_p = new ArrayList<>();
		for (Endereco endereco : enderecos) {
			if (endereco.getPrincipal()) {
				endereco_p.add(endereco);
			}
		}
		return endereco_p;
	}
}
