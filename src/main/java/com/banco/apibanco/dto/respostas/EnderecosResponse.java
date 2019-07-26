package com.banco.apibanco.dto.respostas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecosResponse {

	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private int numero;
}
