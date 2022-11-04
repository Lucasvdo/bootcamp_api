package br.com.bootcamp.domain.exception;

public class UnprocessableEntityException extends RuntimeException{

    private String message;

    public UnprocessableEntityException(String msg){
        this.message = msg;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
