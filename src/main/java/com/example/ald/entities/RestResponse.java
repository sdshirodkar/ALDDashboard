package com.example.ald.entities;

public class RestResponse<T> {

    private T value;


    public RestResponse(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "value=" + value +
                '}';
    }
}
