package com.engineerbetter.hazelcast;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceConnectorConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("cloud-services")
public class HazelcastCloudFoundryConfig
{
	@Bean
	public CloudFactory cloudFactory()
	{
		return new CloudFactory();
	}


	@Bean
	public Cloud cloud(CloudFactory cloudFactory)
	{
		return cloudFactory.getCloud();
	}


	@Bean
	public HazelcastInstance hazelcastInstance(Cloud cloud)
	{
		return cloud.getSingletonServiceConnector(HazelcastInstance.class, new ServiceConnectorConfig(){});
	}
}
