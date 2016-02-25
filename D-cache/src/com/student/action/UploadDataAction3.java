package com.student.action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;

public class UploadDataAction3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
         doPost(request, response);
         
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		RequestDispatcher rd=null;
        boolean flag=false;
		DataFormBean  wf=new DataFormBean();
	    Map map=request.getParameterMap();
		
		try{
			BeanUtils.populate(wf, map);
			
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			HttpSession session=request.getSession();
			
			String login=(String)session.getAttribute("loginuser");
			
			String imagename=request.getParameter("iname");
			wf.setIname(imagename);
			String discription=request.getParameter("description");
			wf.setDescription(discription);
		    int distance=Integer.parseInt(request.getParameter("distance"));
			wf.setDistance(distance);
			String bookimage=request.getParameter("image");
			wf.setImage(bookimage);
		flag= new DataDao().uploadData3(wf);
		
		if(flag){
			request.setAttribute("status", "Data Uploded in to Database successfully");
			path="./UploadWebpage3.jsp";
			
		}
		else{
			request.setAttribute("status", "Image data Uploading failed");
			path="./UploadWebpage3.jsp";
			
		}
		}catch (NullPointerException e) {
		e.printStackTrace();
		request.setAttribute("status", "Server busy plz try After some time");
		path="./UploadWebpage3.jsp";
	}
        rd=request.getRequestDispatcher(path);
        rd.forward(request, response);
		
		
	}

}
