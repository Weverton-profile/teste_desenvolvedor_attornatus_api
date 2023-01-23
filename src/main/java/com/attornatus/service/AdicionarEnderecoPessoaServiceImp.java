package com.attornatus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import com.attornatus.repository.EnderecoRepository;
import com.attornatus.repository.PessoaRepository;

@Service
public class AdicionarEnderecoPessoaServiceImp {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void adicionarNovoEndereco(String nome_pessoa, Endereco endereco) {
		Pessoa novaPessoa = pessoaRepository.findByNome(nome_pessoa);
		if (novaPessoa.getNome() != null && endereco.getCep() != null) {
			novaPessoa.getEnderecos().add(endereco);
			pessoaRepository.save(novaPessoa);
			novaPessoa = pessoaRepository.findByNome(nome_pessoa);
			Endereco enderecoNovo = novaPessoa.getEnderecos().get(novaPessoa.getEnderecos().size() -1);
			enderecoNovo.setLogradouro(endereco.getLogradouro());
			enderecoNovo.setCep(endereco.getCep());
			enderecoNovo.setNumero(endereco.getNumero());
			enderecoNovo.setCidade(endereco.getCidade());
			enderecoNovo.setPrincipal(endereco.getPrincipal());
			enderecoRepository.save(enderecoNovo);
		}
	}
}
