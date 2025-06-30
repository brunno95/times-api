package com.brunno.times_api.model;

import java.time.LocalDate;
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
@Entity(name = "tb_time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIME")
    private long id;

    @NotNull
    @Column(name = "NOME_TIME", nullable = false)
    private String nome;

    @NotNull
    @Column(name ="PAIS_TIME", nullable = false)
    private String pais;

    @NotNull
    @Column(name = "ESTADIO_TIME", nullable = false)
    private String estadio;

    @NotNull
    @Column(name = "TITULOS_TIME", nullable = false)
    private String titulos;

    @NotNull
    @Column(name = "TECNICO_TIME", nullable = false)
    private String tecnico;

    @NotNull
    @Column(name = "ANO_FUND_TIME", nullable = false)
    private LocalDate fundacao;

    @NotNull
    @Column(name = "MASCOTE_TIME", nullable = false)
    private String mascote;
    
}
