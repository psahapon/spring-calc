package com.tele2demo.springcalc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="calculation")
public class Calculation {
    @Id
    @Column(name="expression")
    private String expression;

    @Column(name="operator")
    private String operator;

    @Column(name="operand1")
    private Double operand1;

    @Column(name="operand2")
    private Double operand2;

    @Column(name="result")
    private Double result;
    public Calculation(String operator, String operand1, String operand2, Double result) {
        this.expression = operand1 + operator + operand2;
        this.operator = operator;
        this.operand1 = Double.parseDouble(operand1);
        this.operand2 = Double.parseDouble(operand2);
        this.result = result;
    }

    public Calculation() {
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }
}
