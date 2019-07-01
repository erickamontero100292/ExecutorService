package exampleexecutorservice.thread;

import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.dto.Result;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ezmonte
 */
public class ThreadRegister implements Callable<Integrant> {

    int id;
    Integrant integrant;
    Result result = new Result();

    public ThreadRegister(Integrant integrante, int id) {
        this.integrant = integrante;
        this.id = id;
    }

    @Override
    public  Integrant call() throws Exception {
        result = Result.getInstancia();
        
        if (integrant.getIdentificationType().equalsIgnoreCase("CE")) {
            integrant.setApprovedRegister(false);
            TimeUnit.MILLISECONDS.sleep(10000);
        } else {
            integrant.setApprovedRegister(true);
        }
        System.out.println("Finish with register - "+  this.id);

        return integrant;
    }

}