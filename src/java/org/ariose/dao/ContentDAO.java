package org.ariose.dao;


import java.util.List;
import org.ariose.model.Content;


/**
 *
 * @author A.Rahman
 */

public interface ContentDAO extends DAO {
    
    public List getContents()throws Exception;

    public List getDeliveryMechanisms()throws Exception;

    public List getLanguages()throws Exception;

    public Content getContent(Long content_id)throws Exception;

    public void saveContent(Content content)throws Exception;

    public void removeContent(Long content_id)throws Exception;
}
