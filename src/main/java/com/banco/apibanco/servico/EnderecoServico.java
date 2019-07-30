package com.banco.apibanco.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.banco.apibanco.dto.requisicoes.EnderecoDTO;
import com.banco.apibanco.dto.respostas.EnderecosResponse;
import com.banco.apibanco.model.Endereco;

public interface EnderecoServico {

	Endereco cadastrarEndereco(EnderecoDTO enderecoDTO);

	List<EnderecosResponse> listarEndereco();

	Optional<Endereco> buscarEndereco(UUID idEndereco);

	boolean deletarEndereco(UUID idEndereco);

	Endereco atualizarEndereco(Endereco novoEndereco, UUID idEndereco);
}
