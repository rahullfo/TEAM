/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.dao;

import java.util.List;
import org.ariose.model.OperatorBean;

/**
 *
 * @author Sukhdeep
 */
public interface OperatorDAO  extends DAO {

    public void saveOperator(OperatorBean operatorBean);

    public List getOperator(OperatorBean operatorBean);

    public void removeOperator(int id);
    
    public boolean checkOperatorExistance(OperatorBean operatorBean) throws Exception;

    public List<OperatorBean> getAllOperators();
   
}
