package com.hisrun.redis;

import org.springframework.beans.factory.annotation.Autowired;

import com.hisrun.redis.redisconfig.RedisClusterConfig;

import redis.clients.jedis.JedisCluster;

public class RedisSerivce {
	
	@Autowired
	private static RedisClusterConfig redisClusterConfig;
	static JedisCluster jedisCluster = redisClusterConfig.redisCluster();
	
	public static void main(String[] args) {
		System.out.println(jedisCluster.get("a"));
	}
}
