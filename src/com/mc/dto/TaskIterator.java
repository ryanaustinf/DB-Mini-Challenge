package com.mc.dto;

import java.util.ArrayList;


public class TaskIterator {
	private ArrayList<ToDo> tasks;
	private int curr;
	
	private static TaskIterator instance = null;
	
	private TaskIterator( ArrayList<ToDo> tasks ) {
		this.tasks = new ArrayList<ToDo>();
		if( tasks.size() == 0 ) {
			this.tasks.add( new ToDo( 0, "No Tasks",ToDo.PENDING ));
		} else {
			for( ToDo toDo: tasks ) {
				if( toDo.getStatus().equalsIgnoreCase(ToDo.PENDING) ) {
					this.tasks.add(toDo);
				}
			}
		}
		curr = 0;
	}
	
	public static TaskIterator getInstance() {
		if( instance == null ) {
			instance = new TaskIterator( new ArrayList<ToDo>() );
		}
		
		return instance;
	}
	
	public static TaskIterator getInstance( ArrayList<ToDo> tasks ) {
		instance = new TaskIterator( tasks );
		
		return instance;
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
