package com.engineerbetter.hazelcast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.InterfacesConfig;
import com.hazelcast.config.NetworkConfig;

@Configuration
public class HazelcastConfig
{
	@Bean
	public Config getConfig()
	{
		return new Config().setNetworkConfig(
				new NetworkConfig().setInterfaces(
						new InterfacesConfig().addInterface("10.244.1.2")
						)
				);
	}
}
