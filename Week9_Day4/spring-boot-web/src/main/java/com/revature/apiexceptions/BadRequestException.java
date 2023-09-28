package com.revature.apiexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * RuntimeException child class which should be thrown to return a '400'
 * status code from API
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	public BadRequestException(String message) {
		super(message);
	}
}
