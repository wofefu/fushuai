package utils;

import java.util.List;

public class ResultData {
	private int status;//1：成功  -1：失败
	private String content;//说明
	private List list;//[{},{}]

	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
