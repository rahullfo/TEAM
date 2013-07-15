/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;



/**
 *
 * @author manu
 */
public class PullService  extends BaseObject{
	private int id;
    private String esme_name;
    private int short_code;
    private int operator_id;
    private String operator_name;
    private String application_url;
    private String request_link;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the esme_name
	 */
	public String getEsme_name() {
		return esme_name;
	}
	/**
	 * @param esme_name the esme_name to set
	 */
	public void setEsme_name(String esme_name) {
		this.esme_name = esme_name;
	}
	/**
	 * @return the short_code
	 */
	public int getShort_code() {
		return short_code;
	}
	/**
	 * @param short_code the short_code to set
	 */
	public void setShort_code(int short_code) {
		this.short_code = short_code;
	}
	/**
	 * @return the operator_id
	 */
	public int getOperator_id() {
		return operator_id;
	}
	/**
	 * @param operator_id the operator_id to set
	 */
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	/**
	 * @return the operator_name
	 */
	public String getOperator_name() {
		return operator_name;
	}
	/**
	 * @param operator_name the operator_name to set
	 */
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
	/**
	 * @return the application_url
	 */
	public String getApplication_url() {
		return application_url;
	}
	/**
	 * @param application_url the application_url to set
	 */
	public void setApplication_url(String application_url) {
		this.application_url = application_url;
	}
	/**
	 * @return the request_link
	 */
	public String getRequest_link() {
		return request_link;
	}
	/**
	 * @param request_link the request_link to set
	 */
	public void setRequest_link(String request_link) {
		this.request_link = request_link;
	}
	
	
}
