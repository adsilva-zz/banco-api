package com.banco.apibanco.servico;

import java.util.List;
import java.util.UUID;

import com.banco.apibanco.dto.requisicoes.EnderecoDTO;
import com.banco.apibanco.dto.respostas.EnderecosResponse;
import com.banco.apibanco.model.Endereco;

public interface EnderecoServico {

	public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO);

	public List<EnderecosResponse> listarEndereco();

	public Endereco buscarEndereco(UUID idEndereco);

	public boolean deletarEndereco(UUID idEndereco);

	public Endereco atualizarEndereco(Endereco novoEndereco, UUID idEndereco);
}
