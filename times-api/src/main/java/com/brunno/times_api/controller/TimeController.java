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

import com.brunno.times_api.model.Time;
import com.brunno.times_api.services.TimeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    TimeService timeService;

    @PostMapping
    public ResponseEntity<Time> cadastrarTime(@Valid @RequestBody Time time) {
        return ResponseEntity.status(HttpStatus.CREATED).body(timeService.salvarTime(time));
    }

    @GetMapping
    public ResponseEntity<Page<Time>> listarTime (Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(timeService.listarTime(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarTime (@PathVariable ("id") Long id) {
        Time time = timeService.buscarTimePeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(time);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTime (@PathVariable("id") Long id){
        Time time = timeService.buscarTimePeloId(id);

        if (Objects.isNull(time)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        }

        timeService.deletarTime(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizarTime (@PathVariable("id") long id,
                                                @Valid @RequestBody Time dadosTime) {
        Time timeExistente = timeService.buscarTimePeloId(id);

        if (Objects.isNull(timeExistente)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }

        Time timeAtualizado = timeService.atualizarTime(id, dadosTime);
        return ResponseEntity.ok(timeAtualizado);
    }
    
}
