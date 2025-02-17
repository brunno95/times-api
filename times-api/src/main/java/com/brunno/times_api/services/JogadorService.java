package com.brunno.times_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brunno.times_api.model.Jogador;
import com.brunno.times_api.repository.JogadorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    public Jogador salvarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Page<Jogador> listarJogador(Pageable paginacao) {
        return jogadorRepository.findAll(paginacao);
    }

    public Jogador buscarJogadorPeloId(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado com ID: " + id));

    }

    public Jogador atualizarJogador(Long id, Jogador dadosJogador) {
        Jogador jogadorExistente = buscarJogadorPeloId(id);

        jogadorExistente.setNome(dadosJogador.getNome());
        jogadorExistente.setIdade(dadosJogador.getIdade());
        jogadorExistente.setNacionalidade(dadosJogador.getNacionalidade());
        jogadorExistente.setNumeroCamisa(dadosJogador.getNumeroCamisa());
        jogadorExistente.setPosicao(dadosJogador.getPosicao());
        jogadorExistente.setTime(dadosJogador.getTime());

        return jogadorRepository.save(jogadorExistente);

    }

    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }
}
