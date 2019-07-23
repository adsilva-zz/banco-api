package com.banco.apibanco.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cliente {

	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cpf;
	private String rg;
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private List<Conta> listaContas;
}
