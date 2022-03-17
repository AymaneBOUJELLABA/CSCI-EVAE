package fr.ubo.dosi.CSCIEVAE.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UeExceptionController {

	 @ExceptionHandler(value = UeNotFoundException.class)
	    public ResponseEntity<Object> exception(UeNotFoundException exception) {
	        return new ResponseEntity<>(
	                "Ue not found ! "+ exception.getMessage(),
	                HttpStatus.NOT_FOUND
	        );
	    }
}
