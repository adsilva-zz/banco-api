package com.banco.apibanco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.apibanco.dto.EnderecoDTO;
import com.banco.apibanco.model.Endereco;
import com.banco.apibanco.servico.EnderecoServico;

@RestController
@RequestMapping("banco/v1/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoServico enderecoServico;

	@PostMapping
	public ResponseEntity<Endereco> cadastrarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
		enderecoServico.cadastrarEndereco(enderecoDTO);
		return new ResponseEntity<Endereco>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Endereco>> listarEndereco() {
		List<Endereco> enderecos = enderecoServico.listarEndereco();
		if (ObjectUtils.isEmpty(enderecos)) {
			return new ResponseEntity<List<Endereco>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.OK);
	}

	
}
