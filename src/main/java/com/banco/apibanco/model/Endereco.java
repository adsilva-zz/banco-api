package com.banco.apibanco.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

	@Id
	@GeneratedValue
	private UUID id;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private int numero;
//	@OneToOne(mappedBy = "endereco")
//	private Cliente cliente;
//	@OneToOne(mappedBy = "endereco")
//	private Agencia agencia;
}
