package com.odcem.jsonplaceholderwithjwt.exception;

public class InvalidParamException extends RuntimeException {
    public InvalidParamException(String message){
        super(message);
    }

    public InvalidParamException(){
        super("Invalid params");
    }
}
