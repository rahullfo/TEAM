package org.ariose.model;

public class GmlcResponse extends BaseObject {
	String msid;
	String time;
	String utcOff;
	String xCoord;
	String yCoord;
	String radius;
	String respStatus;
	String siteName;
	String city;
	String cellId;
	String siteId;
	public String getMsid() {
		return msid;
	}
	public void setMsid(String msid) {
		this.msid = msid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getXCoord() {
		return xCoord;
	}
	public void setXCoord(String coord) {
		xCoord = coord;
	}
	public String getYCoord() {
		return yCoord;
	}
	public void setYCoord(String coord) {
		yCoord = coord;
	}
	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getUtcOff() {
		return utcOff;
	}
	public void setUtcOff(String utcOff) {
		this.utcOff = utcOff;
	}
	public String getRespStatus() {
		return respStatus;
	}
	public void setRespStatus(String respStatus) {
		this.respStatus = respStatus;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	

}
