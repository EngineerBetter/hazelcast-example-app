package com.engineerbetter.hazelcast.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.HazelcastInstance;

@RestController
public class KeyValueController
{
	private final HazelcastInstance hazelcast;


	public KeyValueController(HazelcastInstance hazelcast)
	{
		this.hazelcast = hazelcast;
	}


	@RequestMapping(value="/{key}", method=RequestMethod.PUT, consumes=MediaType.ALL_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void put(@PathVariable("key") String key, @RequestBody String value)
	{
		hazelcast.getMap("values").put(key, value);
	}


	@RequestMapping("/{key}")
	public String get(@PathVariable("key") String key)
	{
		return (String) hazelcast.getMap("values").get(key);
	}
}
