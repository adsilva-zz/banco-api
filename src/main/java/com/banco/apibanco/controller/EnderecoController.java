package com.banco.apibanco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.apibanco.dto.EnderecoDTO;
import com.banco.apibanco.model.Endereco;
import com.banco.apibanco.servico.EnderecoServico;

@RestController
@RequestMapping("banco/vi/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoServico enderecoServico;

	@PostMapping
	public ResponseEntity<Endereco> cadastrarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
		enderecoServico.cadastrarEndereco(enderecoDTO);
		return new ResponseEntity<Endereco>(HttpStatus.CREATED);
	}
}
