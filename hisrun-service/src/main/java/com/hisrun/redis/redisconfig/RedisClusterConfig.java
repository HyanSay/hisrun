package com.hisrun.redis.redisconfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
@ConditionalOnClass(RedisClusterConfig.class)
@EnableConfigurationProperties(RedisClusterProperties.class)
@Repository
public class RedisClusterConfig {
	@Resource
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster redisCluster(){

        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        for (String node:redisClusterProperties.getNodes()){
            String[] parts= StringUtils.split(node,":");
            Assert.state(parts.length==2, "redis node shoule be defined as 'host:port', not '" + Arrays.toString(parts) + "'");
            nodes.add(new HostAndPort(parts[0], Integer.valueOf(parts[1])));
        }
        return new JedisCluster(nodes,redisClusterProperties.getTimeout(),redisClusterProperties.getMaxRedirections(),this.initGenericObjectPoolConfig());
    }
    private GenericObjectPoolConfig initGenericObjectPoolConfig () {
    	GenericObjectPoolConfig goPool = new GenericObjectPoolConfig ();
    	goPool.setMaxIdle(redisClusterProperties.getMaxidle());
    	goPool.setMinIdle(redisClusterProperties.getMinidle());
    	goPool.setMaxWaitMillis(redisClusterProperties.getMaxwait());
    	goPool.setMaxTotal(redisClusterProperties.getMaxactive());
    	return goPool ;
    }
}
