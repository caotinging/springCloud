package caotinging.feign.hystric;

import org.springframework.stereotype.Component;

import caotinging.feign.service.FeignHiService;

/**
 * @author caoting
 * @date 2018年4月27日
 */
@Component
public class SchedualServiceHiHystric implements FeignHiService {

	@Override
	public String hiService(String name) {
		return "sorry hiService Error!" + name;
	}

	@Override
	public String hi2Service(String name) {
		return "sorry hi2Service Error!" + name;
	}

	
}
