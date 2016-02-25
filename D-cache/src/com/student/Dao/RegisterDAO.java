package com.student.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import com.student.FormBean.DataFormBean;
import com.student.Db.ConnectionFactory;
import com.student.FormBean.RegisterFormBean;
import com.student.Util.CoreList;
import com.student.Util.DateWrapper;
import com.student.Util.LoggerManager;
import com.student.Dao.RegisterDAO;
import org.apache.log4j.Logger;



public class RegisterDAO {
	
	
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	private static Logger logger = Logger.getLogger(RegisterDAO.class);
	
	
	
	public RegisterDAO(){
		
		con=ConnectionFactory.getConnection();
		
	}
	
	public boolean insertNewUser(RegisterFormBean cp) throws FileNotFoundException
    
    {
    	boolean flag=false;
    	int insert=0;
    	int j=0;
    	try{	    		
    		
    		con.setAutoCommit(false);
	    	System.out.println("in registerDAO connection is ."+con);	
	    	
            pstmt=con.prepareStatement("insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,?,?,?,?,?)");	            		    		
    		System.out.println();
    		String photo =cp.getPhoto();
    		
    		String dob=DateWrapper.parseDate(cp.getDob());
    		System.out.println(" in dao dob"+dob);
    		
    		String fname=cp.getFname();
    		String lname=cp.getLname();
    		String squestion=cp.getQuestn();
    		String ans=cp.getAnsr();
    		String email=cp.getEmail();
    		String phone=cp.getMobile();
    		
    	
    		
    		String loginid=cp.getUserid();
    		String pwd=cp.getUserpwd();	    			    		
    		String hno=cp.getHno();
    		String street=cp.getStreet();
    		String city=cp.getCity();
    		String state=cp.getState();
    		String country=cp.getCountry();
    		String pin=cp.getPin();	    		
    		System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());	        	
        	
        		    		        	
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, dob);
            pstmt.setString(4, loginid);
            pstmt.setString(5, pwd);
            pstmt.setString(6, "user");
            pstmt.setString(7, squestion);
            pstmt.setString(8, ans);
           
          
          pstmt.setBinaryStream(9, fis,(int)f.length());
        
          pstmt.setString(10, email);
        
          int i=pstmt.executeUpdate();
          
          if(i>0)
          {	        	  
        	  pstmt1=con.prepareStatement("insert into addresses values((select max(userid) from userdetails),?,?,?,?,?,?,?)");	        	  	        	  
        	  pstmt1.setString(1, hno);
        	  pstmt1.setString(2, street);
        	  pstmt1.setString(3, city);
        	  pstmt1.setString(4, state);
        	  pstmt1.setString(5, country);
        	  pstmt1.setString(6,pin);
        	  pstmt1.setString(7, phone);
        	  
        	  insert=pstmt1.executeUpdate();
        	  }	          	          
         
          if(insert>0){
        	  flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(SQLException e){
			 
			 e.printStackTrace();
		 }
		}
	return flag;
}
	
	
	
	public ArrayList<RegisterFormBean> getUserInfo(String path)
    {
		ArrayList<RegisterFormBean> arb =null;
     
    	
    	
		String userid="";
		
		
		
		try {
			
			pstmt = con.prepareStatement("select u.userid,u.logintype,u.loginid,u.password,u.firstname,u.lastname,TO_CHAR(u.dob,'DD-MM-YYYY'),u.emailid,u.photo,a.phone from userdetails u ,addresses a where u.logintype ='user' and u.userid=a.userid");
			
			//pstmt.setString(1,"user");
  		     rs = pstmt.executeQuery();
		   
		     arb=new ArrayList<RegisterFormBean>();
			
			
	while(rs.next())
			{
				
		RegisterFormBean	rb=new RegisterFormBean();
		
				userid=rs.getString(1);
				
              		
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setLogin(rs.getString(3));
				rb.setUserpwd(rs.getString(4));
				
				rb.setFname(rs.getString(5));
				rb.setLname(rs.getString(6));
				rb.setDob(rs.getString(7));
				rb.setEmail(rs.getString(8));
			
				Blob b=rs.getBlob(9);
				if(b!=null){
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				}
				rb.setMobile(rs.getString(10));
				
				arb.add(rb);
				}
				
				
				
			
    	}
    	catch(Exception se)
    	{
    		se.printStackTrace();
    	}
    	
    	return arb;
    }  
	
	
	
	
	public RegisterFormBean getprofile(String name,String path)
    {
		CoreList aCoreList = new CoreList();
     
    	
    	
    	RegisterFormBean rb=null;
		aCoreList.clear();
		
		String userid="";
		String ltype="";
		
		
		try {
			
			pstmt1=con.prepareStatement("select logintype from userdetails where loginid=?");
			pstmt1.setString(1, name);
			
			rs1=pstmt1.executeQuery();
			
			while(rs1.next()){
				
				ltype=rs1.getString(1);
				
			}
			
			pstmt = con.prepareStatement("select u.userid,u.logintype,u.firstname,u.lastname,TO_CHAR(u.dob,'DD-MM-YYYY'),u.emailid,u.photo,a.phone,a.houseno,a.street,a.city,a.state,a.country,a.pincode from userdetails u ,addresses a where u.logintype =? and u.userid=a.userid and u.loginid=?");
			
			pstmt.setString(1,ltype);
			pstmt.setString(2, name);
		     rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				rb=new RegisterFormBean();
				userid=rs.getString(1);
			
				rb.setUserid(userid);
				rb.setLogintype(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setLname(rs.getString(4));
				rb.setDob(rs.getString(5));
				rb.setEmail(rs.getString(6));
			
				Blob b=rs.getBlob(7);
				if(b!=null){
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout=new FileOutputStream(path+"/"+ userid+".jpg");
				fout.write(b1);
			
				rb.setPhoto(userid+".jpg");
				
				rb.setMobile(rs.getString(8));
				
				rb.setHno(rs.getString(9));
				rb.setStreet(rs.getString(10));
				rb.setCity(rs.getString(11));
				rb.setState(rs.getString(12));
				rb.setCountry(rs.getString(13));
				rb.setPin(rs.getString(14));
				
				}
				
			}	
    	}
    	catch(SQLException se)
    	{
    		LoggerManager.writeLogWarning(se);
    	}
    	catch(Exception e)
    	{
    		LoggerManager.writeLogWarning(e);
    	}
    	finally
    	{
    		try
    		{
    			con.close();
    		}
    		catch(SQLException se)
    		{
    			LoggerManager.writeLogWarning(se);
    		}
    	}
    	return rb;
    }  
	
	
	public String passwordRecovery(RegisterFormBean rto){
    	String password="";
        try{
        	
        	 String question=rto.getSquest();
			 String ans=rto.getSanswer();
			 String loginid=rto.getUserid();
			
			 
			 System.out.println(question);
			 System.out.println(ans);
			 System.out.println(loginid);
        	pstmt=con.prepareStatement("select password from userdetails where loginid=? and forgotpwquestion=? and forgotpwanswer=?");
        	pstmt.setString(1, loginid);
        	pstmt.setString(2, question);
        	pstmt.setString(3, ans);
        	rs=pstmt.executeQuery();
        	if(rs.next()){
        		password=rs.getString(1);
        	}
        }catch(SQLException e){
        	e.printStackTrace();
        }
    	return password;
    }
 
 
 public boolean checkAvailability(String userid){
    	boolean flag=false;
    	try{
    		pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
    		pstmt.setString(1, userid);
    		rs=pstmt.executeQuery();
    		if(rs.next()){
    			flag=true;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return flag;
    }
    
 
 public boolean deleteUser(int userid){
	   
	   
	   boolean flag=false;
	   
	   try{
		   
		   pstmt=con.prepareStatement("delete from userdetails where userid=?");
		   
		   pstmt.setInt(1, userid);
		   
		   
		   int delete=pstmt.executeUpdate();
		   
		   if(delete>0)
	         {
    	  flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	    } 
	    catch (SQLException e) 
	    {
	    	logger.error(e);
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	        	logger.error(e);
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(SQLException e){
			 
			 logger.error(e);
		 }
		}
	return flag;
 
 
 
 }
 
 
 
 public boolean changePass(RegisterFormBean rto){
    	boolean flag=false;
    	try{
    		
    
    		
    		String newpass=rto.getNewpassword();
    		System.out.println("in DAO class//////////////////"+newpass);
    		String user=rto.getUsername();
    		System.out.println("in DAo ............login .is........."+user);
    		String oldpass=rto.getOldpassword();
    		
    		pstmt=con.prepareStatement("update userdetails set password=? where loginid=? and password=?");
    		pstmt.setString(1, newpass);
    		pstmt.setString(2, user);
    		pstmt.setString(3, oldpass);
    		int c=pstmt.executeUpdate();
    		if(c>0){
    			flag=true;
    			con.commit();
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return flag;
    }
 
 public List<DataFormBean> searchQuery()
	{
	 DataFormBean dataFormBean=null;
		List<DataFormBean> list=new ArrayList<DataFormBean>();
		//String sql="select u.loginid,s.imagename,q.time from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid";
		try {
			pstmt=con.prepareStatement("select  u.loginid,q.query,q.time,q.sdate from imagedetails q,userdetails u,imagedata s where q.userid=u.userid and s.imagename=q.query");
	
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			dataFormBean=new DataFormBean();
	         String loginid=rs.getString(1);
	         dataFormBean.setLoginid(loginid);
			String query=rs.getString(2);
			dataFormBean.setQuery(query);
			long time=rs.getLong(3);
			dataFormBean.setTime(time);
			String sdate=rs.getString(4);
			dataFormBean.setSdate(sdate);
			
			
		list.add(dataFormBean);	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
 
 
 public List<DataFormBean> searchIndex()
	{
	 DataFormBean dataFormBean=null;
		List<DataFormBean> list=new ArrayList<DataFormBean>();
		//String sql="select u.loginid,s.imagename,q.time from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid";
		try {
			pstmt=con.prepareStatement("select  time,count,query,sdate from imagedetails");
	
		rs=pstmt.executeQuery();
		int i=0;
		while(rs.next())
		{
			
			
			dataFormBean=new DataFormBean();
	         
			long time=rs.getLong(1);
			dataFormBean.setTime(time);
			int count =rs.getInt(2);
			dataFormBean.setCount(count);
			String query =rs.getString(3);
			dataFormBean.setQuery(query);
			String sdate=rs.getString(4);
			dataFormBean.setSdate(sdate);
		list.add(dataFormBean);	
		i++;
		}
		System.out.println(" i value is "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

 public List<DataFormBean> searchMtree()
	{
	 DataFormBean dataFormBean=null;
		List<DataFormBean> list=new ArrayList<DataFormBean>();
		//String sql="select u.loginid,s.imagename,q.time from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid";
		try {
			pstmt=con.prepareStatement("select  query,time,count,sdate from indexdetails");
	
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			dataFormBean=new DataFormBean();
			String query=rs.getString(1);
			dataFormBean.setQuery(query);
			long time=rs.getLong(2);
			dataFormBean.setTime(time);
			int count =rs.getInt(3);
			dataFormBean.setCount(count);
			String sdate=rs.getString(4);
			dataFormBean.setSdate(sdate);
		list.add(dataFormBean);	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

 
 public List<DataFormBean> searchDcache()
	{
	 DataFormBean dataFormBean=null;
		List<DataFormBean> list=new ArrayList<DataFormBean>();
		//String sql="select u.loginid,s.imagename,q.time from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid";
		try {
			pstmt=con.prepareStatement("select  time,count,query,distance,sdate from dcachedetails ");
	
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			
			
			dataFormBean=new DataFormBean();
	        
			long time=rs.getLong(1);
			dataFormBean.setTime(time);
			int count =rs.getInt(2);
			dataFormBean.setCount(count);
			String query =rs.getString(3);
			dataFormBean.setQuery(query);
			int distance =rs.getInt(4);
			dataFormBean.setDistance(distance);
			String sdate=rs.getString(5);
			dataFormBean.setSdate(sdate);
		list.add(dataFormBean);	
		
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

 public List<DataFormBean> searchgraph()
	{
	 DataFormBean dataFormBean=null;
		List<DataFormBean> list=new ArrayList<DataFormBean>();
		//String sql="select u.loginid,s.imagename,q.time from imagedetails q,userdetails u,imagedata s where s.imageid=q.imageid and q.userid=u.userid";
		try {
			pstmt=con.prepareStatement("select s.imagename,q.time from imagedetails q,imagedata s where s.imagename=q.query");
	
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			
			dataFormBean=new DataFormBean();
	        
	        
			String query=rs.getString(1);
			dataFormBean.setIname(query);
			long time=rs.getLong(2);
			dataFormBean.setTime(time);
			
		list.add(dataFormBean);	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
 
 public Float Indexgraph()
	{
	
	 Float time=null;
		
		try {
			pstmt=con.prepareStatement("select avg(time) from imagedetails ");
	
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			rs.getLong(1);
			
		     time =rs.getFloat(1);
		     System.out.println(time);
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
		
	}

 
 public Float Mtreegraph()
	{
	
	 Float time=null;
		
		try {
			pstmt=con.prepareStatement("select avg(time) from indexdetails ");
	
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			rs.getLong(1);
			
		     time =rs.getFloat(1);
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
		
	}


 public Float Dcachegraph()
	{
	
	 Float time=null;
		
		try {
			pstmt=con.prepareStatement("select avg(time) from dcachedetails");
	
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			rs.getLong(1);
			
		     time =rs.getFloat(1);
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
		
	}

 public int insertImageDetails(String username,DataFormBean dataFormBean)
	{
		int x=0;
		int id=0;
		try
		{
			System.out.println("---"+username);
			Random rr=new Random();
			boolean flag=rr.nextBoolean();
			 String s = new Boolean(flag).toString();
		String sql="select userid from userdetails where loginid=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		rs=pstmt.executeQuery();
		
		
		if(rs.next()){
 		id=rs.getInt(1);
 		System.out.println("--- user id  value"+id);
 	}
 	pstmt1=con.prepareStatement("insert into imagedetails values(?,?,?,?,sysdate)");
 	
 	pstmt1.setInt(1,id);
 	long time=dataFormBean.getTime();
 	pstmt1.setLong(2,time);
 	int count=dataFormBean.getCount();
 	pstmt1.setInt(3,count);
 	String query=dataFormBean.getQuery();
 	pstmt1.setString(4,query);
 	x=pstmt1.executeUpdate();
 	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return x;
		
		
		
		
	}
 
 
 
 
 
 public int insertIndexDetails(String username,DataFormBean dataFormBean1)
	{
		int x=0;
		int id=0;
		try
		{
			System.out.println("---"+username);
			Random rr=new Random();
			boolean flag=rr.nextBoolean();
			 String s = new Boolean(flag).toString();
		String sql="select userid from userdetails where loginid=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		rs=pstmt.executeQuery();
		
		
		if(rs.next()){
		id=rs.getInt(1);
		System.out.println("--- user id  value"+id);
	}
	pstmt1=con.prepareStatement("insert into indexdetails values(?,?,?,?,sysdate)");
	
	pstmt1.setInt(1,id);
	long time=dataFormBean1.getTime();
	pstmt1.setLong(2,time);
	
	int count=dataFormBean1.getCount();
 	pstmt1.setInt(3,count);
 	String query=dataFormBean1.getQuery();
 	pstmt1.setString(4,query);
 	
	
	x=pstmt1.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return x;
		
		
		
		
	}

 public int insertDcacheDetails(String username,DataFormBean dataFormBean2)
	{
		int x=0;
		int id=0;
		try
		{
			System.out.println("---"+username);
			Random rr=new Random();
			boolean flag=rr.nextBoolean();
			 String s = new Boolean(flag).toString();
		String sql="select userid from userdetails where loginid=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		rs=pstmt.executeQuery();
	
		
		if(rs.next()){
		id=rs.getInt(1);
		System.out.println("--- user id  value"+id);
	}
	pstmt1=con.prepareStatement("insert into dcachedetails values(?,?,?,?,?,sysdate)");
	
	pstmt1.setInt(1,id);
	long time=dataFormBean2.getTime();
	pstmt1.setLong(2,time);
	
	int count=dataFormBean2.getCount();
	pstmt1.setInt(3,count);
	String query=dataFormBean2.getQuery();
	pstmt1.setString(4,query);
	int distance =dataFormBean2.getDistance();
	pstmt1.setInt(5, distance);
	x=pstmt1.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return x;
		
		
		
		
	}
 public Vector<String> searchgraph1()
 {
 	Vector<String> v=new Vector<String>();
 	ResultSet rs;
 	PreparedStatement ps;
 	 DataFormBean dataFormBean=null;
 	try {
 		
 		String sql="select s.imagename,q.time from imagedetails q,imagedata s where s.imageid=q.imageid";
 		ps= con.prepareStatement(sql);
 		rs=ps.executeQuery();
 		while(rs.next())
 		{
              dataFormBean=new DataFormBean();
	        
	        
			String query=rs.getString(1);
			dataFormBean.setIname(query);
			long time=rs.getLong(2);
			dataFormBean.setTime(time);
 			
 			v.add(query+":"+time);
 			
 		}
 		
 		return v;
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		System.out.println(e.getMessage());
		}
 	return null;
 }
 
 

}
