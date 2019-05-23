package com.banco.apibanco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "conta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private double valor;
	private String numeroConta;
}
