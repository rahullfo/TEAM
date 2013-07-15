package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class RegistrationSummary extends BaseObject {

    private int id;
    private int totalAttempts;
    private int chargingSuccess;
    private int lowBalanceFailure;
    private int technicalErrorFailure;
    private int noGatewayResponse;
    private int pendingRegistration;
    private String currentDate;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the totalAttempts
     */
    public int getTotalAttempts() {
        return totalAttempts;
    }

    /**
     * @param totalAttempts the totalAttempts to set
     */
    public void setTotalAttempts(int totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    /**
     * @return the chargingSuccess
     */
    public int getChargingSuccess() {
        return chargingSuccess;
    }

    /**
     * @param chargingSuccess the chargingSuccess to set
     */
    public void setChargingSuccess(int chargingSuccess) {
        this.chargingSuccess = chargingSuccess;
    }

    /**
     * @return the lowBalanceFailure
     */
    public int getLowBalanceFailure() {
        return lowBalanceFailure;
    }

    /**
     * @param lowBalanceFailure the lowBalanceFailure to set
     */
    public void setLowBalanceFailure(int lowBalanceFailure) {
        this.lowBalanceFailure = lowBalanceFailure;
    }

    /**
     * @return the technicalErrorFailure
     */
    public int getTechnicalErrorFailure() {
        return technicalErrorFailure;
    }

    /**
     * @param technicalErrorFailure the technicalErrorFailure to set
     */
    public void setTechnicalErrorFailure(int technicalErrorFailure) {
        this.technicalErrorFailure = technicalErrorFailure;
    }

    /**
     * @return the noGatewayResponse
     */
    public int getNoGatewayResponse() {
        return noGatewayResponse;
    }

    /**
     * @param noGatewayResponse the noGatewayResponse to set
     */
    public void setNoGatewayResponse(int noGatewayResponse) {
        this.noGatewayResponse = noGatewayResponse;
    }
  
    /**
     * @return the currentDate
     */
    public String getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * @return the pendingRegistration
     */
    public int getPendingRegistration() {
        return pendingRegistration;
    }

    /**
     * @param pendingRegistration the pendingRegistration to set
     */
    public void setPendingRegistration(int pendingRegistration) {
        this.pendingRegistration = pendingRegistration;
    }

 
}
