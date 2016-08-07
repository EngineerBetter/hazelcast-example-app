package com.engineerbetter.hazelcast;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=HazelcastExampleApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class SmokeTest
{
	@LocalServerPort
	private String port;
	@Autowired
	private TestRestTemplate rest;


	@Test
	public void appRespondsOnRootPath()
	{
		ResponseEntity<String> response = rest.getForEntity("/", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}


	@Test
	public void readWritePath() throws Exception
	{
		ResponseEntity<String> response = rest.exchange(new RequestEntity<String>("bar", HttpMethod.PUT, new URI("http://localhost:"+port+"/foo")), String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));

		response = rest.getForEntity("/foo", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
}
