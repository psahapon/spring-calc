package com.tele2demo.springcalc.controller;

import com.tele2demo.springcalc.exception.ApiRequestException;
import com.tele2demo.springcalc.model.Calculation;
import com.tele2demo.springcalc.model.Operation;
import com.tele2demo.springcalc.repository.CalculationRepository;
import com.tele2demo.springcalc.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api")
public class CalculationController {
    @Autowired
    private CalculationRepository calculationRepository;

    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("calculations")
    public List<Calculation> getCalculations(){
        return this.calculationRepository.findAll();
    }

    @RequestMapping(value = "calculate", method = RequestMethod.GET)
    public ResponseEntity calculate(@RequestParam("operator") String operator,
                                    @RequestParam("operand1") String operand1,
                                    @RequestParam("operand2") String operand2){
        try {
            String expr = operand1 + operator + operand2;
            Optional<Calculation> result = this.calculationRepository.findById(expr);
            if (result.isEmpty()) {

                Double opr1 = Double.valueOf(operand1);
                Double opr2 = Double.valueOf(operand2);
                double calc_result = 0;
                switch (operator) {
                    case "+" -> calc_result = opr1 + opr2;
                    case "-" -> calc_result = opr1 - opr2;
                    case "*" -> calc_result = opr1 * opr2;
                    case "/" -> calc_result = opr1 / opr2;
                    default -> throw new ApiRequestException("The operator (" + operator + ") is not supported");
                }
                Calculation calc = new Calculation(operator, operand1, operand2, calc_result);
                this.calculationRepository.save(calc);
                this.operationRepository.save(new Operation(expr, new Timestamp(System.currentTimeMillis())));
                result = Optional.of(calc);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new ApiRequestException("The provided Operand is not a valid number: "+e.getMessage());
        } catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
