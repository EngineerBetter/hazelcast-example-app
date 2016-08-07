package com.engineerbetter.hazelcast.cloudfoundry;

import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastServiceConnectorCreator extends AbstractServiceConnectorCreator<HazelcastInstance, HazelcastServiceInfo>
{
	@Override
	public HazelcastInstance create(HazelcastServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig)
	{
		ClientConfig config = new ClientConfig();
		ClientNetworkConfig networkConfig = new ClientNetworkConfig();

		for(String ip : serviceInfo.ips)
		{
			networkConfig.addAddress(ip);
		}

		networkConfig.setConnectionAttemptLimit(60);
		networkConfig.setConnectionAttemptPeriod(10000);
		config.setNetworkConfig(networkConfig);

		return HazelcastClient.newHazelcastClient(config);
	}

}
