package com.tele2demo.springcalc.controller;

import com.tele2demo.springcalc.model.Operation;
import com.tele2demo.springcalc.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("operations")
    public List<Operation> getOperations(){
        return this.operationRepository.findAll();
    }


}
