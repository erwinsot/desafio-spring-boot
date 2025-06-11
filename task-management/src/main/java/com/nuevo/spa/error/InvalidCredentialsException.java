package com.nuevo.spa.error;

public class InvalidCredentialsException extends RuntimeException{
    public  InvalidCredentialsException(String message){
        super(message);
    }
}
