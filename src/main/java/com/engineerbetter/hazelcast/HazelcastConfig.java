package com.engineerbetter.hazelcast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("!cloud-services")
public class HazelcastConfig
{
	@Bean
	public ClientConfig getConfig()
	{
		String addresses = System.getenv("ADDRESSES");
		if(addresses == null)
		{
			throw new RuntimeException("ADDRESSES env var required when not using cloud-services profile");
		}

		ClientNetworkConfig networkConfig = new ClientNetworkConfig();

		for(String address : addresses.split(","))
		{
			networkConfig.addAddress(address);
		}

		return new ClientConfig().setNetworkConfig(networkConfig);
	}

	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig clientConfig)
	{
		return HazelcastClient.newHazelcastClient(clientConfig);
	}
}
