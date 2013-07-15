package org.ariose.dao;

import java.util.List;
import org.ariose.model.ConfigurationBean;
import org.ariose.model.GmlcConfiguration;

/**
 *
 * @author Sukhdeep
 */
public interface ConfigurationDAO extends DAO {

    public ConfigurationBean getConfiguration();

    public void saveConfiguration(ConfigurationBean configurationBean);

    public List  getOperator(int operatorId);

    public List  getOperators();

    public GmlcConfiguration getGmlcConfiguration(String operatorName,String shortCode);

    public List getGmlcConfiguration();

    public void saveGmlcConfiguration(GmlcConfiguration gmlcConfiguration);

    public void removeGmlcConfiguration(String operatorName, String shortCode);

    public List getshortcode(String operatorName);
        
    //manup - 05/08/10 - nazara-reliance integration - want to send content via SMPP and not http
    public GmlcConfiguration getGmlcConfiguration(String operatorName);

}
