package com.rohit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;

import com.rohit.entity.Message;
import com.rohit.entity.NotFoundException;

@ControllerAdvice
public class ControllerAdviceClass {
	
	@ExceptionHandler
	public ResponseEntity<Message> handleNotFoundException(NotFoundException exc)
	{
		Message message = new Message();
		message.setStatus(HttpStatus.CONFLICT.value());
		message.setMessage(exc.getMessage());
		message.setDate(System.currentTimeMillis());
		
		return new ResponseEntity<Message>(message,HttpStatus.BAD_GATEWAY);	
	}
	
	@ExceptionHandler
	public ResponseEntity<Message> handleException(Exception exc)
	{
		Message message = new Message();
		message.setStatus(HttpStatus.CONFLICT.value());
		message.setMessage(exc.getMessage());
		message.setDate(System.currentTimeMillis());
		
		return new ResponseEntity<Message>(message,HttpStatus.BAD_REQUEST);	
	}
}
