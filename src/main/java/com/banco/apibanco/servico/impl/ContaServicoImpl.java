package com.banco.apibanco.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.apibanco.repositorio.ContaRepositorio;

@Service
public class ContaServicoImpl {

	@Autowired
	private ContaRepositorio contaRepositorio;
}
