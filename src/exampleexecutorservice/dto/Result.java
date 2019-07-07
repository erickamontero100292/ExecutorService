package exampleexecutorservice.dto;

/**
 *
 * @author ezmonte
 */
public class Result {

    private Boolean respuesta;
    private String observacion;

    public Result() {
        this.respuesta = false;
        this.observacion = new String();
    }
    

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
