/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author A.Rahman
 */

 public class Operator extends BaseObject {
     private Long   operator_id;
     private String operator_name;
    /**
     * @return the operator_id
     */
    public Long getOperator_id() {
        return operator_id;
    }

    /**
     * @param operator_id the operator_id to set
     */
    public void setOperator_id(Long operator_id) {
        this.operator_id = operator_id;
    }

    /**
     * @return the operator_name
     */
    public String getOperator_name() {
        return operator_name;
    }

    /**
     * @param operator_name the operator_name to set
     */
    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

  
}
