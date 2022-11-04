package br.com.bootcamp.domain.exception;

import br.com.bootcamp.domain.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundExceptionHandler(EntityNotFoundException ex, WebRequest request){
        ResponseError responseError = new ResponseError();
        responseError.setDetails(ex.getMessage());
        responseError.setTimestamp(LocalDateTime.now());
        responseError.setCode(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);
    };

    @ExceptionHandler({UnprocessableEntityException.class})
    public ResponseEntity<Object> unprocessableEntityExceptionHandler(UnprocessableEntityException ex, WebRequest request){
        ResponseError responseError = new ResponseError();
        responseError.setDetails(ex.getMessage());
        responseError.setTimestamp(LocalDateTime.now());
        responseError.setCode(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(responseError,HttpStatus.UNPROCESSABLE_ENTITY);
    };

}
