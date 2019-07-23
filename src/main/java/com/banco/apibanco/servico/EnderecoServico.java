package com.banco.apibanco.servico;

import java.util.List;
import java.util.UUID;

import com.banco.apibanco.dto.EnderecoDTO;
import com.banco.apibanco.model.Endereco;

public interface EnderecoServico {

	public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO);

	public List<Endereco> listarEndereco();

	public Endereco buscarEndereco(UUID idEndereco);

	public boolean deletarEndereco(UUID idEndereco);

	public Endereco atualizarEndereco(Endereco novoEndereco, UUID idEndereco);
}
