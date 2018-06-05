package caotinging.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置服务中心  
 * 
 * http请求地址和资源文件映射如下:
 * /{application}/{profile}[/{label}] 
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml 
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 * @author caoting
 * @date 2018年4月28日
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
