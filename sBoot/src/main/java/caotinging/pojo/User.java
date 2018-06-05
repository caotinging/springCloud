package caotinging.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private String username;

	private String password;

	private Integer age;
	
	//格式化日期
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date dateTime;

	//表示不需要序列化这个属性。即转json数据的时候这个属性会隐藏
	private String remark;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
