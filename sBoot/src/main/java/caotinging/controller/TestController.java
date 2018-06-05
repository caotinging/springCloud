package caotinging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import caotinging.pojo.Test1;
import caotinging.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("save")
	public @ResponseBody String testSave() {
		Test1 test = new Test1();
		test.setId(1);
		test.setName("heiehi1");
		test.setRemark("测试");
		testService.saveTest(test);
		return "save";
	}
	
	@RequestMapping("find")
	public @ResponseBody String findTest() {
		Test1 test = testService.findTest(1);
		System.out.println("find"+test);
		return "find";
	}
	
	@RequestMapping("delete")
	public @ResponseBody String testDelete() {
		testService.deleteTest(2);
		
		return "delete success!";
	}
	
	@RequestMapping("findByName")
	public @ResponseBody Test1 findTestByName(String name) {
		Test1 test1 = testService.findTestByName(name);
		System.out.println(test1);
		return test1;
	}
}
