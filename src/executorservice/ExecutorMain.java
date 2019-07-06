package executorservice;

import exampleexecutorservice.thread.ThreadCNN;
import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.dto.Result;
import exampleexecutorservice.thread.ThreadFIF;
import exampleexecutorservice.thread.ThreadRegister;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author ezmonte
 */
public class ExecutorMain {

    static ExecutorService service = Executors.newFixedThreadPool(4);
    static List<Callable> listTheread = new ArrayList<Callable>();
    static List<Integrant> listIntegrante = Integrant.generateDataDummy();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        createThread();
        processThread();
        printResults();
    }

    private static void createThread() {
        int i = 1;
        for (Integrant integranteDTO : listIntegrante) {
            startRegister(integranteDTO, i);
            startCNN(integranteDTO, i);
            startFIF(integranteDTO, i);
            i++;
        }
    }

    static void startRegister(Integrant integrante, int i) {
        ThreadRegister registraduria = new ThreadRegister(i, integrante);
        listTheread.add(registraduria);

    }

    static void startCNN(Integrant integrante, int i) {
        ThreadCNN snr = new ThreadCNN(i, integrante);
        listTheread.add(snr);
    }

    static void startFIF(Integrant integrante, int i) {
        ThreadFIF snr = new ThreadFIF(i, integrante);
        listTheread.add(snr);
    }

    private static void printResults() {
        System.out.println("------------------------------------------------------------------------------");
        for (Integrant integranteDTO : listIntegrante) {
            Map<String, Result> result = integranteDTO.getResult();
            System.out.println("Integrante: " + integranteDTO.getIdentificationType() + "-" + integranteDTO.getIdentificationNumber());
            for (Map.Entry<String, Result> entry : result.entrySet()) {
                Result resultThread = (Result) entry.getValue();
                System.out.println("Cruce: " + entry.getKey() + " resultado respuesta: " + resultThread.getRespuesta() + " observacion: " + resultThread.getObservacion());
            }
            System.out.println("------------------------------------------------------------------------------");
        }
    }

    private static List<Future<Integrant>> processThread() {

        List<Future<Integrant>> resultList = new ArrayList<>();
        for (Callable call : listTheread) {
            Future<Integrant> resultado = service.submit(call);
            resultList.add(resultado);
        }
        //service.awaitTermination(5, TimeUnit.SECONDS);
        service.shutdown();
        while (!service.isTerminated()) {
        }
        return resultList;
    }

    private static void processFuture(List<Future<Integrant>> resultList) {
        for (Future<Integrant> future : resultList) {
            //for (Future<Result> future : resultList) {
            // System.out.println("future = " + future.get().getIdentificationType() + " " + future.get().getIdentificationNumber() + " " + future.get().());
            //System.out.println("future = " + future.get().getRespuesta()+ " - " + future.get().getObservacion());
        }
    }

}
