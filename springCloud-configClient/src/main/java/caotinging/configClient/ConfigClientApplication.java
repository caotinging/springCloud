package caotinging.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoting
 * @date 2018年4月28日
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigClientApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	private String foo;
	
	@RequestMapping("getFoo")
	public String getFoo() {
		return foo;
	}
}
