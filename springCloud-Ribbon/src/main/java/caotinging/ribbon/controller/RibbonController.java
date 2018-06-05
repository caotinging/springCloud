package caotinging.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import caotinging.ribbon.service.RibbonService;

/**
 * @author caoting
 * @date 2018年4月27日
 */
@RestController
public class RibbonController {

	@Autowired
	private RibbonService ribbonService;
	
	@RequestMapping("sayHi")
	public String sayHi(String name) {
		String string = ribbonService.hiTestService(name);
		return string;
	}
}
