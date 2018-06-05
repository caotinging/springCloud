package caotinging;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import caotinging.pojo.User;
import caotinging.service.UserService;

/**
 * 
 * @author caoting
 *
 */
@Controller
@SpringBootApplication
public class HelloApplication extends WebMvcConfigurerAdapter {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/hello")
	public @ResponseBody String getJson() {
		List<User> list = userService.queryUserList();
		System.out.println(list.size());
		return "hello hhg";
	}
	
	@RequestMapping(value="/hello2")
	public String helloNew() {
		return "helloNew";
	}

	/**
	 * @author caoting
	 * @return
	 */
	@RequestMapping(value="/user")
	public @ResponseBody User getUser() {
		User user = new User();
		user.setAge(17);
		user.setUsername("haha");
		user.setPassword("1234");
		user.setDateTime(new Date());
		user.setRemark("这是一个测试");
		return user;
	}
	
	 @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(stringHttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
	
	/**
	 * 解决SPringBoot乱码
	 * @return
	 */
	@Bean
	public HttpMessageConverter<String> stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}
	
	/**
	 * 通过注入转换器实体的方式更改默认的Json格式转换器
	 * @return
	 */
	@Bean
	public HttpMessageConverters fasHttpMessageConverter() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		//处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);
		
		converter.setFastJsonConfig(config);
		HttpMessageConverter<?> httpMessageConverter = converter;
		return new HttpMessageConverters(httpMessageConverter);
	}
	
	/**
	 * 用于更改springBoot解析json数据默认使用的工具。更改为fastJson
	 * @author caoting
	 * 
	 */
	///复用
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//首先执行一下springBoot默认的父类操作
		super.configureMessageConverters(converters);
		
		 * 1.定义一个fastJson转换器
		 * 2.定义JsonConfig并添加到转换器中
		 * 3.将转换器添加到队列中
		 
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonHttpMessageConverter.setFastJsonConfig(config);
		
		converters.add(fastJsonHttpMessageConverter);
	}*/
	
	public static void main(String[] args) {
		
		SpringApplication.run(HelloApplication.class, args);
	}
}
