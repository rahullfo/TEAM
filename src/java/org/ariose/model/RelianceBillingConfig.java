package org.ariose.model;

/**
 *
 * @author Manu Parmar - 09/08/10 - nazara-reliance integration
 */

public class RelianceBillingConfig extends BaseObject{
	//values from db
	int id;
	String billingkey;
	String value;
	
	
	//values parsed and stored here
	int day;
	int hour;
	int minutes;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the billingkey
	 */
	public String getBillingkey() {
		return billingkey;
	}
	/**
	 * @param billingkey the billingkey to set
	 */
	public void setBillingkey(String billingkey) {
		this.billingkey = billingkey;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}
	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}
	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
}
