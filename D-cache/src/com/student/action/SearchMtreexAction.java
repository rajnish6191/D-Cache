package com.student.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Dao.RegisterDAO;
import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;


public class SearchMtreexAction extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request, response);

}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		 String path="";	
		
	   DataFormBean bean=new DataFormBean();	 
		System.out.println("Serach QUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		
		
		List<DataFormBean> list2=new RegisterDAO().searchMtree();
		

		System.out.println("Serach QUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+list2);
		
		
		if(list2.size()>0)
		{
			
		request.setAttribute("list2",list2);
		path="MtreeSearch.jsp?status=these are details";
		}
		else
		{
		path="MtreeSearch.jsp?status=No details"	;
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
