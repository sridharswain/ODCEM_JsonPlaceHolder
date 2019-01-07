package com.odcem.jsonplaceholderwithjwt.validator;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.odcem.jsonplaceholderwithjwt.constant.Regex;

public abstract class BasicValidator {


    private boolean valid;

    private String message;


    private static final Pattern NAME_PATTERN = Pattern.compile(Regex.NAME_REGEX);

    private static final Pattern EMAIL_PATTERN = Pattern.compile(Regex.EMAIL_REGEX);

    private static final Pattern PHONE_PATTERN = Pattern.compile(Regex.PHONE_REGEX);

    protected static boolean isValidName(String name){
        if(name == null) return false;
        Matcher nameMatcher = NAME_PATTERN.matcher(name);
        return nameMatcher.matches();
    }

    protected static boolean isValidEmail(String email){
        if(email == null) return false;
        Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
        return emailMatcher.matches();
    }

    protected static boolean isValidPhone(String phone){
        if(phone == null) return false;
        Matcher phoneMatcher = PHONE_PATTERN.matcher(phone);
        return phoneMatcher.matches();
    }

    protected void setValid(){
        this.valid = true;
        this.message = "Vaild";
    }

    protected void setInvalid(@NotNull String message){
        this.valid = false;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public boolean isValid(){
        return this.valid;
    }

    public abstract void validate();
}
