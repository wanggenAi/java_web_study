package listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import util.Contains;

public class User2 implements HttpSessionBindingListener {
	private int id;
	private String userName;
	private String password;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User2(int id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public User2() {
		super();
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		Contains.USER_COUNT++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// session 失效    session 超时  手动在session中把属性移出
		Contains.USER_COUNT--;
	}

}
