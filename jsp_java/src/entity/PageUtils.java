package entity;

import java.util.List;

public class PageUtils<T> {
	private int currentPage;
	private int pageSize;
	private String tableName;
	private String selections;
	private String condition;
	private String sortColumn;
	private String sortType;
	
	private List<T> datas;
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	private int totalNum;
	private int totalPage;
	public PageUtils(int currentPage, int pageSize, String tableName, String selections, String condition,
			String sortColumn, String sortType, int totalNum, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.tableName = tableName;
		this.selections = selections;
		this.condition = condition;
		this.sortColumn = sortColumn;
		this.sortType = sortType;
		this.totalNum = totalNum;
		this.totalPage = totalPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public PageUtils() {
		super();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getSelections() {
		return selections;
	}
	public void setSelections(String selections) {
		this.selections = selections;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
}
