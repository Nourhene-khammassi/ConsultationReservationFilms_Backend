package com.example.demo.Exception;


public enum ErrorCodes {

    FILM_NOT_FOUND(1000),
	FILM_ID_IS_NULL(1200);
    
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}