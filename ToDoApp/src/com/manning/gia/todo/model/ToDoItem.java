package com.manning.gia.todo.model;

public class ToDoItem implements Comparable<ToDoItem> {
	private Long id;
	private String name;
	private boolean complete;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isCompleted() {
		return complete;
	}
	
	public void setCompleted(boolean complete) {
		this.complete = complete;
	}
	
	public int compareTo(ToDoItem other) {
		return other.id.intValue() - this.id.intValue();
	}
}