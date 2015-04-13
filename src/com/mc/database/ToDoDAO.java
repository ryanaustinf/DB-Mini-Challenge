package com.mc.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mc.dto.ToDo;


public class ToDoDAO {

	
	
	public static void add(ToDo toDo ) throws SQLException {

		String stmt = "INSERT INTO todo(" + ToDo.CONTENT_COLUMN + "," + 
						ToDo.STATUS_COLUMN + ") VALUES (?,?)";
		try {
			PreparedStatement ps = DBConnection.getConnection().prepareStatement(stmt);
			ps.setString(1, toDo.getContent() );
			ps.setString(2, toDo.getStatus() );
			System.out.println( ps );
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
		String query = "SELECT * FROM todo";
		
		
		ArrayList<ToDo> toDos = new ArrayList<ToDo>();
		
		try {
			PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				ToDo t = new ToDo(rs.getInt(ToDo.TODOID_COLUMN),rs.getString(ToDo.CONTENT_COLUMN),
						rs.getString(ToDo.STATUS_COLUMN));
				toDos.add(t);
				System.out.println( t );
			}
		} catch(SQLException se) {
			se.printStackTrace();
		}
		
		return toDos;
	}
	
}
