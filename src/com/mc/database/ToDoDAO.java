package com.mc.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mc.dto.ToDo;


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
	
	
	public static void accomplish(int id) throws SQLException
		{
		String query = "UPDATE todo SET status = ? WHERE todo.toDoId = ?";
		try {
				PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
				ps.setString(1, ToDo.COMPLETE);
				ps.setInt(2, id);
			    ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
	
	public static ArrayList<ToDo> get()
			throws IllegalArgumentException {
		String query = "SELECT todo.toDoId, todo.content, todo.status";
		
		
		ArrayList<ToDo> toDos = new ArrayList<ToDo>();
		
		try {
			PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				ToDo t = new ToDo(rs.getInt(ToDo.TODOID_COLUMN),rs.getString(ToDo.CONTENT_COLUMN),
						rs.getString(ToDo.STATUS_COLUMN));
				toDos.add(t);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		}
		
		return toDos;
	}
	
}
