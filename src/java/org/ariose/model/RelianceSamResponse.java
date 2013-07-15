package org.ariose.model;

/**
 * 
 * @author Manu Parmar: Dec 2011
 */
public class RelianceSamResponse extends BaseObject {
	private Long id;
	private Long subscriber_number;
	private String subscriber_type; // new,renew
	private int circle_id;
	private String circle_name;
	private int pack_id;
	private String pack_name;
	private int response_code;
	private int validity;
	private String startdate;
	private String enddate;
	private String logtime;
	/*
	 * system [if we send the request],
	 * 
	 * sam [if it came from SAM as a callback]
	 */
	private String request_from;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubscriber_number() {
		return subscriber_number;
	}

	public void setSubscriber_number(Long subscriber_number) {
		this.subscriber_number = subscriber_number;
	}

	public String getSubscriber_type() {
		return subscriber_type;
	}

	public void setSubscriber_type(String subscriber_type) {
		this.subscriber_type = subscriber_type;
	}

	public int getCircle_id() {
		return circle_id;
	}

	public void setCircle_id(int circle_id) {
		this.circle_id = circle_id;
	}

	public String getCircle_name() {
		return circle_name;
	}

	public void setCircle_name(String circle_name) {
		this.circle_name = circle_name;
	}

	public int getPack_id() {
		return pack_id;
	}

	public void setPack_id(int pack_id) {
		this.pack_id = pack_id;
	}

	public String getPack_name() {
		return pack_name;
	}

	public void setPack_name(String pack_name) {
		this.pack_name = pack_name;
	}

	public int getResponse_code() {
		return response_code;
	}

	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getRequest_from() {
		return request_from;
	}

	public void setRequest_from(String request_from) {
		this.request_from = request_from;
	}

	
}