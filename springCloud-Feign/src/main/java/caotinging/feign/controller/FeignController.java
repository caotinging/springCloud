package caotinging.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import caotinging.feign.service.FeignHiService;

/**
 * @author caoting
 * @date 2018年4月27日
 */
@RestController
public class FeignController {

	@Autowired
	private FeignHiService feignHiService;
	
	@RequestMapping(value="/hi")
	public String feignHi(String name) {
		return feignHiService.hiService(name); 
	}
}
