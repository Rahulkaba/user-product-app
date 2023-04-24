/**
 * 
 */
package org.jsp.boot.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProductAppExceptionHandler extends ResponseEntityExceptionHandler {
    
	@ExceptionHandler(IdNotFoundException.class)
    public void handleIdNotFoundException(IdNotFoundException e) {
    	
    }

}
