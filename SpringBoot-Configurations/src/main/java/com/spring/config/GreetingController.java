package com.spring.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	@Value("some static message")
	private String staticGreetingMessage;

	@Value("${app.description}")
	private String appInfo;

	/*
	 * Including a default property which would be used if we fail to mention the
	 * value in the properties file (to prevent the container from failing to start)
	 */
	@Value("${my.greeting: default value}")
	private String greetingMessage;

	// Mapping list of values
	@Value("${my.list.value}")
	private List<String> listValues;

	// Mapping list of values with default value
	@Value("${my.list.value2: some value}")
	private List<String> listValues2;

	// Using SPEL - Spring Expressing Language to evaluate the expression of the
	// value
	// Done by adding "#" next to $ symbol
	@Value("#{${sampleKeyValue}}")
	private Map<String, String> keyValues;

	// Using ConfigurationProperties
	@Autowired
	private DbSettings dbSettings;

	@Autowired
	private Environment env;

	@GetMapping("/greeting")
	public String greeting() {
		System.out.println(staticGreetingMessage);
		return greetingMessage + " " + staticGreetingMessage + " " + listValues + " " + appInfo + " " + listValues2
				+ " " + keyValues + " " + dbSettings.getConnection() + " " + dbSettings.getHost() + " "
				+ dbSettings.getPort();
	}

	@GetMapping("/app")
	public String appInfo() {
		return appInfo;
	}

	@GetMapping("/env")
	public String getEnv() {
		return env.toString();
	}
}
