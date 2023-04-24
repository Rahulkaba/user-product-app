package org.jsp.boot.dto;

import java.util.Optional;

import org.springframework.stereotype.Controller;

import lombok.Data;

@Controller
@Data
public class ResponseStructure<T,T1>{
 
	 private String message;
	 private T  body;
	 private T1 bodyP;
	 private int code;

	 
}
