package com.banco.apibanco.controller;

import com.banco.apibanco.dto.requisicoes.EnderecoDTO;
import com.banco.apibanco.dto.respostas.EnderecosResponse;
import com.banco.apibanco.model.Endereco;
import com.banco.apibanco.servico.EnderecoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("banco/v1/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServico enderecoServico;

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoServico.cadastrarEndereco(enderecoDTO);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("banco/v1/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);

    }

    @GetMapping
    public ResponseEntity<List<EnderecosResponse>> listarEndereco() {
        List<EnderecosResponse> enderecos = enderecoServico.listarEndereco();
        if (ObjectUtils.isEmpty(enderecos)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable(value = "id") String idEndereco) {
        Optional<Endereco> endereco = enderecoServico.buscarEndereco(UUID.fromString(idEndereco));
        if (!endereco.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(endereco.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> deletarEndereco(@PathVariable(value = "id") String idEndereco){
        if (enderecoServico.deletarEndereco(UUID.fromString(idEndereco))){
            return null;
        }
        return null;
    }
}
