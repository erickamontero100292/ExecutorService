/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleexecutorservice.thread;

import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.dto.Result;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ericka Montero
 */
public class ThreadFIF implements Callable<Integrant> {

    int id;
    Integrant integrant;
    Result result = new Result();

    public ThreadFIF(Integrant integrante, int id) {
        this.integrant = integrante;
        this.id = id;
    }

    @Override
    public  Integrant call() throws Exception {
        result = Result.getInstancia();
        
       

        return integrant;
    }

}