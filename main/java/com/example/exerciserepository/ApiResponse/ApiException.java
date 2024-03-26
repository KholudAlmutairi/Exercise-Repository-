package com.example.exerciserepository.ApiResponse;

public class ApiException extends RuntimeException {

    public ApiException(String massage){
        super(massage);
    }
}
