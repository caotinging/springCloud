package caotinging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * springCloud的入门程序
 * @author caoting
 * @date 2018年4月27日
 */
@EnableEurekaServer
@SpringBootApplication
public class MyFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstApplication.class, args);
	}
}
