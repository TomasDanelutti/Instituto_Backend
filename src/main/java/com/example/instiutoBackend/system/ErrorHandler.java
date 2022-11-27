package com.example.instiutoBackend.system;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorHandler {
	
	public static String handle(List<FieldError> errors) {
		
		List<String> message = new ArrayList<>();
		
        for (FieldError e : errors){
            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
        }
		
		return message.toString();
	}
}
