/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;
import org.ariose.model.CircleBean;
import org.ariose.model.OperatorCircleRelationshipBean;

/**
 *
 * @author Sukhdeep
 */
public interface CircleDAO extends DAO {

    public void saveCircle(CircleBean circleBean);

    public List getCircle();

    public void removeCircle(int id);

    public List getOperator();

    public void saveCircleOperatorRelation(OperatorCircleRelationshipBean oCRSB);

    public List getCircleOperatorRelation(int operatorId);

    public void removeAssignCircle(OperatorCircleRelationshipBean operatorCircleRelationshipBean);

    public List<OperatorCircleRelationshipBean> getCircleOperatorRelationByOperatorIdAndCircleId(int operatorId, int circleId);
}
