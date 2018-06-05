package caotinging.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author caoting
 * @date 2018年4月27日
 */
@Service
public class RibbonService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")
	public String hiTestService(String name) {
		return restTemplate.getForObject("http://SERVICE-HI/getDemo?name=" + name, String.class);
	}
	
	public String hiError(String name) {
		return "hi" + name + " sorry Error!";
	}
}
