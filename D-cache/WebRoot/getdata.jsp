<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.student.Dao.DummyDB"%>
<%@page import="com.student.FormBean.DataFormBean"%>


<%!String title; %>
<%

	DummyDB db = new DummyDB();

	String query = request.getParameter("q");
	System.out.println(query);
	
	List<DataFormBean> countries = db.getData(query);
    for(DataFormBean form1:countries)
    {
     title=form1.getIname();
     
      out.println(title);
    //out.println(title+"-"+form1.getSubTitle());
      //  out.println(title+"-"+form1.getSubTitle()+"-"+form1.getDomain());
    
    
    }
   session.setAttribute("title",title);
   
  
	
%>
