/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.dao;

import java.util.List;
import org.ariose.model.Twitter1;
import org.ariose.model.TwitterUser;

/**
 *
 * @author shweta
 */
public interface TwitterDAO {

     public void saveTwitterInfo(Twitter1 twitter) throws Exception;


     public TwitterUser checkUsers(TwitterUser twitteruser) throws Exception;

public Twitter1 getTwitterInfo(int id) throws Exception;

public List getTwitterMessages() throws Exception;

}
