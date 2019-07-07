package exampleexecutorservice.thread;

import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.dto.Result;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ezmonte
 */
public class ThreadRegister extends MainThread implements Callable<Integrant> {

    public ThreadRegister(int id, Integrant integrant) {
        super(id, integrant);
    }

   
     @Override
    public  Integrant call() throws Exception {
        integrant.getResult().put("Register", result);
        if (integrant.getIdentificationType().equalsIgnoreCase("CE")) {
            result.setRespuesta(false);
            result.setObservacion("Rechazado por CE");
            TimeUnit.MILLISECONDS.sleep(10000);
        } else {
            result.setRespuesta(true);
        }
        System.out.println("Finish with register - "+  this.id);

        return integrant;
    }

}