package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class DeactivationSummary extends BaseObject {

    private int id;
    private int totalDeactivations;
    private int voluntaryChurn;
    private int lowBalanceChurn;
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
     * @return the totalDeactivations
     */
    public int getTotalDeactivations() {
        return totalDeactivations;
    }

    /**
     * @param totalDeactivations the totalDeactivations to set
     */
    public void setTotalDeactivations(int totalDeactivations) {
        this.totalDeactivations = totalDeactivations;
    }

    /**
     * @return the voluntaryChurn
     */
    public int getVoluntaryChurn() {
        return voluntaryChurn;
    }

    /**
     * @param voluntaryChurn the voluntaryChurn to set
     */
    public void setVoluntaryChurn(int voluntaryChurn) {
        this.voluntaryChurn = voluntaryChurn;
    }

    /**
     * @return the lowBalanceChurn
     */
    public int getLowBalanceChurn() {
        return lowBalanceChurn;
    }

    /**
     * @param lowBalanceChurn the lowBalanceChurn to set
     */
    public void setLowBalanceChurn(int lowBalanceChurn) {
        this.lowBalanceChurn = lowBalanceChurn;
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

   
 
}
