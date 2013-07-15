package org.ariose.dao;


import java.util.List;
import org.ariose.model.DeliveryMechanism;

/**
 *
 * @author A.Rahman
 */

public interface DeliveryMechanismDAO extends DAO {
    
    public List getDeliveryMechanisms()throws Exception;

    public DeliveryMechanism getDeliveryMechanism(Long dm_id)throws Exception;

    public void saveDeliveryMechanism(DeliveryMechanism deliveryMechanism)throws Exception;

    public void removeDeliveryMechanism(Long dm_id)throws Exception;
}
