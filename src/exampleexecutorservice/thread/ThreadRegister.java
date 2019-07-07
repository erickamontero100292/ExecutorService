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
    public Integrant call() throws Exception {
        addCrossing("Registre");
        validateInformation();
       
        System.out.println("Finish with register - " + this.id);

        return integrant;
    }



    private void validateInformation() throws InterruptedException {
        
        if (integrant.getIdentificationType().equalsIgnoreCase("CE")) {
            fillUpInformation(false,"Rechazado por CE");
            TimeUnit.MILLISECONDS.sleep(10000);
        } else {
           fillUpInformation(true);
        }
    }

}
