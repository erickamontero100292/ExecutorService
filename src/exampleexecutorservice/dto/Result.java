package exampleexecutorservice.dto;

/**
 *
 * @author ezmonte
 */
public class Result {

    private static Result instancia;
    private Boolean respuesta;
    private String nombre;
    private String observacion;
    private String obervaFormateado;

    public static Result getInstancia() {
        if (instancia == null) {
            instancia = new Result();
        }
        return instancia;
    }

    public static void setInstancia(Result instancia) {
        Result.instancia = instancia;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObervaFormateado() {
        return obervaFormateado;
    }

    public void setObervaFormateado(String obervaFormateado) {
        this.obervaFormateado = obervaFormateado;
    }

}
