package com.engineerbetter.hazelcast;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=HazelcastExampleApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class SmokeTest
{
	@Autowired
	private TestRestTemplate rest;


	@Test
	public void appRespondsOnRootPath()
	{
		ResponseEntity<String> response = rest.getForEntity("/", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
}
