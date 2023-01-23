package com.attornatus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@Service
public class BuscarPessoaPorIdServiceImp {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Optional<Pessoa> buscarPessoaPorId(Long id_pessoa) {
		return pessoaRepository.findById(id_pessoa);
	}
}
