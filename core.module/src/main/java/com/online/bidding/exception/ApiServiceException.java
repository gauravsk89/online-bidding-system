package com.online.bidding.exception;

import lombok.Data;

@Data
public class ApiServiceException extends RuntimeException{

    private String sourceService;
    private int responseCode;
    private String message;

    public ApiServiceException(){
        super("user not found");
    }

    public ApiServiceException(String sourceService, int responseCode, String message){
        super(message);
        this.sourceService = sourceService;
        this.responseCode = responseCode;
        this.message = message;
    }

}
