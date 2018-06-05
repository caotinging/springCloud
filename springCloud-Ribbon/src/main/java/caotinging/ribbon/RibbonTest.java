package caotinging.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon+restTemplate实现负载均衡
 * @author caoting
 * @date 2018年4月27日
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class RibbonTest {

	public static void main(String[] args) {
		SpringApplication.run(RibbonTest.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
