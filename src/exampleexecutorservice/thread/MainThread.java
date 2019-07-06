/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleexecutorservice.thread;

import exampleexecutorservice.dto.Integrant;
import exampleexecutorservice.dto.Result;

/**
 *
 * @author Ericka Montero
 */
public class MainThread {
    
    int id;
    Integrant integrant;
    Result result = new Result();

    public MainThread(int id, Integrant integrant) {
        this.id = id;
        this.integrant = integrant;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Integrant getIntegrant() {
        return integrant;
    }

    public void setIntegrant(Integrant integrant) {
        this.integrant = integrant;
    }

 
    
}
