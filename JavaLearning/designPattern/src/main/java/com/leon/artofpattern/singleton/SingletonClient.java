package com.leon.artofpattern.singleton;

public class SingletonClient
{
	public static void main(String[] args)
	{
		LoadBalancer balancer1, balancer2, balancer3, balancer4;
		balancer1 = LoadBalancer.getLoadBalancer();
		balancer2 = LoadBalancer.getLoadBalancer();
		balancer3 = LoadBalancer.getLoadBalancer();
		balancer4 = LoadBalancer.getLoadBalancer();
		if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4)
		{
			System.out.println("服务器负载均衡器具有唯一性");
		}
		balancer1.addServer("Server 1");
		balancer1.addServer("Server 2");
		balancer1.addServer("Server 3");
		balancer1.addServer("Server 4");

		for (int i = 0; i < 10; i++)
		{
			System.out.printf("分发至服务器：%s%n", balancer1.getServer());
		}
	}
}
