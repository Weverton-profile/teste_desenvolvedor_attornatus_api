package com.attornatus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@SpringBootTest
@WebAppConfiguration
public class AdicionarNovaPessoaServiceImpTest {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private AdicionarNovaPessoaServiceImp serviceImp;
	
	@Test
	public void adicionarNovaPessoaTest() {
		Pessoa pessoaAdicionada = new Pessoa("Weverton", "23/05/1997", null);
		serviceImp.adicionarPessoa(pessoaAdicionada);
		Pessoa pessoaTest = pessoaRepository.findByNome("Weverton");
		assertEquals(pessoaTest.getData_nascimento(), pessoaTest.getData_nascimento());
	}
}
