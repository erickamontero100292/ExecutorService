package exampleexecutorservice.thread;

import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.dto.Result;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ericka Montero
 */
public class ThreadCNN extends MainThread implements Callable<Integrant> {

    public ThreadCNN(int id, Integrant integrant) {
        super(id, integrant);
    }

    @Override
    public Integrant call() throws Exception {
        Random r = new Random();
        int valorDado = r.nextInt(2000) * 3;
        try {
            integrant.getResult().put("CNN", result);
            if (integrant.getIdentificationType().equalsIgnoreCase("CE")) {
                result.setRespuesta(true);
                TimeUnit.MILLISECONDS.sleep(1000);
                if (integrant.getIdentificationNumber().equals("123451")) {
                    TimeUnit.MILLISECONDS.sleep(10000);
                    throw new Exception();
                }

            } else {
                result.setRespuesta(false);
            }
        } catch (Exception e) {
            result.setRespuesta(false);
            TimeUnit.MILLISECONDS.sleep(10000);
            System.out.println("Finish CNN  Exception" + integrant.getIdentificationType() + " - " + this.id);
            result.setObservacion("Error: CNN no responde");
        }
        System.out.println("Finish CNN " + integrant.getIdentificationType() + " - " + this.id);
        return integrant;
    }
}
