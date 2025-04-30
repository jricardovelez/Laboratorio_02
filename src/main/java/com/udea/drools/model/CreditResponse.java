package com.udea.drools.model;

public class CreditResponse {
    private boolean approved;
    private double approvedAmount;
    private double interestRate;
    private String message;

    // Constructor vacío
    public CreditResponse() {}

    // Constructor con parámetros
    public CreditResponse(boolean approved, double approvedAmount, double interestRate, String message) {
        this.approved = approved;
        this.approvedAmount = approvedAmount;
        this.interestRate = interestRate;
        this.message = message;
    }

    // Getters y Setters
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}