package entity;

public class User {
	private int uid;
	private String uname;
	private String fav;
	private Address addr;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFav() {
		return fav;
	}
	public void setFav(String fav) {
		this.fav = fav;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public User() {
		super();
	}
	public User(int uid, String uname, String fav, Address addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.fav = fav;
		this.addr = addr;
	}
}
