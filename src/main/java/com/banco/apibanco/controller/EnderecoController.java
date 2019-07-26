package com.banco.apibanco.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.banco.apibanco.dto.requisicoes.EnderecoDTO;
import com.banco.apibanco.dto.respostas.EnderecosResponse;
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
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand("banco/v1/endereco/{id}", null)
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<EnderecosResponse>> listarEndereco() {
		List<EnderecosResponse> enderecos = enderecoServico.listarEndereco();
		if (ObjectUtils.isEmpty(enderecos)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(enderecos);
	}

	@GetMapping
	public ResponseEntity<Endereco> buscarEndereco() {

		Endereco endereco = enderecoServico.buscarEndereco(idEndereco);
	}
}
