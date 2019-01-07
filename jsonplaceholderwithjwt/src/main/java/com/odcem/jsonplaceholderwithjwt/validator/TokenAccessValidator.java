package com.odcem.jsonplaceholderwithjwt.validator;

import com.odcem.jsonplaceholderwithjwt.dto.CredentialDto;
import com.odcem.jsonplaceholderwithjwt.exception.InvalidCredentialException;

public class TokenAccessValidator extends BasicValidator {

    private CredentialDto credentialDto;

    public TokenAccessValidator(CredentialDto credentialDto){
        this.credentialDto = credentialDto;
    }

    @Override
    public void validate(){
        if(credentialDto == null || credentialDto.getEmail() == null || credentialDto.getPassword() == null){
            setInvalid("Username or password is missing.");
        }
        else if(!isValidEmail(credentialDto.getEmail())) setInvalid("Invalid Email");
        else setValid();

        if(!isValid()) throw new InvalidCredentialException(getMessage());
    }
}
