package caotinging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import caotinging.dao.TestDao;
import caotinging.pojo.Test1;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public void saveTest(Test1 test) {
		Test1 test1 = testDao.save(test);
		System.out.println("service:"+test1);
	}
	
	public void deleteTest(Integer id) {
		testDao.delete(id);
		System.out.println("delete by id :" + id);
	}
	
	public Test1 findTest(Integer id) {
		Test1 test1 = testDao.findOne(id);
		return test1;
	}
	
	public Test1 findTestByName(String name) {
		Test1 test1 = testDao.findByName(name);
		return test1;
	}
}
