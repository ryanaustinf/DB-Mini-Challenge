package com.mc.dto;

public class ToDo {

	private int toDoId;
	private String content;
	private String status;
	
	public int getToDoId() {
		return toDoId;
	}
	public void setToDoId(int toDoId) {
		this.toDoId = toDoId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ToDo(int toDoId, String content, String status) {
		super();
		this.toDoId = toDoId;
		this.content = content;
		this.status = status;
	}

}
