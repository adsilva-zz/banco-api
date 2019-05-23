package com.banco.apibanco.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.apibanco.repositorio.ContaRepositorio;

@Service
public class ContaServico {

	@Autowired
	private ContaRepositorio contaRepositorio;
}
