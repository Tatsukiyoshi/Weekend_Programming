import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class UserInfo {
	private int id;
	private String name;
	private int age;
	private String mail;
	
	public UserInfo(int id, String name, int age, String mail) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setMail(mail);
	}
	public UserInfo(UserInfo orig) {
		try {
			BeanUtils.copyProperties(this, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	public UserInfo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
