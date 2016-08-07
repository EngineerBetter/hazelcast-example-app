package com.engineerbetter.hazelcast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("!cloud")
public class HazelcastConfig
{
	@Bean
	public ClientConfig getConfig()
	{
		return new ClientConfig().setNetworkConfig(new ClientNetworkConfig().addAddress("10.244.1.5"));
	}

	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig clientConfig)
	{
		return HazelcastClient.newHazelcastClient(clientConfig);
	}
}
