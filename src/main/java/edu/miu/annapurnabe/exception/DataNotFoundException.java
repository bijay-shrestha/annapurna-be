package edu.miu.annapurnabe.exception;

import org.springframework.http.HttpStatus;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
public class DataNotFoundException extends Exception{
    private ErrorResponse errorResponse;

    public DataNotFoundException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse();

        errorResponse.setDeveloperMsg(developerMessage);
        errorResponse.setErrorMsg(message);
        errorResponse.setResponseCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setResponseStatus(HttpStatus.NOT_FOUND);
    }
}
