package org.ariose.model;
/**
 * @author Sukhdeep
 */

public class User extends BaseObject {
    private Long user_id;
    private String region_id;
    private String user_name;
    private String description;
    private String user_password;
    private String creation_date;
    private String user_status;
    private String user_role;
    private String user_email;
    private String user_phone_number;
    private boolean user_login_status;
    private String user_last_login;
    private String login_id;
    private String type;
    private Long operatorId;
    private String operatorName;
   
    /**
     * @return the region_id
     */
    public String getRegion_id() {
        return region_id;
    }

    /**
     * @param region_id the region_id to set
     */
    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the user_password
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * @param user_password the user_password to set
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * @return the creation_date
     */
    public String getCreation_date() {
        return creation_date;
    }

    /**
     * @param creation_date the creation_date to set
     */
    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }   

    /**
     * @return the user_role
     */
    public String getUser_role() {
        return user_role;
    }

    /**
     * @param user_role the user_role to set
     */
    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    /**
     * @return the user_email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * @param user_email the user_email to set
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * @return the user_phone_number
     */
    public String getUser_phone_number() {
        return user_phone_number;
    }

    /**
     * @param user_phone_number the user_phone_number to set
     */
    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }  

    /**
     * @return the user_last_login
     */
    public String getUser_last_login() {
        return user_last_login;
    }

    /**
     * @param user_last_login the user_last_login to set
     */
    public void setUser_last_login(String user_last_login) {
        this.user_last_login = user_last_login;
    }

    /**
     * @return the login_id
     */
    public String getLogin_id() {
        return login_id;
    }

    /**
     * @param login_id the login_id to set
     */
    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the user_id
     */
    public Long getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the user_login_status
     */
    public boolean isUser_login_status() {
        return user_login_status;
    }

    /**
     * @param user_login_status the user_login_status to set
     */
    public void setUser_login_status(boolean user_login_status) {
        this.user_login_status = user_login_status;
    }

    /**
     * @return the user_status
     */
    public String getUser_status() {
        return user_status;
    }

    /**
     * @param user_status the user_status to set
     */
    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    
   
}
