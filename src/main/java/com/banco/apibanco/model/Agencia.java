package com.banco.apibanco.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "agencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agencia {

	@Id
	@GeneratedValue
	private UUID id;
	private String numAgencia;
	private Endereco endereco;

}
