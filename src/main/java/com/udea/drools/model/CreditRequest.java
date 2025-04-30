package com.udea.drools.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreditRequest {
    @NotNull(message = "El cliente es obligatorio")
    @Valid
    private Customer customer;

    @NotBlank(message = "El tipo de crédito es obligatorio")
    private String creditType; // personal, hipotecario, automotriz

    @NotNull(message = "El monto solicitado es obligatorio")
    @Min(value = 1000, message = "El monto solicitado debe ser al menos 1000")
    private double requestedAmount;

    // Constructor vacío
    public CreditRequest() {}

    // Constructor con parámetros
    public CreditRequest(Customer customer, String creditType, double requestedAmount) {
        this.customer = customer;
        this.creditType = creditType;
        this.requestedAmount = requestedAmount;
    }

    // Getters y Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}