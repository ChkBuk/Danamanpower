package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.Employee;
import com.handler.EmployeeHandler;

/**
 * Servlet implementation class EmployeeSevlet
 */
@WebServlet("/EmployeeSevlet")
public class EmployeeSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	  PrintWriter out=response.getWriter();  
        String name=request.getParameter("name");  
       String password=request.getParameter("password");  
       String email=request.getParameter("email");  
       String country=request.getParameter("country");  
         
       Employee e=new Employee();  
       e.setName(name);  
       e.setPassword(password);  
       e.setEmail(email);  
       e.setCountry(country);  
         
       int status = 0;
	try {
		status = EmployeeHandler.insertEmployee(e);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
       if(status>0){  
           out.print("<p>Record saved successfully!</p>");  
           request.getRequestDispatcher("index.jsp").include(request, response);  
       }else{  
           out.println("Sorry! unable to save record");  
       }  
         
       out.close();  
   

	}
	


}
