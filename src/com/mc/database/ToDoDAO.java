package com.mc.database;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import DBConnection;


public class ToDoDAO {

	
	
	public static void add(ToDo toDo ) throws SQLException {

		String stmt = "INSERT INTO todo VALUES (?,?,?)";
		try {
			PreparedStatement ps = DBConnection.getConnection().prepareStatement(stmt);
			ps.setInt(1, toDo.getToDoId() );
			ps.setString(2, toDo.getContent() );
			ps.setString(3, toDo.getStatus() );
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}	
	
	
	
}
