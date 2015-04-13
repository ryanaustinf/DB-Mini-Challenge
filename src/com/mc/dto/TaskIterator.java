package com.mc.dto;

import java.util.ArrayList;


public class TaskIterator {
	private ArrayList<ToDo> tasks;
	private int curr;
	
	public TaskIterator( ArrayList<ToDo> tasks ) {
		this.tasks = tasks;
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
