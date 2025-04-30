package com.udea.drools.controller;

import com.udea.drools.model.CreditRequest;
import com.udea.drools.model.CreditResponse;
import com.udea.drools.model.Customer;
import com.udea.drools.service.CreditEvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credit")
public class CreditEvaluationController {

    @Autowired
    private CreditEvaluationService evaluationService;

    // Endpoint REST
    @PostMapping("/api/evaluate")
    @ResponseBody
    public CreditResponse evaluateCreditApi(@Valid @RequestBody CreditRequest request, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errores de validación");
            return new CreditResponse(false, 0.0, 0.0, "Error de validación: " + errorMessage);
        }
        return evaluationService.evaluateCredit(request);
    }

    // Mostrar formulario web
    @GetMapping("/form")
    public String showCreditForm(Model model) {
        CreditRequest creditRequest = new CreditRequest();
        creditRequest.setCustomer(new Customer());
        model.addAttribute("creditRequest", creditRequest);
        return "credit_form";
    }

    // Procesar solicitud desde el formulario web
    @PostMapping("/evaluate")
    public String evaluateCreditWeb(@Valid CreditRequest creditRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores de validación, volver al formulario con los errores
            return "credit_form";
        }
        CreditResponse response = evaluationService.evaluateCredit(creditRequest);
        model.addAttribute("creditResponse", response);
        return "credit_result";
    }
}