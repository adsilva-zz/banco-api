package com.banco.apibanco.servico.impl;

import com.banco.apibanco.dto.requisicoes.EnderecoDTO;
import com.banco.apibanco.dto.respostas.EnderecosResponse;
import com.banco.apibanco.model.Endereco;
import com.banco.apibanco.repositorio.EnderecoRepositorio;
import com.banco.apibanco.servico.EnderecoServico;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnderecoServicoImpl implements EnderecoServico {

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    private ConversionService conversionService;

    @Override
    public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO) {

        Endereco endereco = enderecoRepositorio.save(conversionService.convert(enderecoDTO, Endereco.class));

        return endereco;
    }

    @Override
    public List<EnderecosResponse> listarEndereco() {
        return enderecoRepositorio.findAll()
                .stream()
                .map(end -> conversionService.convert(end, EnderecosResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Endereco> buscarEndereco(UUID idEndereco) {
        if (ObjectUtils.isEmpty(idEndereco)) {
            return null; // Lançar exception
        }
        return enderecoRepositorio.findById(idEndereco);
    }

    @Override
    public boolean deletarEndereco(UUID idEndereco) {
        enderecoRepositorio.delete(buscarEndereco(idEndereco).get());
        return true;
    }

    @Override
    public Endereco atualizarEndereco(Endereco novoEndereco, UUID idEndereco) {
        Endereco endereco = buscarEndereco(idEndereco).get();
        if (ObjectUtils.isEmpty(endereco)) {
        	return null; // lançar exception
        }
        endereco = Endereco.builder().bairro(novoEndereco.getBairro()).cep(novoEndereco.getCep())
        		.cidade(novoEndereco.getCidade()).numero(novoEndereco.getNumero()).rua(novoEndereco.getRua()).build();
        return enderecoRepositorio.save(endereco);
    }

}
