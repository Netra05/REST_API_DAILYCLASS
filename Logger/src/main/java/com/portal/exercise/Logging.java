package com.portal.exercise;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logging {

	Logger logger=LoggerFactory.getLogger(Logging.class);
	
	@GetMapping("/test")
	public String hello()
	{
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Messae");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		return "Hello Scaler!";
	}
}
