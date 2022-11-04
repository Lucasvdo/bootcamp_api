package br.com.bootcamp.domain.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseError {

    private LocalDateTime timestamp;
    private String details;
    private HttpStatus code;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ResponseError() {
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
