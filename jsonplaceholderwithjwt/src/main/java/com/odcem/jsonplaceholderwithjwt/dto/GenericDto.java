package com.odcem.jsonplaceholderwithjwt.dto;

public class GenericDto<T> {

    private boolean error;

    private T object;

    public GenericDto(boolean error, T object){
        this.error = error;
        this.object = object;
    }

    public GenericDto(){ }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
