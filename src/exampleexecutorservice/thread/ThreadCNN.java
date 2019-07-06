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
public class ThreadCNN implements Callable<Integrant> {

    int id;
    Integrant integrant;
    Result result = new Result();

    public ThreadCNN(Integrant integrante, int id) {
        this.integrant = integrante;
        this.id = id;
    }

    @Override
    public Integrant call() throws Exception {
        result = Result.getInstancia();
        Random r = new Random();
        int valorDado = r.nextInt(2000) * 3;
        try {
            if (integrant.getIdentificationType().equalsIgnoreCase("CE")) {
                integrant.setApprovedRegister(true);
                TimeUnit.MILLISECONDS.sleep(1000);
                if (integrant.getIdentificationNumber().equals("123451")) {
                    TimeUnit.MILLISECONDS.sleep(10000);
                    throw new Exception();
                }

            } else {
                integrant.setApprovedRegister(false);
            }
        } catch (Exception e) {
            integrant.setApprovedRegister(false);
            TimeUnit.MILLISECONDS.sleep(10000);
            System.out.println("Finish CNN  Exception" + integrant.getIdentificationType() + " - " + this.id);
        }
        System.out.println("Finish CNN " + integrant.getIdentificationType() + " - " + this.id);
        return integrant;
    }
}
