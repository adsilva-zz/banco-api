package com.banco.apibanco.servico.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.banco.apibanco.dto.EnderecoDTO;
import com.banco.apibanco.model.Endereco;
import com.banco.apibanco.repositorio.EnderecoRepositorio;
import com.banco.apibanco.servico.EnderecoServico;

@Service
public class EnderecoServicoImpl implements EnderecoServico {

	@Autowired
	private EnderecoRepositorio enderecoRepositorio;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO) {
		return enderecoRepositorio.save(conversionService.convert(enderecoDTO, Endereco.class));
	}

	@Override
	public List<Endereco> listarEndereco() {
		return enderecoRepositorio.findAll();
	}

	@Override
	public Endereco buscarEndereco(UUID idEndereco) {
		if (ObjectUtils.isEmpty(idEndereco)) {
			return null; // Lançar exception
		}
		return enderecoRepositorio.getOne(idEndereco);
	}

	@Override
	public boolean deletarEndereco(UUID idEndereco) {
		enderecoRepositorio.delete(buscarEndereco(idEndereco));
		return true;
	}

	@Override
	public Endereco atualizarEndereco(Endereco novoEndereco, UUID idEndereco) {
		Endereco endereco = buscarEndereco(idEndereco);
		if (ObjectUtils.isEmpty(endereco)) {
			return null; // lançar exception
		}
		endereco = Endereco.builder().bairro(novoEndereco.getBairro()).cep(novoEndereco.getCep())
				.cidade(novoEndereco.getCidade()).numero(novoEndereco.getNumero()).rua(novoEndereco.getRua()).build();

		return enderecoRepositorio.save(endereco);
	}

}
