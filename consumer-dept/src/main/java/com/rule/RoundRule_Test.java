package com.rule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RoundRule_Test extends AbstractLoadBalancerRule {
	
		//统计访问的次数
	    private AtomicInteger total = new AtomicInteger(0);
	    //当前sever索引
	    private AtomicInteger currentIndex = new AtomicInteger(0);
	    public Server choose(ILoadBalancer lb, Object key) {
	        if (lb == null) {
	            return null;
	        }
	        Server server = null;

	        while (server == null) {
	            if (Thread.interrupted()) {
	                return null;
	            }
	            List<Server> upList = lb.getReachableServers();
	            List<Server> allList = lb.getAllServers();

	            int serverCount = allList.size();
	            if (serverCount == 0) {
	                /*
	                 * No servers. End regardless of pass, because subsequent passes
	                 * only get more restrictive.
	                 */
	                return null;
	            }
	            if(total.get() < 5){
	                server = upList.get(currentIndex.get());
	                total.addAndGet(1);
	            }else{
	                total.set(0);
	                int nowIndex = currentIndex.addAndGet(1);
	                if(nowIndex >= upList.size()){
	                    currentIndex.set(0);
	                }
	            }

	            if (server == null) {
	                /*
	                 * The only time this should happen is if the server list were
	                 * somehow trimmed. This is a transient condition. Retry after
	                 * yielding.
	                 */
	                Thread.yield();
	                continue;
	            }

	            if (server.isAlive()) {
	                return (server);
	            }

	            // Shouldn't actually happen.. but must be transient or a bug.
	            server = null;
	            Thread.yield();
	        }

	        return server;

	    }

	    @Override
	    public Server choose(Object key) {
	        return choose(getLoadBalancer(), key);
	    }

	    @Override
	    public void initWithNiwsConfig(IClientConfig clientConfig) {
	        // TODO Auto-generated method stub

	    }

}
