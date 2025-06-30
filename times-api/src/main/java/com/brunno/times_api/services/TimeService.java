package com.brunno.times_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brunno.times_api.model.Time;
import com.brunno.times_api.repository.TimeRepository;

@Service
public class TimeService {

    @Autowired
    TimeRepository timeRepository;

    public Time salvarTime (Time time) {
        return timeRepository.save(time);
    }
    
    public Page<Time> listarTime(Pageable paginacao) {
        return timeRepository.findAll(paginacao);
    }

    public Time buscarTimePeloId(Long id) {
        return timeRepository.findById(id).orElse(null);
    }

    public Time atualizarTime (Long id, Time dadosTime) {
        Time timeExistente = buscarTimePeloId(id);

        timeExistente.setNome(timeExistente.getNome());
        timeExistente.setPais(timeExistente.getPais());
        timeExistente.setEstadio(timeExistente.getEstadio());
        timeExistente.setTitulos(timeExistente.getTitulos());
        timeExistente.setTecnico(timeExistente.getTecnico());
        timeExistente.setFundacao(timeExistente.getFundacao());
        timeExistente.setMascote(timeExistente.getMascote());

        return timeRepository.save(timeExistente);
    }

    public void deletarTime(long id) {
        timeRepository.deleteById(id);
    }

}
