package com.mc.servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.database.ToDoDAO;
import com.mc.dto.TaskIterator;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/previous" ,"/next","/start","/done"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	TaskIterator taskIter;
		
    	try {
			ToDoDAO.accomplish(Integer.parseInt(request.getParameter("id")));
			switch(request.getServletPath())
			{
				case "/previous":
					taskIter = TaskIterator.getInstance();
					taskIter.previous();
					request.getSession().setAttribute("todo", taskIter.get() );
					break;
				case "/next":
					taskIter = TaskIterator.getInstance();
					taskIter.next();
					request.getSession().setAttribute("todo", taskIter.get() );
					break;
				case "/start":
					taskIter = TaskIterator.getInstance( ToDoDAO.get() );
					request.getSession().setAttribute("todo", taskIter.get() );
					break;
				case "/done":
				
					break;
				default:
			}
    	} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		process(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		process(request, response);
		
	}

}
