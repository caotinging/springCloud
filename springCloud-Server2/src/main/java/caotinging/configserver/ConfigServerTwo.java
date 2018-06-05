package caotinging.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author caoting
 * @date 2018年4月28日
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigServerTwo {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigServerTwo.class, args);
	}

}
