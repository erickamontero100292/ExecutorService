package executorservice;


import exampleexecutorservice.thread.ThreadCNN;
import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.thread.ThreadRegister;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ezmonte
 */
public class ExecutorMain {

    static ExecutorService service = Executors.newFixedThreadPool(4);
    static List<Callable> listTheread = new ArrayList<Callable>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integrant> listIntegrante = new ArrayList<Integrant>();
        dataDummy(listIntegrante);
        List<Future<Integrant>> resultList = new ArrayList<>();
        int i = 1;

        for (Integrant integranteDTO : listIntegrante) {
            startRegister(integranteDTO, i);
            startCNN(integranteDTO, i);
            i++;
        }

        for (Callable call : listTheread) {
            Future<Integrant> resultado = service.submit(call);
            resultList.add(resultado);
        }
        //service.awaitTermination(5, TimeUnit.SECONDS);
        service.shutdown();
        while(!service.isTerminated()){
           
        }
        for (Future<Integrant> future : resultList) {

            System.out.println("future = " + future.get().getIdentificationType() + " " + future.get().getIdentificationNumber() + " " + future.get().isApprovedRegister());
        }

        

    }

    static void startRegister(Integrant integrante, int i) {
            ThreadRegister registraduria = new ThreadRegister(integrante, i);
            listTheread.add(registraduria);

        
    }

    static void startCNN(Integrant integrante, int i) {

        ThreadCNN snr = new ThreadCNN(integrante, i);
        listTheread.add(snr);

    }

    private static void dataDummy(List<Integrant> listIntegrante) {

        for (int i = 0; i < 10; i++) {

            Integrant integrant = new Integrant();
            if (i % 2 == 0) {
                integrant.setIdentificationType("CI");
            } else {
                integrant.setIdentificationType("CE");
            }

            integrant.setIdentificationNumber("12345" + String.valueOf(i));
            listIntegrante.add(integrant);

        }
    }
}
