package com.udea.drools.service;

import com.udea.drools.model.CreditRequest;
import com.udea.drools.model.CreditResponse;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditEvaluationService {

    @Autowired
    private KieContainer kieContainer;

    public CreditResponse evaluateCredit(CreditRequest request) {
        // Crear una respuesta inicial
        CreditResponse response = new CreditResponse();

        // Crear una sesión de Drools
        KieSession kieSession = kieContainer.newKieSession();

        try {
            // Insertar los hechos (request y response) en la sesión
            kieSession.insert(request);
            kieSession.insert(response);

            // Ejecutar todas las reglas
            kieSession.fireAllRules();
        } finally {
            // Liberar la sesión
            kieSession.dispose();
        }

        return response;
    }
}