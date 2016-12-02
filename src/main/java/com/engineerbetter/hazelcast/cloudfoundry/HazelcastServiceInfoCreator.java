package com.engineerbetter.hazelcast.cloudfoundry;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

public class HazelcastServiceInfoCreator extends CloudFoundryServiceInfoCreator<HazelcastServiceInfo>
{
	public HazelcastServiceInfoCreator()
	{
		super(new Tags("hazelcast"));
	}


	@Override
	public HazelcastServiceInfo createServiceInfo(Map<String, Object> serviceData)
	{
		String id = getId(serviceData);
		Map<String, Object> credentials = getCredentials(serviceData);
		List<String> ips = (List<String>) credentials.getOrDefault("members", new LinkedList<String>());
		String groupName = (String) credentials.getOrDefault("group_name", "");
		String groupPassword = (String) credentials.getOrDefault("group_pass", "");
		return new HazelcastServiceInfo(id, groupName, groupPassword, ips.toArray(new String[]{}));
	}

}
