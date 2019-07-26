package com.banco.apibanco.conversores;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.banco.apibanco.dto.respostas.EnderecosResponse;
import com.banco.apibanco.model.Endereco;

@Component
public class EnderecoToEnderecoResponse implements Converter<Endereco, EnderecosResponse> {

	@Override
	public EnderecosResponse convert(Endereco source) {
		EnderecosResponse endereco = EnderecosResponse.builder().cep(source.getCep()).bairro(source.getBairro())
				.cidade(source.getCidade()).rua(source.getRua()).numero(source.getNumero()).build();

		return endereco;
	}

}
