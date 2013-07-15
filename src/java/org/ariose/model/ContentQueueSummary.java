package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class ContentQueueSummary extends BaseObject {

    private int id;
    private int delivered;
    private int pending;
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
     * @return the delivered
     */
    public int getDelivered() {
        return delivered;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    /**
     * @return the pending
     */
    public int getPending() {
        return pending;
    }

    /**
     * @param pending the pending to set
     */
    public void setPending(int pending) {
        this.pending = pending;
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
