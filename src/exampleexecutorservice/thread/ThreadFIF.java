/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleexecutorservice.thread;

import exampleexecutorservice.dto.Integrant;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ericka Montero
 */
public class ThreadFIF extends MainThread implements Callable<Integrant> {

    public ThreadFIF(int id, Integrant integrant) {
        super(id, integrant);
    }

    @Override
    public Integrant call() throws Exception {

        addCrossing("FIF");
        validateInformation();

        System.out.println("Finish with FIF - " + this.id);

        return integrant;
    }

    private void validateInformation() throws InterruptedException {

        if (integrant.getIdentificationNumber().endsWith("0")) {
            fillUpInformation(false, "Rechazado por cruce");
            TimeUnit.MILLISECONDS.sleep(10000);
        } else {
            fillUpInformation(true);
        }
    }

}
