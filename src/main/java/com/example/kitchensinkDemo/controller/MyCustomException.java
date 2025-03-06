package com.example.kitchensinkDemo.controller;

public class MyCustomException extends RuntimeException{
    private int statusCode;

    public MyCustomException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
