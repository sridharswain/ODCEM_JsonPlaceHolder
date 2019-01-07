package com.odcem.jsonplaceholderwithjwt.dto;

import com.odcem.jsonplaceholderwithjwt.model.CredentialModel;

public class CredentialDto extends CredentialModel{

    public CredentialDto(String email, String password){
        super(email, password);
    }

    public CredentialDto(){
        super();
    }
}