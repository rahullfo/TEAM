package org.ariose.model;

/**
 *
 * @author Manu Parmar Jan 2011
 */
public class SourceChannelBean extends BaseObject {

    private int id;
    private String source;
    
    
	public SourceChannelBean() {
		super();
	}
	public SourceChannelBean(String source) {
		super();
		this.source = source;
	}
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
