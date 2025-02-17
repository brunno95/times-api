package com.brunno.times_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tb_jogador")
public class Jogador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JOGADOR")
    private Long id;

    @NotNull
    @Column(name = "NOME_JOGADOR", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "IDADE_JOGADOR", nullable = false)
    private String idade;

    @NotNull
    @Column(name = "PAÍS_JOGADOR", nullable = false)
    private String nacionalidade;

    @NotNull
    @Column(name = "NR_CAM_JOGADOR", nullable = false)
    private String numeroCamisa;

    @NotNull
    @Column(name = "POSICAO_JOGADOR", nullable = false)
    private String posicao;

    @NotNull
    @Column(name = "TIME_JOGADOR", nullable = false)
    private String time;


}
