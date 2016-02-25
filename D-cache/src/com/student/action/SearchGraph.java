package com.student.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.Dao.RegisterDAO;
import com.student.FormBean.DataFormBean;

public class SearchGraph extends HttpServlet{
	private static String path="";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request, response);

}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session1=request.getSession();
		Float time=new RegisterDAO().Indexgraph();
		System.out.println("the value is searchgraph"+time);
		Float time1=new RegisterDAO().Mtreegraph();
		Float time2=new RegisterDAO().Dcachegraph();
		if(time>0)
		{
			session1.setAttribute("time",time);
			session1.setAttribute("time1",time1);
			session1.setAttribute("time2",time2);
		path="Precision.jsp?status=these are details";
		}
		else
		{
		path="Precision.jsp?status=No details"	;
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

