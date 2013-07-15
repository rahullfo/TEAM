/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.ConfigurationDAO;
import org.ariose.model.ConfigurationBean;
import org.ariose.model.GmlcConfiguration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Sukhdeep
 */
public class ConfigurationDAOHibernate extends HibernateDaoSupport implements ConfigurationDAO {

    private static Log log = LogFactory.getLog(ConfigurationDAOHibernate.class);

    public ConfigurationBean getConfiguration() {
//        List configurationList=null;
//        log.info("from ConfigurationBean");
//        configurationList = getHibernateTemplate().find("from ConfigurationBean");
//        log.info("configurationList ----> "+configurationList);
        return (ConfigurationBean) getHibernateTemplate().get(ConfigurationBean.class, 1);
//        return configurationList;

    }

    public void saveConfiguration(ConfigurationBean configurationBean) {
        log.info("ConfigurationDAOHibernate  ... saveConfiguration");
//        configurationBean.setCurrency("USD");
        getHibernateTemplate().update(configurationBean);
        log.info("configurationBean IS SAVED");

    }

    public List getOperator(int operatorId) {
        return getHibernateTemplate().find("from OperatorBean where operator_id =" + operatorId);
    }

    public List getOperators() {
        return getHibernateTemplate().find("from OperatorBean");
    }

    public GmlcConfiguration getGmlcConfiguration(String operatorName, String shortCode) {
        GmlcConfiguration config = null;
        List data = getHibernateTemplate().find("from GmlcConfiguration where operatorname='" + operatorName + "' and shortcode = '" + shortCode + "'");
        log.info("data size.." + data.size());
        if (data.size() > 0) {
            config = (GmlcConfiguration) data.get(0);
        }

        return config;
    }

    //manup - 05/08/10 - nazara-reliance integration - want to send content via SMPP and not http
    public GmlcConfiguration getGmlcConfiguration(String operatorName) {
        GmlcConfiguration config = null;
        List data = getHibernateTemplate().find("from GmlcConfiguration where operatorname='" + operatorName + "'");
        log.info("data size.." + data.size());
        if (data.size() > 0) {
            config = (GmlcConfiguration) data.get(0);
        }

        return config;
    }

    public List getGmlcConfiguration() {       
        return getHibernateTemplate().find("from GmlcConfiguration order by operatorname, shortcode");
    }

    public List getshortcode(String operatorName) {
        List list = null;
        list = getHibernateTemplate().find("select distinct gc.shortcode from GmlcConfiguration gc where operatorname='"+operatorName+"' order by gc.shortcode");
        log.info("list.size() : "+list.size());
        return list;
    }

    public void saveGmlcConfiguration(GmlcConfiguration gmlcConfiguration) {
           getHibernateTemplate().merge(gmlcConfiguration);

          if (log.isDebugEnabled()) {
            log.debug("id set to: " + gmlcConfiguration.getId());
          }
    }

    public void removeGmlcConfiguration(String operatorName, String shortCode) {
         getHibernateTemplate().delete("from GmlcConfiguration gc where gc.operatorname='" + operatorName + "' and gc.shortcode='" + shortCode+"'");
    		//log.info("delete result:"+ i);
//         Object gmlcConfiguration = getHibernateTemplate().load(GmlcConfiguration.class, id);
//         getHibernateTemplate().delete(gmlcConfiguration);
    }
}
