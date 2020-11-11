package com.hungerbox.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;






@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException userNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode("USER ID");
		errorMessage.setStatusMessage(userNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value=VendorNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleVendorNotFoundException(VendorNotFoundException vendorNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode("VENDOR ID");
		errorMessage.setStatusMessage(vendorNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(value=FoodItemNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFoodItemNotFoundException(FoodItemNotFoundException foodItemNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setStatusCode("FOODITEM");
		errorMessage.setStatusMessage(foodItemNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException  argInvalidException, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorMessage response = new ErrorMessage();
		response.setStatusCode("SourceId");
		String allFieldErrors = argInvalidException.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getDefaultMessage()).collect(Collectors.joining(", "));
		response.setStatusMessage(allFieldErrors);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}


}
