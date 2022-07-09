package edu.miu.annapurnabe.advice;

import edu.miu.annapurnabe.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@RestControllerAdvice
public class AnnapurnaExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataNotFoundException.class)
    public Map<String, String> handleWebAPIException(DataNotFoundException dataNotFoundException){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", dataNotFoundException.getMessage());
        return errorMap;
    }
}
