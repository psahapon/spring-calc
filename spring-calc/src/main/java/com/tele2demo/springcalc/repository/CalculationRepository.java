package com.tele2demo.springcalc.repository;

import com.tele2demo.springcalc.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, String> {
}
