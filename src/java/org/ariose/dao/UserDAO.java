package org.ariose.dao;

import org.ariose.dao.*;
import java.util.List;
import org.ariose.model.User;
/**
 *
 * @author Er. Sukhdeep Singh
 */

public interface UserDAO extends DAO {
    public User getUser(String user);
    public User getUser(String user, String password);    
    public void updateUser(User user);
    public void saveUser(User user) throws Exception;
    public List getUsers() throws Exception;
    public void removeUser(Long id) throws Exception;
    public List getType() throws Exception;
    public void logOutUser(String LoginID) throws Exception;
    public boolean changePassword(String LoginID, String oldPassword, String newPassword);
    public List getOperator();
    public List getContent();
    public List getEmailConfigDetails();
    public List getConfigDetails();    
    public boolean checkUserExistance(User user) throws Exception;
}
