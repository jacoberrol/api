package org.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5824088139028883550L;

}
