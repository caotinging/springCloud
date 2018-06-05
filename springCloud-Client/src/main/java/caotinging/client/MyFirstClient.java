package caotinging.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoting
 * @date 2018年4月27日
 */
@EnableEurekaClient
@SpringBootApplication
@RestController // 这个注解是ResponseBody和Cntroller的聚合
public class MyFirstClient {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstClient.class, args);
	}
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/getDemo")
	public String getDemo(String name) {
		return "success " + port + " name = " + name;
	}
	
	@RequestMapping("/getDemo2")
	public String getDemo2(String name) {
		return "success222 " + port + " name2 = " + name;
	}
}
