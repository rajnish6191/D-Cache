package com.student.action;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.student.Dao.RegisterDAO;
import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;
public class PivotDataAction extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		long starttime=System.currentTimeMillis();
		System.out.println("time"+starttime);
		int x=0;
		int y=0;
		int z=0;
		int ind=0;	
		String path="";
		ObjectMapper mapper = new ObjectMapper(); 
		HttpSession session=request.getSession();
		DataFormBean dataFormBean=new DataFormBean();
		DataFormBean dataFormBean1=new DataFormBean();
		DataFormBean dataFormBean2=new DataFormBean();
		//DataFormBean cachebean=new DataFormBean();
		
		Map s1=null;
		Map s2=null;
		Map s3=null;
		Map s4=null;
		Map s5=null;
		Set set=null;
		Set set1=null;
		Set set2=null;
		Set set3=null;
		Set set4=null;
		
		try {
		         Map<String, Object> userInMap1 = mapper.readValue( new File("D:\\Cache File\\Cache1.json"),new TypeReference<Map<String, Object>>() {});
		         Map<String, Object> userInMap2 = mapper.readValue( new File("D:\\Cache File\\Cache2.json"),new TypeReference<Map<String, Object>>() {});
		         Map<String, Object> userInMap3 = mapper.readValue( new File("D:\\Cache File\\Cache3.json"),new TypeReference<Map<String, Object>>() {});
		         Map<String, Object> userInMap4 = mapper.readValue( new File("D:\\Cache File\\Cache4.json"),new TypeReference<Map<String, Object>>() {});
		         Map<String, Object> userInMap5 = mapper.readValue( new File("D:\\Cache File\\Cache5.json"),new TypeReference<Map<String, Object>>() {});
		        
	             ArrayList<String> arrayList1 = (ArrayList<String>)userInMap1.get("1");
	             ArrayList<String> arrayList2 = (ArrayList<String>)userInMap2.get("2");
	             ArrayList<String> arrayList3 = (ArrayList<String>)userInMap3.get("3");
	             ArrayList<String> arrayList4 = (ArrayList<String>)userInMap4.get("4");
	             ArrayList<String> arrayList5 = (ArrayList<String>)userInMap5.get("5");
				 
	             
	             ArrayList<String> al1 = arrayList1;
	             ArrayList<String> al2 = arrayList2;
	             ArrayList<String> al3 = arrayList3;
	             ArrayList<String> al4 = arrayList4;
	             ArrayList<String> al5 = arrayList5;
	             
	             
	             System.out.println(al1.size());
	             System.out.println(al2.size());
	             System.out.println(al3.size());
	             System.out.println(al4.size());
	             System.out.println(al5.size());
	             
	             
	             ListIterator it1=al1.listIterator();
	             ListIterator it2=al2.listIterator();
	             ListIterator it3=al3.listIterator();
	             ListIterator it4=al4.listIterator();
	             ListIterator it5=al5.listIterator();
	             while(it1.hasNext())
	             {
	              s1=(Map) it1.next();
		         System.out.println("id value is 1="+s1);
	            }
	             while(it2.hasNext())
	             {
	              s2=(Map) it2.next();
		         System.out.println("id value is 2="+s2);
	            }
	             while(it3.hasNext())
	             {
	             s3=(Map) it3.next();
		         System.out.println("id value is 3="+s3);
	            }
	             while(it4.hasNext())
	             {
	              s4=(Map) it4.next();
		         System.out.println("id value is 4="+s4);
	            }
	             while(it5.hasNext())
	             {
	              s5=(Map) it5.next();
		         System.out.println("id value is 5="+s5);
	            }
	           //System.out.print(s1.getKey() + ": ");
	           //  System.out.println(s1.getValue()); 
	             
		} catch (JsonGenerationException e) {
	    	   e.printStackTrace();
		} catch (JsonMappingException e) {
		   e.printStackTrace();
		} catch (IOException e) {
		   e.printStackTrace();
		}	
		try
		{
			    String path1=request.getRealPath("/data");
			    String path2=request.getRealPath("/data1");
			    String path3=request.getRealPath("/data2");
			    String path4=request.getRealPath("/data3");
			    String path5=request.getRealPath("/data4");
			    String username= (String) session.getAttribute("loginuser");
			    System.out.println(" user name is "+username);
			    String name=request.getParameter("title");
			    session.setAttribute("name", name);
			    session.setAttribute(name,"string");
			    int distance=Integer.parseInt(request.getParameter("dis"));
			    System.out.println("Server Distance====******===="+distance);		    
			    System.out.println("---"+name);
			    System.out.println("name is "+name);
			    System.out.println("distance is "+distance);
			      
			    System.out.println("Query Data is... " +s1.get("query"));  
			    int cdis11= (Integer)s1.get("distance");
			    int cdis12= (Integer)s2.get("distance");
			    int cdis13= (Integer)s3.get("distance");
			    int cdis14= (Integer)s4.get("distance");
			    int cdis15= (Integer)s5.get("distance");
			    
			    int A[] = new int[5];
			    
			   if(distance==cdis12)
			    {
			    
			    A[0]=cdis11;
			    A[1]=cdis12;
			    
			    int l= A[0];
			    int r=A[1];
			    int pivot=(l+r)/2;
			    distance=pivot;
			    System.out.println("pivot=="+pivot);
			    }
			    if(distance==cdis13)
			    {
			    
			    A[0]=cdis11;
			    A[1]=cdis12;
			    A[2]=cdis13;
			   
			    int l= A[0];
			    int r= A[2];
			    int pivot=(l+r)/2;
			    distance=pivot;
			   System.out.println("pivot=="+pivot);
			    }
			    
			    
			    if(distance==cdis14)
			    {
			    
			    A[0]=cdis11;
			    A[1]=cdis12;
			    A[2]=cdis13;
			    A[3]=cdis14;
			    
			    int l= A[0];
			    int r= A[3];
			    int pivot=(l+r)/2;
			    distance=pivot;
			   System.out.println("pivot=="+pivot);
			    }
			    
			    if(distance==cdis15)
			    {
			    
			    A[0]=cdis11;
			    A[1]=cdis12;
			    A[2]=cdis13;
			    A[3]=cdis14;
			    A[4]=cdis15;
			    int l= A[0];
			    int r=A[4];
			    int pivot=(l+r)/2;
			    distance=pivot;
			   System.out.println("pivot=="+pivot);
			    }
			   
			   
			    
			    if(s1.get("query").equals(name))
			    {
			    	DataFormBean cachebean;
			    	DataFormBean cachebean1;
			    	DataFormBean cachebean2;
			    	DataFormBean cachebean3;
			    	DataFormBean cachebean4;
			    	ArrayList<DataFormBean> arl = new ArrayList<DataFormBean>();
			    	ArrayList<DataFormBean> arl1 = new ArrayList<DataFormBean>();
			    	ArrayList<DataFormBean> arl2 = new ArrayList<DataFormBean>();
			    	ArrayList<DataFormBean> arl3 = new ArrayList<DataFormBean>();
			    	ArrayList<DataFormBean> arl4 = new ArrayList<DataFormBean>();
			    	
			    	
			 
			    System.out.println("Data are present in Cache memory");
			
			    
			    
			    if(distance>=cdis11)
			    {
			    cachebean=new DataFormBean();
			    String cname= (String)s1.get("query");
		    	System.out.println("Name"+cname);
		    	cachebean.setIname(cname);
		    	String cdesc= (String)s1.get("description");
		    	System.out.println("Description"+cdesc);
		    	cachebean.setDescription(cdesc);
		    	String cimage= (String)s1.get("image");
		    	System.out.println("image"+cimage);
		    	cachebean.setImage(cimage);
		    	int cdis= (Integer)s1.get("distance");
		    	System.out.println("distance"+cdis);
		    	cachebean.setDistance(cdis);
		    	arl.add(cachebean);
		    	    
			    } if(distance>=cdis12)
			    {
		    	 cachebean1=new DataFormBean();
				    String cname1= (String)s2.get("query");
			    	System.out.println("Name"+cname1);
			    	cachebean1.setIname(cname1);
			    	String cdesc1= (String)s2.get("description");
			    	System.out.println("description"+cdesc1);
			    	cachebean1.setDescription(cdesc1);
			    	String cimage1= (String)s2.get("image");
			    	System.out.println("image"+cimage1);
			    	cachebean1.setImage(cimage1);
			    	int cdis1= (Integer)s2.get("distance");
			    	System.out.println("distance"+cdis1);
			    	cachebean1.setDistance(cdis1);
			    	arl1.add(cachebean1);
			    }    
			    if(distance>=cdis13)
			    {    cachebean2=new DataFormBean();
					    String cname2= (String)s3.get("query");
				    	System.out.println("Name"+cname2);
				    	cachebean2.setIname(cname2);
				    	String cdesc2= (String)s3.get("description");
				    	System.out.println("description"+cdesc2);
				    	cachebean2.setDescription(cdesc2);
				    	String cimage2= (String)s3.get("image");
				    	System.out.println("image"+cimage2);
				    	cachebean2.setImage(cimage2);
				    	int cdis2= (Integer)s3.get("distance");
				    	System.out.println("distance"+cdis2);
				    	cachebean2.setDistance(cdis2);
				    	arl2.add(cachebean2);
			    } 
			    if(distance>=cdis14)
			    {	    
			    
				    	cachebean3=new DataFormBean();
					    String cname3= (String)s4.get("query");
				    	System.out.println("Name"+cname3);
				    	cachebean3.setIname(cname3);
				    	String cdesc3= (String)s4.get("description");
				    	System.out.println("description"+cdesc3);
				    	cachebean3.setDescription(cdesc3);
				    	String cimage3= (String)s4.get("image");
				    	System.out.println("image"+cimage3);
				    	cachebean3.setImage(cimage3);
				    	int cdis3= (Integer)s4.get("distance");
				    	System.out.println("distance"+cdis3);
				    	cachebean3.setDistance(cdis3);
				    	arl3.add(cachebean3);
			    } 
			    if(distance>=cdis15)
			    {	    
				    	cachebean4=new DataFormBean();
					    String cname4= (String)s5.get("query");
				    	System.out.println("Name"+cname4);
				    	cachebean4.setIname(cname4);
				    	String cdesc4= (String)s5.get("description");
				    	System.out.println("desc"+cdesc4);
				    	cachebean4.setDescription(cdesc4);
				    	String cimage4= (String)s5.get("image");
				    	System.out.println("image"+cimage4);
				    	cachebean4.setImage(cimage4);
				    	int cdis4= (Integer)s5.get("distance");
				    	System.out.println("distance"+cdis4);
				    	cachebean4.setDistance(cdis4);
				    	arl4.add(cachebean4);
			    }
			         ind=(arl.size()+arl1.size()+arl2.size()+arl3.size()+arl4.size());
				         long endtime=System.currentTimeMillis();
						 long difftime=endtime-starttime;
						 dataFormBean2.setDistance(distance);
						 dataFormBean2.setQuery(name);
						 dataFormBean2.setCount(ind);
						 dataFormBean2.setTime(difftime);
						 System.out.println("timing==="+difftime); 
				   
			   z = new RegisterDAO().insertDcacheDetails(username,dataFormBean2);
			   
				if(z>0)
				{
			  
		        path="./ResultDisplay2.jsp";
				request.setAttribute("Data", arl);
				request.setAttribute("Data1", arl1);
				request.setAttribute("Data2", arl2);
				request.setAttribute("Data3", arl3);
				request.setAttribute("Data4", arl4);
				 System.out.println("in Action class arl cachedata ..........."+arl);
				 System.out.println("in Action class arl1 cachedata ..........."+arl1);
				 System.out.println("in Action class arl2 cachedata ..........."+arl2);
				 System.out.println("in Action class arl3 cachedata ..........."+arl3);
				 System.out.println("in Action class arl4 cachedata ..........."+arl4);
				
				}
			
			    }
			    else
			    {
			    System.out.println("Data are not present in Cache");	
			     
			    ArrayList<DataFormBean> vqb= new DataDao().viewWebpage(path1,name,distance);			  								 
			    ArrayList<DataFormBean> vqb1= new DataDao().viewWebpage1(path2,name,distance);	
			    ArrayList<DataFormBean> vqb2= new DataDao().viewWebpage2(path3,name,distance);	
			    ArrayList<DataFormBean> vqb3= new DataDao().viewWebpage3(path4,name,distance);	
			    ArrayList<DataFormBean> vqb4= new DataDao().viewWebpage4(path5,name,distance);	
			    System.out.println("in Action class vcb Datafrom ..........."+vqb);
			    System.out.println("in Action class vcb1 Datafrom ..........."+vqb1);
			    System.out.println("in Action class vcb2 Datafrom ..........."+vqb2);
			    System.out.println("in Action class vcb3 Datafrom ..........."+vqb3);
			    System.out.println("in Action class vcb4 Datafrom ..........."+vqb4);			
			    long endtime=System.currentTimeMillis();
				long difftime=endtime-starttime;
				dataFormBean.setTime(difftime);
				
			     dataFormBean.setQuery(name);
			     ind=(vqb.size()+vqb1.size()+vqb2.size()+vqb3.size()+vqb4.size());
			     System.out.println("------index from all servers::::::"+ind);
			     dataFormBean.setCount(ind);
			   
			    
			  if(!vqb.isEmpty())
			  {
					 
					
					  y=new RegisterDAO().insertImageDetails(username,dataFormBean);
				  
				   if(y>0)
				  {
				  path="./ResultDisply3.jsp";
					request.setAttribute("DataInfo", vqb);
					request.setAttribute("DataInfo1", vqb1);
					request.setAttribute("DataInfo2", vqb2);
					request.setAttribute("DataInfo3", vqb3);
					request.setAttribute("DataInfo4", vqb4);
					request.setAttribute("status", "Here is the Data Info");
					
					// save object in hashMap
				  } 
				     
					   
					Map<String, Object> InMap = new HashMap<String, Object>();
					Map<String, Object> InMap1 = new HashMap<String, Object>();
					Map<String, Object> InMap2 = new HashMap<String, Object>();
					Map<String, Object> InMap3 = new HashMap<String, Object>();
					Map<String, Object> InMap4 = new HashMap<String, Object>();
				    
					try {
						 
						  // write JSON to a file
						 if(vqb.size()!=0)
						  {
							 InMap.put("1", vqb);
						  mapper.writeValue(new File("D:\\Cache File\\Cache1.json"), InMap);
						   }
						 if(vqb1.size()!=0)
						{
					       InMap1.put("2", vqb1);
						  mapper.writeValue(new File("D:\\Cache File\\Cache2.json"), InMap1);
						}
						 if(vqb2.size()!=0)
						{
						InMap2.put("3", vqb2);
						  mapper.writeValue(new File("D:\\Cache File\\Cache3.json"), InMap2);
						}
						 if(vqb3.size()!=0)
						  {
							InMap3.put("4", vqb3);
						  mapper.writeValue(new File("D:\\Cache File\\Cache4.json"), InMap3);
						  }
						 if(vqb4.size()!=0)
						  {
						     InMap4.put("5", vqb4);
						  mapper.writeValue(new File("D:\\Cache File\\Cache5.json"), InMap4);
						  }
					 
						} catch (JsonGenerationException e) {
						  e.printStackTrace();
						} catch (JsonMappingException e) {
						  e.printStackTrace();
						} catch (IOException e) {
						  e.printStackTrace();
						}
				  }
					
				 
			  else {
				  
				  path="userhome.jsp";
				  request.setAttribute("status","No Data is Found Related to  U R Query");
				
			}
		    }
		} 
		  catch (Exception e) {
			e.printStackTrace();
			path="userhome.jsp";
			request.setAttribute("status","No Data is Found Related to  U R Query");
		}

		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);	
	}
}
