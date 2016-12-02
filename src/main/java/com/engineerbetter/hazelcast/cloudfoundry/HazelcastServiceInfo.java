package com.engineerbetter.hazelcast.cloudfoundry;

import org.springframework.cloud.service.BaseServiceInfo;

public class HazelcastServiceInfo extends BaseServiceInfo
{
	public final String groupName;
	public final String groupPassword;
	public final String[] ips;

	public HazelcastServiceInfo(String id, String groupName, String groupPassword, String... ips)
	{
		super(id);
		this.groupName = groupName;
		this.groupPassword = groupPassword;
		this.ips = ips;
	}


	@ServiceProperty(category = "connection")
	public String[] getIps()
	{
		return this.ips;
	}
}
