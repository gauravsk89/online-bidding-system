package com.online.bidding.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "googleapi.algo")
@Component

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyFileData {

	private String modulus1;
	private String exponent1;
	
	private String modulus2;
	private String exponent2;
	
	private String modulus3;
	private String exponent3;

	private String modulus4;
	private String exponent4;

	
}
