/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;



/**
 *
 * @author A.Rahman
 */
public class Content extends BaseObject {

    private Long   content_id;
    private Long content_owner_id;
    private String content_owner_name;
    private String content_name;
    private String content_description;
    private String content_creation_date;
    private String content_category;
    private String content_url;
    private String content_user_name;
    private String content_password;
    private String content_check_time;
    private String content_alert_mob;
    private String content_alert_email;
    private String content_expiry_time;
    private int packContentId;
    private Long dm_id;
    private String dm_name;
    private String language;
    private String priority;
    private boolean isDFWeeklyDaily;
    private int circlespecific;


    /**
     * @return the content_id
     */
    public Long getContent_id() {
        return content_id;
    }

    /**
     * @param content_id the content_id to set
     */
    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }

    /**
     * @return the content_owner_id
     */
    public Long getContent_owner_id() {
        return content_owner_id;
    }

    /**
     * @param content_owner_id the content_owner_id to set
     */
    public void setContent_owner_id(Long content_owner_id) {
        this.content_owner_id = content_owner_id;
    }

    /**
     * @return the content_name
     */
    public String getContent_name() {
        return content_name;
    }

    /**
     * @param content_name the content_name to set
     */
    public void setContent_name(String content_name) {
        this.content_name = content_name;
    }

    /**
     * @return the content_description
     */
    public String getContent_description() {
        return content_description;
    }

    /**
     * @param content_description the content_description to set
     */
    public void setContent_description(String content_description) {
        this.content_description = content_description;
    }

    /**
     * @return the content_creation_date
     */
    public String getContent_creation_date() {
        return content_creation_date;
    }

    /**
     * @param content_creation_date the content_creation_date to set
     */
    public void setContent_creation_date(String content_creation_date) {
        this.content_creation_date = content_creation_date;
    }

    /**
     * @return the content_category
     */
    public String getContent_category() {
        return content_category;
    }

    /**
     * @param content_category the content_category to set
     */
    public void setContent_category(String content_category) {
        this.content_category = content_category;
    }

    /**
     * @return the content_url
     */
    public String getContent_url() {
        return content_url;
    }

    /**
     * @param content_url the content_url to set
     */
    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    /**
     * @return the content_user_name
     */
    public String getContent_user_name() {
        return content_user_name;
    }

    /**
     * @param content_user_name the content_user_name to set
     */
    public void setContent_user_name(String content_user_name) {
        this.content_user_name = content_user_name;
    }

    /**
     * @return the content_password
     */
    public String getContent_password() {
        return content_password;
    }

    /**
     * @param content_password the content_password to set
     */
    public void setContent_password(String content_password) {
        this.content_password = content_password;
    }

  
    /**
     * @return the content_alert_mob
     */
    public String getContent_alert_mob() {
        return content_alert_mob;
    }

    /**
     * @param content_alert_mob the content_alert_mob to set
     */
    public void setContent_alert_mob(String content_alert_mob) {
        this.content_alert_mob = content_alert_mob;
    }

    /**
     * @return the content_alert_email
     */
    public String getContent_alert_email() {
        return content_alert_email;
    }

    /**
     * @param content_alert_email the content_alert_email to set
     */
    public void setContent_alert_email(String content_alert_email) {
        this.content_alert_email = content_alert_email;
    }

    /**
     * @return the content_expiry_time
     */
    public String getContent_expiry_time() {
        return content_expiry_time;
    }

    /**
     * @param content_expiry_time the content_expiry_time to set
     */
    public void setContent_expiry_time(String content_expiry_time) {
        this.content_expiry_time = content_expiry_time;
    }

    /**
     * @return the content_owner_name
     */
    public String getContent_owner_name() {
        return content_owner_name;
    }

    /**
     * @param content_owner_name the content_owner_name to set
     */
    public void setContent_owner_name(String content_owner_name) {
        this.content_owner_name = content_owner_name;
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

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

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
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the isDFWeeklyDaily
     */
    public boolean isIsDFWeeklyDaily() {
        return isDFWeeklyDaily;
    }

    /**
     * @param isDFWeeklyDaily the isDFWeeklyDaily to set
     */
    public void setIsDFWeeklyDaily(boolean isDFWeeklyDaily) {
        this.isDFWeeklyDaily = isDFWeeklyDaily;
    }

    /**
     * @return the packContentId
     */
    public int getPackContentId() {
        return packContentId;
    }

    /**
     * @param packContentId the packContentId to set
     */
    public void setPackContentId(int packContentId) {
        this.packContentId = packContentId;
    }

    /**
     * @return the content_check_time
     */
    public String getContent_check_time() {
        return content_check_time;
    }

    /**
     * @param content_check_time the content_check_time to set
     */
    public void setContent_check_time(String content_check_time) {
        this.content_check_time = content_check_time;
    }

    public int getCirclespecific() {
        return circlespecific;
    }

    public void setCirclespecific(int circlespecific) {
        this.circlespecific = circlespecific;
    }

  

}
