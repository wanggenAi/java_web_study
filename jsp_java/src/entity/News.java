package entity;

public class News {
	private int id;
	private String title;
	private String fenlei;
	private String content;
	private String addtime;
	private String adder;
	public String getAdder() {
		return adder;
	}
	public void setAdder(String adder) {
		this.adder = adder;
	}
	private int visit;
	private String gjz;
	
	public News(int id, String title, String fenlei, String content, String addtime, String adder, int visit,
			String gjz) {
		super();
		this.id = id;
		this.title = title;
		this.fenlei = fenlei;
		this.content = content;
		this.addtime = addtime;
		this.adder = adder;
		this.visit = visit;
		this.gjz = gjz;
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
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public String getGjz() {
		return gjz;
	}
	public void setGjz(String gjz) {
		this.gjz = gjz;
	}
	public News() {
		super();
	}
}
