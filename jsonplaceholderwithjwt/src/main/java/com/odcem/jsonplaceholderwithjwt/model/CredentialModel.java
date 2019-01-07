package com.odcem.jsonplaceholderwithjwt.model;

public abstract class CredentialModel{
    private String email;
    private String password;

    public CredentialModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    public CredentialModel() { }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}