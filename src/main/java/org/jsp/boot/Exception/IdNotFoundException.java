/**
 * 
 */
package org.jsp.boot.Exception;


public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	

	public String getMessage() {
    	
    	return "Invalid Id";
    }
}
