package com.brunno.times_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunno.times_api.model.Time;

@Repository
public interface TimeRepository extends JpaRepository <Time, Long> {

}
