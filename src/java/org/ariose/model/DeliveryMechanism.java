/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class DeliveryMechanism extends BaseObject {

    private Long   dm_id;
    private String dm_name;

    /**
     * @return the dm_id
     */
    public Long getDm_id() {
        return dm_id;
    }

    /**
     * @param dm_id the dm_id to set
     */
    public void setDm_id(Long dm_id) {
        this.dm_id = dm_id;
    }

    /**
     * @return the dm_name
     */
    public String getDm_name() {
        return dm_name;
    }

    /**
     * @param dm_name the dm_name to set
     */
    public void setDm_name(String dm_name) {
        this.dm_name = dm_name;
    }
 


}
