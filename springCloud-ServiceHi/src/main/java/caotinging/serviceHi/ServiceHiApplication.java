package caotinging.serviceHi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author caoting
 * @date 2018年5月2日
 */
@SpringBootApplication
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/hi")
	public String sayHi() {
		System.out.println("calling trace service-hi ");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}
	
	@RequestMapping(value = "/info")
	public String info() {
		System.out.println("calling trace service-info ");
		return "i'm service-info ";
	}
	
}
