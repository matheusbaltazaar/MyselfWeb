package br.com.myself.web.service;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Service {
	
	private static JerseyWebTarget client;
	
	private static final String BASE_URL = "http://localhost:8080/myself";
	
	protected final ObjectMapper mapper = new ObjectMapper();
	
	
	private final JerseyWebTarget getClientTarget() {
		if (client == null) {
			client = JerseyClientBuilder.createClient().target(BASE_URL);
		}
		return client;
	}
	

	protected final JerseyWebTarget getClientTarget(String...path) {
		JerseyWebTarget client = getClientTarget();
		for (String p : path) {
			client = client.path(p);
		}
		return client;
	}
	

}
