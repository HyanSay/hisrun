package com.hisrun.redis.redisconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisClusterProperties {
	//集群节点
    private List<String> nodes=new ArrayList<String>();

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
    // 连接池最大连接数（使用负值表示没有限制）
    @Value("${spring.redis.pool.max-active}")
    private int maxactive;
    // 连接池最大阻塞等待时间（使用负值表示没有限制）
    @Value("${spring.redis.pool.max-wait}")
    private int maxwait;
    // 连接池中的最大空闲连接
    @Value("${spring.redis.pool.max-idle}")
    private int maxidle;
    // 连接池中的最小空闲连接
    @Value("${spring.redis.pool.min-idle}")
    private int minidle;
    @Value("${spring.redis.pool.timeout}")
    private int timeout;
    @Value("${spring.redis.pool.maxRedirections}")
    private int maxRedirections;

	public int getMaxactive() {
		return maxactive;
	}

	public void setMaxactive(int maxactive) {
		this.maxactive = maxactive;
	}

	public int getMaxwait() {
		return maxwait;
	}

	public void setMaxwait(int maxwait) {
		this.maxwait = maxwait;
	}

	public int getMaxidle() {
		return maxidle;
	}

	public void setMaxidle(int maxidle) {
		this.maxidle = maxidle;
	}

	public int getMinidle() {
		return minidle;
	}

	public void setMinidle(int minidle) {
		this.minidle = minidle;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMaxRedirections() {
		return maxRedirections;
	}

	public void setMaxRedirections(int maxRedirections) {
		this.maxRedirections = maxRedirections;
	}
}
