package entity;

/**
 * ÆÀÂÛ±í
 * @author Administrator
 *
 */
public class Comment {
	private int id;
	private int nid;
	private String content;
	private String member;
	private String addtime;
	public Comment() {
		super();
	}
	public Comment(int id, int nid, String content, String member, String addtime) {
		super();
		this.id = id;
		this.nid = nid;
		this.content = content;
		this.member = member;
		this.addtime = addtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}
