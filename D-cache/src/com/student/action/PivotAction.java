package com.student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;

public class PivotAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	String path=null;

		response.setContentType("text/html");
		DataDao d=new DataDao();
		DataFormBean df= new DataFormBean();
		ArrayList<DataFormBean> P=null;
		try {
			 P=d.retreveImageId(df);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println("size"+v.size());
		
		if(P!=null)
		{
		request.setAttribute("P", P);
			path="./Pivot.jsp";
		}
		
		else 
			
		{
			path="./Home.jsp";
			System.out.println(" not retreved");
		}
	
	RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request, response);
	}

}
