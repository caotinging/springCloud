package caotinging.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

import caotinging.dao.UserDao;

@Configuration  //该注解用于指明当前类为配置类（相当于xml等配置文件）
@ComponentScan(basePackages = {"caotinging"})	// 配置扫描的基础包
@PropertySource(value = { "classpath:jdbc.properties" })
public class SpringConfig {
	
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
	
	@Value("${jdbc.jdbcUrl}")
	private String jdbcUrl;
	
	@Value("${jdbc.driverClass}")
	private String driverClass;
	
	@Value("${jdbc.user}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(jdbcUrl);
		// 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
		dataSource.setIdleConnectionTestPeriodInMinutes(60);
		// 每个分区最大的连接数
		dataSource.setMaxConnectionsPerPartition(100);
		// 每个分区的最小连接数
		dataSource.setMinConnectionsPerPartition(5);
		return dataSource;
	}
}
