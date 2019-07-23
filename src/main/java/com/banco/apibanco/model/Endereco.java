package com.banco.apibanco.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private int numero;
}
