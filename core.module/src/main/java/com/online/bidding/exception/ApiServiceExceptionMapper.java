package com.online.bidding.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Component
@Provider
@Slf4j
public class ApiServiceExceptionMapper implements ExceptionMapper<ApiServiceException>{

    @Override
    public Response toResponse(ApiServiceException e) {

        log.debug("ApiServiceExceptionMapper {}", e);

        return Response
                .status(e.getResponseCode())
                .entity(e.getMessage())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
