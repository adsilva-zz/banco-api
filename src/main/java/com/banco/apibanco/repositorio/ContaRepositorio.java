package com.banco.apibanco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.apibanco.model.Conta;

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, String> {

}
