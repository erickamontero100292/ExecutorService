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
public class ThreadFIF  extends MainThread implements Callable<Integrant> {

    public ThreadFIF(int id, Integrant integrant) {
        super(id, integrant);
    }

    @Override
    public  Integrant call() throws Exception {
      integrant.getResult().put("FIF", result);
         if (integrant.getIdentificationType().equalsIgnoreCase("CE")) {
            result.setRespuesta(false);
            result.setObservacion("Rechazado por cruce");
            TimeUnit.MILLISECONDS.sleep(10000);
        } else {
            result.setRespuesta(true);
        }
        System.out.println("Finish with FIF - "+  this.id);

       

        return integrant;
    }

}