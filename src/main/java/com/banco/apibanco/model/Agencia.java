package com.banco.apibanco.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "agencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String numAgencia;
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

}
