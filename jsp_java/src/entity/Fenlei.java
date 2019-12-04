package entity;

public class Fenlei {
	private int id;
	private String title;
	private String addtime;
	
	public Fenlei() {
		super();
	}
	public Fenlei(int id, String title, String addtime) {
		super();
		this.id = id;
		this.title = title;
		this.addtime = addtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
}
