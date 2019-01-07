package com.odcem.jsonplaceholderwithjwt.exception;

import com.odcem.jsonplaceholderwithjwt.dto.CredentialDto;

public class InvalidCredentialException extends RuntimeException {

    public InvalidCredentialException(String message){
        super(message);
    }

    public InvalidCredentialException(){
        super("Invalid Credentials");
    }
}
