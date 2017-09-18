package com.online.bidding.configuration;

import com.online.bidding.exception.ApiServiceException;
import com.online.bidding.exception.ThrowableMapper;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
@Slf4j
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		packages("com.online.bidding.rest");

		register(ApiServiceException.class);
		register(ThrowableMapper.class);
//		register(CORSFilter.class);

	}

}
