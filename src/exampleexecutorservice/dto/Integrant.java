package exampleexecutorservice.dto;

/**
 *
 * @author ezmonte
 */
public class Integrant {

    private String identificationType;
    private String identificationNumber;
    private Integer registerResult;
    private boolean approvedRegister = false;

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

    public Integer getRegisterResult() {
        return registerResult;
    }

    public void setRegisterResult(Integer registerResult) {
        this.registerResult = registerResult;
    }

    public boolean isApprovedRegister() {
        return approvedRegister;
    }

    public void setApprovedRegister(boolean approvedRegister) {
        this.approvedRegister = approvedRegister;
    }

    @Override
    public String toString() {
        return "Integrant{" + "identificationType=" + identificationType + ", identificationNumber=" + identificationNumber + ", registerResult=" + registerResult + ", approvedRegister=" + approvedRegister + '}';
    }


         

}