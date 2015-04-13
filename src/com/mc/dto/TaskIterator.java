package com.mc.dto;

import java.util.ArrayList;


public class TaskIterator {
	private ArrayList<ToDo> tasks;
	private int curr;
	
	public TaskIterator( ArrayList<ToDo> tasks ) {
		this.tasks = new ArrayList<ToDo>();
		for( ToDo toDo: tasks ) {
			if( toDo.getStatus().equalsIgnoreCase(ToDo.PENDING) {
				this.tasks.add(toDo);
			}
		}
		curr = 0;
	}
	
	public ToDo get() {
		if( tasks.size() > 0 ) {
			return tasks.get(curr);
		}
		return null;
	}
	
	public ToDo next() {
		if( curr + 1 < tasks.size() ) {
			curr++;
		}
		
		return get();
	}
	
	public ToDo previous() {
		if( curr > 0 ) {
			curr--;
		}
		
		return get();
	}
}
