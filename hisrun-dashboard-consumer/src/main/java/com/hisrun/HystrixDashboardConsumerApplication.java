package com.hisrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @EnableCircuitBreaker注解开启断路器功能（服务消费者）
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
public class HystrixDashboardConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardConsumerApplication.class, args);
	}
}
