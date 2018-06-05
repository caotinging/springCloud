package caotinging.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import caotinging.pojo.Test1;

public interface TestDao extends CrudRepository<Test1, Integer> {

	/**
	 * 自定义一个查询条件
	 * @author caoting
	 */
	@Query("from Test1 where name=:name")
	Test1 findByName(@Param("name") String name);
}
