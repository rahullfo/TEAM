/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 * 
 * @author manu
 */
public class GmlcConfiguration extends BaseObject {

	private int id;

	private String operatorname;
	private String shortcode;
	
	// gmlc details
	private String locationsvcurl;
	private String locationsvcuserid;
	private String locationsvcpwd;

	// sms sender details
	private String ipaddress;
	private String port;
	private String systemid;
	private String password;
	private String bindmode;
	private String addrton;
	private String addrnpi;
	private String addressrange;
	private String sourceton;
	private String sourcenpi;
	private String sourceaddress;
	private String destinationton;
	private String destinationnpi;
	private String destinationaddress;
	private String servicetype;
	private String systemtype;
	private String receivetimeout;

	
	// sms receiver details
	private String smsrhostname;
	private String smsrport;
	private String smsrsystemid;
	private String smsrpassword;
	private String smsrsystemtype;
	private String smsrsourceton;
	private String smsrsourcenpi;
	private String smsrsourceaddress;
	
	// sms receiver details
	private String smsreceiverurl;
	
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
	 * @return the operatorname
	 */
	public String getOperatorname() {
		return operatorname;
	}
	/**
	 * @param operatorname the operatorname to set
	 */
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	/**
	 * @return the locationsvcurl
	 */
	public String getLocationsvcurl() {
		return locationsvcurl;
	}
	/**
	 * @param locationsvcurl the locationsvcurl to set
	 */
	public void setLocationsvcurl(String locationsvcurl) {
		this.locationsvcurl = locationsvcurl;
	}

	/**
	 * @return the locationsvcuserid
	 */
	public String getLocationsvcuserid() {
		return locationsvcuserid;
	}
	/**
	 * @param locationsvcuserid the locationsvcuserid to set
	 */
	public void setLocationsvcuserid(String locationsvcuserid) {
		this.locationsvcuserid = locationsvcuserid;
	}
	/**
	 * @return the locationsvcpwd
	 */
	public String getLocationsvcpwd() {
		return locationsvcpwd;
	}
	/**
	 * @param locationsvcpwd the locationsvcpwd to set
	 */
	public void setLocationsvcpwd(String locationsvcpwd) {
		this.locationsvcpwd = locationsvcpwd;
	}
	/**
	 * @return the ipaddress
	 */
	public String getIpaddress() {
		return ipaddress;
	}
	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @return the systemid
	 */
	public String getSystemid() {
		return systemid;
	}
	/**
	 * @param systemid the systemid to set
	 */
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the bindmode
	 */
	public String getBindmode() {
		return bindmode;
	}
	/**
	 * @param bindmode the bindmode to set
	 */
	public void setBindmode(String bindmode) {
		this.bindmode = bindmode;
	}
	/**
	 * @return the addrton
	 */
	public String getAddrton() {
		return addrton;
	}
	/**
	 * @param addrton the addrton to set
	 */
	public void setAddrton(String addrton) {
		this.addrton = addrton;
	}
	/**
	 * @return the addrnpi
	 */
	public String getAddrnpi() {
		return addrnpi;
	}
	/**
	 * @param addrnpi the addrnpi to set
	 */
	public void setAddrnpi(String addrnpi) {
		this.addrnpi = addrnpi;
	}
	/**
	 * @return the addressrange
	 */
	public String getAddressrange() {
		return addressrange;
	}
	/**
	 * @param addressrange the addressrange to set
	 */
	public void setAddressrange(String addressrange) {
		this.addressrange = addressrange;
	}
	/**
	 * @return the sourceton
	 */
	public String getSourceton() {
		return sourceton;
	}
	/**
	 * @param sourceton the sourceton to set
	 */
	public void setSourceton(String sourceton) {
		this.sourceton = sourceton;
	}
	/**
	 * @return the sourcenpi
	 */
	public String getSourcenpi() {
		return sourcenpi;
	}
	/**
	 * @param sourcenpi the sourcenpi to set
	 */
	public void setSourcenpi(String sourcenpi) {
		this.sourcenpi = sourcenpi;
	}
	/**
	 * @return the sourceaddress
	 */
	public String getSourceaddress() {
		return sourceaddress;
	}
	/**
	 * @param sourceaddress the sourceaddress to set
	 */
	public void setSourceaddress(String sourceaddress) {
		this.sourceaddress = sourceaddress;
	}
	/**
	 * @return the destinationton
	 */
	public String getDestinationton() {
		return destinationton;
	}
	/**
	 * @param destinationton the destinationton to set
	 */
	public void setDestinationton(String destinationton) {
		this.destinationton = destinationton;
	}
	/**
	 * @return the destinationnpi
	 */
	public String getDestinationnpi() {
		return destinationnpi;
	}
	/**
	 * @param destinationnpi the destinationnpi to set
	 */
	public void setDestinationnpi(String destinationnpi) {
		this.destinationnpi = destinationnpi;
	}
	/**
	 * @return the destinationaddress
	 */
	public String getDestinationaddress() {
		return destinationaddress;
	}
	/**
	 * @param destinationaddress the destinationaddress to set
	 */
	public void setDestinationaddress(String destinationaddress) {
		this.destinationaddress = destinationaddress;
	}
	/**
	 * @return the systemtype
	 */
	public String getSystemtype() {
		return systemtype;
	}
	/**
	 * @param systemtype the systemtype to set
	 */
	public void setSystemtype(String systemtype) {
		this.systemtype = systemtype;
	}
	/**
	 * @return the receivetimeout
	 */
	public String getReceivetimeout() {
		return receivetimeout;
	}
	/**
	 * @param receivetimeout the receivetimeout to set
	 */
	public void setReceivetimeout(String receivetimeout) {
		this.receivetimeout = receivetimeout;
	}
	/**
	 * @return the servicetype
	 */
	public String getServicetype() {
		return servicetype;
	}
	/**
	 * @param servicetype the servicetype to set
	 */
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
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
	 * @return the smsrhostname
	 */
	public String getSmsrhostname() {
		return smsrhostname;
	}
	/**
	 * @param smsrhostname the smsrhostname to set
	 */
	public void setSmsrhostname(String smsrhostname) {
		this.smsrhostname = smsrhostname;
	}
	/**
	 * @return the smsrport
	 */
	public String getSmsrport() {
		return smsrport;
	}
	/**
	 * @param smsrport the smsrport to set
	 */
	public void setSmsrport(String smsrport) {
		this.smsrport = smsrport;
	}
	/**
	 * @return the smsrsystemid
	 */
	public String getSmsrsystemid() {
		return smsrsystemid;
	}
	/**
	 * @param smsrsystemid the smsrsystemid to set
	 */
	public void setSmsrsystemid(String smsrsystemid) {
		this.smsrsystemid = smsrsystemid;
	}
	/**
	 * @return the smsrpassword
	 */
	public String getSmsrpassword() {
		return smsrpassword;
	}
	/**
	 * @param smsrpassword the smsrpassword to set
	 */
	public void setSmsrpassword(String smsrpassword) {
		this.smsrpassword = smsrpassword;
	}
	/**
	 * @return the smsrsystemtype
	 */
	public String getSmsrsystemtype() {
		return smsrsystemtype;
	}
	/**
	 * @param smsrsystemtype the smsrsystemtype to set
	 */
	public void setSmsrsystemtype(String smsrsystemtype) {
		this.smsrsystemtype = smsrsystemtype;
	}
	/**
	 * @return the smsrsourceton
	 */
	public String getSmsrsourceton() {
		return smsrsourceton;
	}
	/**
	 * @param smsrsourceton the smsrsourceton to set
	 */
	public void setSmsrsourceton(String smsrsourceton) {
		this.smsrsourceton = smsrsourceton;
	}
	/**
	 * @return the smsrsourcenpi
	 */
	public String getSmsrsourcenpi() {
		return smsrsourcenpi;
	}
	/**
	 * @param smsrsourcenpi the smsrsourcenpi to set
	 */
	public void setSmsrsourcenpi(String smsrsourcenpi) {
		this.smsrsourcenpi = smsrsourcenpi;
	}
	/**
	 * @return the smsrsourceaddress
	 */
	public String getSmsrsourceaddress() {
		return smsrsourceaddress;
	}
	/**
	 * @param smsrsourceaddress the smsrsourceaddress to set
	 */
	public void setSmsrsourceaddress(String smsrsourceaddress) {
		this.smsrsourceaddress = smsrsourceaddress;
	}
	/**
	 * @return the smsreceiverurl
	 */
	public String getSmsreceiverurl() {
		return smsreceiverurl;
	}
	/**
	 * @param smsreceiverurl the smsreceiverurl to set
	 */
	public void setSmsreceiverurl(String smsreceiverurl) {
		this.smsreceiverurl = smsreceiverurl;
	}
	

	
}
