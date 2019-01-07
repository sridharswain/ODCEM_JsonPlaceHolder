package com.odcem.jsonplaceholderwithjwt.exception;

public class ParamNotFoundException extends RuntimeException {
    
    public ParamNotFoundException(String message){
        super(message);
    }

    public ParamNotFoundException(){
        super("Parameters are not available.");
    }
}