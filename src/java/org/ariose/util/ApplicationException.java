package org.ariose.util;
/**
 *
 * @author Manu Parmar
 *
 */


public class ApplicationException extends Exception 
{

	int id;
	String message;

	
	public ApplicationException() {
		super();
	}

	public ApplicationException(int id) {
		super();
		this.id = id;
	}

	public ApplicationException(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public ApplicationException(String message){
		super(message);
		this.message = message;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
		
}
