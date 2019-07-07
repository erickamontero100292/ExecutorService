package exampleexecutorservice.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author ezmonte
 */
public class Integrant {

    private String identificationType;
    private String identificationNumber;
    Map<String, Result> result = new ConcurrentHashMap<>();

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Map<String, Result> getResult() {
        return result;
    }

    public void setResult(Map<String, Result> result) {
        this.result = result;
    }

    public static List<Integrant> generateDataDummy() {
        List<Integrant> listIntegrante = new ArrayList<Integrant>();
        for (int i = 0; i < 20; i++) {

            Integrant integrant = new Integrant();
            if (i % 2 == 0) {
                integrant.setIdentificationType("CI");
            } else {
                integrant.setIdentificationType("CE");
            }

            integrant.setIdentificationNumber("12345" + String.valueOf(i));
            listIntegrante.add(integrant);

        }
        return listIntegrante;
    }

}
