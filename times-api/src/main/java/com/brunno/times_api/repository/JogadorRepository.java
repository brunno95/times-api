package com.brunno.times_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunno.times_api.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
