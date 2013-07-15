
package org.ariose.model;
/*
 *
 * @author Sukhdeep
 */
public class OperatorBean {

    private int id;
    private String operatorName;
    private String operatorDescription;
    private byte[] operatorLogo;
    private byte[] file;

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
     * @return the operatorName
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName the operatorName to set
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * @return the operatorDescription
     */
    public String getOperatorDescription() {
        return operatorDescription;
    }

    /**
     * @param operatorDescription the operatorDescription to set
     */
    public void setOperatorDescription(String operatorDescription) {
        this.operatorDescription = operatorDescription;
    }

    /**
     * @return the operatorLogo
     */
    public byte[] getOperatorLogo() {
        return operatorLogo;
    }

    /**
     * @param operatorLogo the operatorLogo to set
     */
    public void setOperatorLogo(byte[] operatorLogo) {
        this.operatorLogo = operatorLogo;
    }

    /**
     * @return the file
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(byte[] file) {
        this.file = file;
    }

    
}
