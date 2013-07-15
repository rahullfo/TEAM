package org.ariose.model;

public class ReliancePackChannel extends BaseObject {
    int id;            
    int app_id;        
    int channel_id;    
    int channel_type; // 0 is for default channel   
    String source;
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
	 * @return the app_id
	 */
	public int getApp_id() {
		return app_id;
	}
	/**
	 * @param app_id the app_id to set
	 */
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	/**
	 * @return the channel_id
	 */
	public int getChannel_id() {
		return channel_id;
	}
	/**
	 * @param channel_id the channel_id to set
	 */
	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}
	/**
	 * @return the channel_type
	 */
	public int getChannel_type() {
		return channel_type;
	}
	/**
	 * @param channel_type the channel_type to set
	 */
	public void setChannel_type(int channel_type) {
		this.channel_type = channel_type;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
    
    

}
