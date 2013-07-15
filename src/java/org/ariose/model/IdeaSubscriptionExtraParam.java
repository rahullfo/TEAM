/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Manu Parmar Jan 2011 2Ergo Idea Integration
 */
public class IdeaSubscriptionExtraParam  extends BaseObject{
	private Long subscription_id;
	private String shortcode;             
	private String ussdstring;
	/**
	 * @return the subscription_id
	 */
	public Long getSubscription_id() {
		return subscription_id;
	}
	/**
	 * @param subscription_id the subscription_id to set
	 */
	public void setSubscription_id(Long subscription_id) {
		this.subscription_id = subscription_id;
	}
	/**
	 * @return the shortcode
	 */
	public String getShortcode() {
		return shortcode;
	}
	/**
	 * @param shortcode the shortcode to set
	 */
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}
	/**
	 * @return the ussdstring
	 */
	public String getUssdstring() {
		return ussdstring;
	}
	/**
	 * @param ussdstring the ussdstring to set
	 */
	public void setUssdstring(String ussdstring) {
		this.ussdstring = ussdstring + "#";
	}               

}
