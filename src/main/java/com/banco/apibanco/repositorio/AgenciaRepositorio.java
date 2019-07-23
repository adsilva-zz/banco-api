package com.banco.apibanco.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.apibanco.model.Agencia;

@Repository
public interface AgenciaRepositorio extends JpaRepository<Agencia, UUID> {

}
