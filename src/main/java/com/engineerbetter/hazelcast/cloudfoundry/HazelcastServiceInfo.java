package com.engineerbetter.hazelcast.cloudfoundry;

import org.springframework.cloud.service.BaseServiceInfo;

public class HazelcastServiceInfo extends BaseServiceInfo
{
	public final String[] ips;

	public HazelcastServiceInfo(String id, String... ips)
	{
		super(id);
		this.ips = ips;
	}


	@ServiceProperty(category = "connection")
	public String[] getIps()
	{
		return this.ips;
	}
}
