package com.banco.apibanco.conversores;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.banco.apibanco.dto.EnderecoDTO;
import com.banco.apibanco.model.Endereco;

@Component
public class EnderecoDtoToEndereco implements Converter<EnderecoDTO, Endereco> {

	@Override
	public Endereco convert(EnderecoDTO source) {
		Endereco endereco = Endereco.builder().cep(source.getCep()).bairro(source.getBairro())
				.cidade(source.getCidade()).rua(source.getRua()).numero(source.getNumero()).build();

		return endereco;
	}

}
