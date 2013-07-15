/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class Region {

     private Long   region_id;
     private Long   operator_id;
     private String region_name;

    /**
     * @return the region_id
     */
    public Long getRegion_id() {
        return region_id;
    }

    /**
     * @param region_id the region_id to set
     */
    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

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
     * @return the region_name
     */
    public String getRegion_name() {
        return region_name;
    }

    /**
     * @param region_name the region_name to set
     */
    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    } 

   
}
