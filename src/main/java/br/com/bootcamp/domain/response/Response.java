package br.com.bootcamp.domain.response;

import java.time.LocalDateTime;

public class Response <T>{
    private T data;
    private Object errors;

    public Response(){};

    public UpdateProductDtoResponse setData(T data) {
        this.data = data;
        return null;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public Object getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }

    public void addErrorMessageToResponse(String msgError){
        ResponseError error = new ResponseError();
        error.setTimestamp(LocalDateTime.now());
        error.setDetails(msgError);
        setErrors(error);
    }
}
