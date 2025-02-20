package com.brunno.times_api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunno.times_api.model.Jogador;
import com.brunno.times_api.services.JogadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> cadastrarJogador(@Valid @RequestBody Jogador jogador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.salvarJogador(jogador));
    }

    @GetMapping
    public ResponseEntity<Page<Jogador>> listarJogador(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.listarJogador(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogador(@PathVariable("id") Long id) {
        Jogador jogador = jogadorService.buscarJogadorPeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(jogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable("id") Long id) {
        Jogador jogador = jogadorService.buscarJogadorPeloId(id);

        if (Objects.isNull(jogador)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        jogadorService.deletarJogador(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable("id") Long id,
                                                    @Valid @RequestBody Jogador dadosJogador) {
        Jogador jogadorAtualizado = jogadorService.buscarJogadorPeloId(id);

        if (Objects.isNull(jogadorAtualizado)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.atualizarJogador(id, dadosJogador));
    }

}