package com.banco.apibanco.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.ws.BindingType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "conta")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private double saldo;
	private String numeroConta;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "agencia_id")
	private Agencia agencia;
}
