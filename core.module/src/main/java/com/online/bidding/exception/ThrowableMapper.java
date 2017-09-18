package com.online.bidding.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Slf4j
public class ThrowableMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable throwable) {

        log.debug("throwable received {}", throwable);

        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();

        if(ApiServiceException.class.equals(throwable.getClass())){

            ApiServiceException apiServiceException = (ApiServiceException) throwable;

            status = apiServiceException.getResponseCode();
        }

        return Response
                .status(status)
                .entity(throwable.getMessage())
                .build();
    }
}
