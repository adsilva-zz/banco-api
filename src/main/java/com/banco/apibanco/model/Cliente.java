package com.banco.apibanco.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
}
