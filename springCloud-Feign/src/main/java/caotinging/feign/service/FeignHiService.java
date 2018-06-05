package caotinging.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import caotinging.feign.hystric.SchedualServiceHiHystric;

/**
 * @author caoting
 * @date 2018年4月27日
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface FeignHiService {

	@RequestMapping(value = "/getDemo")
	public String hiService(@RequestParam(name= "name") String name);
	
	@PostMapping(value="/getDemo2")
	public String hi2Service(@RequestParam(name="name") String name);
}
