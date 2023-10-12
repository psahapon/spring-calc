package com.tele2demo.springcalc;

import com.tele2demo.springcalc.model.Calculation;
import com.tele2demo.springcalc.model.Operation;
import com.tele2demo.springcalc.repository.CalculationRepository;
import com.tele2demo.springcalc.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class SpringCalcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCalcApplication.class, args);
	}

	@Autowired
	private CalculationRepository calculationRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Override
	public void run(String... args) {
		this.calculationRepository.save(new Calculation("+","1","1",1.0));
		this.calculationRepository.save(new Calculation("+","2","2",4.0));
		this.calculationRepository.save(new Calculation("-","2","2",0.0));
		this.calculationRepository.save(new Calculation("*","2","2",4.0));
		this.calculationRepository.save(new Calculation("/","2","2",1.0));

		this.operationRepository.save(new Operation("1+1",new Timestamp(System.currentTimeMillis())));
		this.operationRepository.save(new Operation("2+2",new Timestamp(System.currentTimeMillis())));
		this.operationRepository.save(new Operation("2-2",new Timestamp(System.currentTimeMillis())));
		this.operationRepository.save(new Operation("2*2",new Timestamp(System.currentTimeMillis())));
		this.operationRepository.save(new Operation("2/2",new Timestamp(System.currentTimeMillis())));
	}

}
