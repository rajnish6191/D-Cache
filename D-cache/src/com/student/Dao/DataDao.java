package com.student.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.poi.hssf.record.formula.Ptg;

import sun.swing.AccumulativeRunnable;

import com.student.Db.ConnectionFactory;

import com.student.FormBean.DataFormBean;
import com.student.Util.DateWrapper;



public class DataDao {

	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7,pstmt8,pstmt9,pstmt10;
	Statement stmt,statement,stmt1;
	ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6;
	Connection con;
	public DataDao(){
		
		con=ConnectionFactory.getConnection();
	}
         public boolean uploadData(DataFormBean sf){
		
		int imageid=0;
		int i=0;
		boolean flag=false;
		try{
			stmt=con.createStatement();
		pstmt=con.prepareStatement("insert into Imagedata values((select nvl(max(imageid),100)+1 from Imagedata),?,?,?,?)");
		pstmt.setString(1, sf.getIname());
	    pstmt.setString(2, sf.getDescription());
	    pstmt.setInt(3, sf.getDistance());
		String image=sf.getImage();
			File f=new File(image);
			FileInputStream fis=new FileInputStream(f);
		pstmt.setBinaryStream(4, fis, (int)f.length());
			 i=pstmt.executeUpdate();
		 
		 if(i>0){
			 
			 flag=true;
			 con.commit();
		 
		 }
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		try{
			
			if(con!=null){
				
				con.close();
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
		return flag;
	}
      public boolean uploadData1(DataFormBean sf){
     		
     		int imageid=0;
     		int i=0;
     		boolean flag=false;
     		try{
      			stmt=con.createStatement();
     		pstmt=con.prepareStatement("insert into Imagedata1 values((select nvl(max(imageid),100)+1 from Imagedata1),?,?,?,?)");
     		pstmt.setString(1, sf.getIname());
     	    pstmt.setString(2, sf.getDescription());
     	    pstmt.setInt(3, sf.getDistance());
     		String image=sf.getImage();
        		File f=new File(image);
     		
     		FileInputStream fis=new FileInputStream(f);
     		pstmt.setBinaryStream(4, fis, (int)f.length());
      		 i=pstmt.executeUpdate();
     		 
     		 if(i>0){
     			 
     			 flag=true;
     			 con.commit();
     		 
     		 }
     		
     	}
     	catch (Exception e) {
     		e.printStackTrace();
     	}
     	finally{
     		try{
     			
     			if(con!=null){
     				
     				con.close();
     				
     			}
     			
     		}catch (SQLException e) {
     			e.printStackTrace();
     		}
     	
     		
     	}
     		return flag;
     		
     		
     	}


         public boolean uploadData2(DataFormBean sf){
     		
     		int imageid=0;
     		int i=0;
     		boolean flag=false;
     		try{
     		
     			
     			stmt=con.createStatement();
       		pstmt=con.prepareStatement("insert into Imagedata2 values((select nvl(max(imageid),100)+1 from Imagedata2),?,?,?,?)");
     		pstmt.setString(1, sf.getIname());
     	    pstmt.setString(2, sf.getDescription());
     	    pstmt.setInt(3, sf.getDistance());
     		String image=sf.getImage();
     		
     		File f=new File(image);
     		
     		FileInputStream fis=new FileInputStream(f);
     		pstmt.setBinaryStream(4, fis, (int)f.length());
     		
     		
     		
     		 i=pstmt.executeUpdate();
     		 
     		 if(i>0){
     			 
     			 flag=true;
     			 con.commit();
     		 
     		 }
     		
     	}
     	catch (Exception e) {
     		e.printStackTrace();
     	}
     	finally{
     		try{
     			
     			if(con!=null){
     				
     				con.close();
     				
     			}
     			
     		}catch (SQLException e) {
     			e.printStackTrace();
     		}
     	
     		
     	}
     		return flag;
     		
     		
     	}
        public boolean uploadData3(DataFormBean sf){
     		
     		int imageid=0;
     		int i=0;
     		boolean flag=false;
     		try{
     		
     			
     			stmt=con.createStatement();
       		pstmt=con.prepareStatement("insert into Imagedata3 values((select nvl(max(imageid),100)+1 from Imagedata3),?,?,?,?)");
     		pstmt.setString(1, sf.getIname());
     	    pstmt.setString(2, sf.getDescription());
     	    pstmt.setInt(3, sf.getDistance());
     		String image=sf.getImage();
     		
     		File f=new File(image);
     		
     		FileInputStream fis=new FileInputStream(f);
     		pstmt.setBinaryStream(4, fis, (int)f.length());
     		
     		
     		
     		 i=pstmt.executeUpdate();
     		 
     		 if(i>0){
     			 
     			 flag=true;
     			 con.commit();
     		 
     		 }
     		
     	}
     	catch (Exception e) {
     		e.printStackTrace();
     	}
     	finally{
     		try{
     			
     			if(con!=null){
     				
     				con.close();
     				
     			}
     			
     		}catch (SQLException e) {
     			e.printStackTrace();
     		}
     	
     		
     	}
     		return flag;
     		
     		
     	}

         public boolean uploadData4(DataFormBean sf){
     		
     		int imageid=0;
     		int dist=0;
     		int i=0;
     		boolean flag=false;
     		try{
     		
     			
     			stmt=con.createStatement();
     				pstmt=con.prepareStatement("insert into Imagedata4 values((select nvl(max(imageid),100)+1 from Imagedata4),?,?,?,?,(select nvl(max(dist),90)+10 from Imagedata4))");
     		pstmt.setString(1, sf.getIname());
     	    pstmt.setString(2, sf.getDescription());
     	    pstmt.setInt(3, sf.getDistance());
     		String image=sf.getImage();
     		
     		File f=new File(image);
     		
     		FileInputStream fis=new FileInputStream(f);
     		pstmt.setBinaryStream(4, fis, (int)f.length());
     		
     		
     		
     		 i=pstmt.executeUpdate();
     		 
     		 if(i>0){
     			 
     			 flag=true;
     			 con.commit();
     		 
     		 }
     		
     	}
     	catch (Exception e) {
     		e.printStackTrace();
     	}
     	finally{
     		try{
     			
     			if(con!=null){
     				
     				con.close();
     				
     			}
     			
     		}catch (SQLException e) {
     			e.printStackTrace();
     		}
     	
     		
     	}
     		return flag;
     		
     		
     	}

public ArrayList<DataFormBean> viewWebpage(String path,String name,int distance){
	
	ArrayList<DataFormBean> awf=null;
	int imageid=0;
	
	try{
		
		pstmt1=con.prepareStatement("select imageid from imagedata where imagename=?");
		
		pstmt1.setString(1, name);
		
	        rs1=pstmt1.executeQuery();
	       
	        
	        if(rs1.next()){
	        	
	        	imageid=rs1.getInt(1);
	        		        }
	
		pstmt=con.prepareStatement("select imageid,imagename,description,distance,image from imagedata where description like '%"+name+"%' and imageid = ? and distance < = ? order by distance desc");
		
		pstmt.setInt(1, imageid);
		pstmt.setInt(2, distance);
		rs=pstmt.executeQuery();
		
		awf=new ArrayList<DataFormBean>();
		 int i=0;
		while(rs.next()){
			i++;
			DataFormBean wf=new DataFormBean();
			imageid=rs.getInt(1);
			wf.setImageid(imageid);
			wf.setIname(rs.getString(2));
			wf.setQuery(rs.getString(2));
			wf.setDescription(rs.getString(3));
			wf.setDistance(rs.getInt(4));
			Blob b=rs.getBlob(5);
			byte[] b1=b.getBytes(1,(int)b.length());
			OutputStream fout=new FileOutputStream(path+"/"+imageid+".jpg");
			fout.write(b1);
			
			wf.setImage(imageid+".jpg");
			awf.add(wf);
			
		
		}
	            
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("jain>>>>>>>>>>>>>>>>>>>>>"+awf);
	return awf;
	
}
public ArrayList<DataFormBean> viewWebpage1(String path,String name,int distance){
	
	ArrayList<DataFormBean> awf=null;
	int imageid=0;
	
	try{
		
		pstmt1=con.prepareStatement("select imageid from imagedata1 where imagename=?");
		
		pstmt1.setString(1, name);
		
	        rs1=pstmt1.executeQuery();
	        
	        if(rs1.next()){
	        	
	        	imageid=rs1.getInt(1);
	        	
	        }
	        
	       
		pstmt=con.prepareStatement("select imageid,imagename,description,distance,image from imagedata1 where description like '%"+name+"%' and imageid = ? and distance < = ? order by distance desc");
		
		pstmt.setInt(1, imageid);
		pstmt.setInt(2,distance);
		rs=pstmt.executeQuery();
		
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			imageid=rs.getInt(1);
			wf.setImageid(imageid);
			wf.setIname(rs.getString(2));
			wf.setQuery(rs.getString(2));
			wf.setDescription(rs.getString(3));
			wf.setDistance(rs.getInt(4));
			Blob b=rs.getBlob(5);
			byte[] b1=b.getBytes(1,(int)b.length());
			OutputStream fout=new FileOutputStream(path+"/"+imageid+".jpg");
			fout.write(b1);
			
			wf.setImage(imageid+".jpg");
			awf.add(wf);
		
		}
	       
	     
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("jain1>>>>>>>>>>>>>>>>>>>>>"+awf);
	return awf;
	
}
public ArrayList<DataFormBean> viewWebpage2(String path,String name,int distance){
	
	ArrayList<DataFormBean> awf=null;
	int imageid=0;
	
	try{
		
		pstmt1=con.prepareStatement("select imageid from imagedata2 where imagename=?");
		
		pstmt1.setString(1, name);
		
	        rs1=pstmt1.executeQuery();
	        
	        if(rs1.next()){
	        	
	        	imageid=rs1.getInt(1);
	        	
	        }
	          
		pstmt=con.prepareStatement("select imageid,imagename,description,distance,image from imagedata2 where description like '%"+name+"%' and imageid = ? and distance < = ? order by distance desc");
		
		pstmt.setInt(1, imageid);
		pstmt.setInt(2,distance);
		rs=pstmt.executeQuery();
		
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			imageid=rs.getInt(1);
			wf.setImageid(imageid);
			wf.setIname(rs.getString(2));
			wf.setQuery(rs.getString(2));
			wf.setDescription(rs.getString(3));
			wf.setDistance(rs.getInt(4));
			Blob b=rs.getBlob(5);
			byte[] b1=b.getBytes(1,(int)b.length());
			OutputStream fout=new FileOutputStream(path+"/"+imageid+".jpg");
			fout.write(b1);
			
			wf.setImage(imageid+".jpg");
			awf.add(wf);
		
		}
	        
	        
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("jain2>>>>>>>>>>>>>>>>>>>>>"+awf);
	return awf;
	
}


public ArrayList<DataFormBean> viewWebpage3(String path,String name,int distance){
	
	ArrayList<DataFormBean> awf=null;
	int imageid=0;
	
	try{
		
		pstmt1=con.prepareStatement("select imageid from imagedata3 where imagename=?");
		
		pstmt1.setString(1, name);
		
	        rs1=pstmt1.executeQuery();
	        
	        if(rs1.next()){
	        	
	        	imageid=rs1.getInt(1);
	        	
	        }
	        
	       
		pstmt=con.prepareStatement("select imageid,imagename,description,distance,image from imagedata3 where description like '%"+name+"%' and imageid = ? and distance < = ? order by distance desc");
		
		pstmt.setInt(1, imageid);
		pstmt.setInt(2,distance);
		rs=pstmt.executeQuery();
		
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			imageid=rs.getInt(1);
			wf.setImageid(imageid);
			wf.setIname(rs.getString(2));
			wf.setQuery(rs.getString(2));
			wf.setDescription(rs.getString(3));
			wf.setDistance(rs.getInt(4));
				Blob b=rs.getBlob(5);
			byte[] b1=b.getBytes(1,(int)b.length());
			OutputStream fout=new FileOutputStream(path+"/"+imageid+".jpg");
			fout.write(b1);
			
			wf.setImage(imageid+".jpg");
			awf.add(wf);
		
		}
	        
	       
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("jain3>>>>>>>>>>>>>>>>>>>>>"+awf);
	return awf;
	
}



public ArrayList<DataFormBean> viewWebpage4(String path,String name,int distance){
	
	ArrayList<DataFormBean> awf=null;
	int imageid=0;
	
	try{
		
		pstmt1=con.prepareStatement("select imageid from imagedata4 where imagename=?");
		
		pstmt1.setString(1, name);
		
	        rs1=pstmt1.executeQuery();
	        
	        if(rs1.next()){
	        	
	        	imageid=rs1.getInt(1);
	        	
	        }
		       
	       
		pstmt=con.prepareStatement("select imageid,imagename,description,distance,image from imagedata4 where description like '%"+name+"%' and imageid = ? and distance < = ? order by distance desc");
		
		pstmt.setInt(1, imageid);
		pstmt.setInt(2,distance);
		rs=pstmt.executeQuery();
		
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			imageid=rs.getInt(1);
			wf.setImageid(imageid);
			wf.setIname(rs.getString(2));
			wf.setQuery(rs.getString(2));
			wf.setDescription(rs.getString(3));
			wf.setDistance(rs.getInt(4));
			Blob b=rs.getBlob(5);
			byte[] b1=b.getBytes(1,(int)b.length());
			OutputStream fout=new FileOutputStream(path+"/"+imageid+".jpg");
			fout.write(b1);
			
			wf.setImage(imageid+".jpg");
			awf.add(wf);
		
		}
	        
	       
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("jain4>>>>>>>>>>>>>>>>>>>>>"+awf);
	return awf;
	
}



public ArrayList<DataFormBean> getAllCatagery(){
	
	ArrayList<DataFormBean> awf=null;
	try{
		
		pstmt=con.prepareStatement("select unique imagename from imagedata");
			rs=pstmt.executeQuery();
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			
			wf.setIname(rs.getString(1));
				awf.add(wf);
			}
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return awf;
	
	
}


public String viewquery(DataFormBean dataFormBean){
	String obj=null;
	String ob=null;
	
	try{
		
		pstmt=con.prepareStatement("select unique query from indexdetails");
	
		rs=pstmt.executeQuery();
		//awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			//DataFormBean wf=new DataFormBean();
			
			//wf.setQuery(rs.getString(1));
			obj=rs.getString(1);
			
			if(obj.equalsIgnoreCase(dataFormBean.getQuery()))
			{
			ob=obj;
			}
			//awf.add(wf);
		System.out.println("object"+obj);
		System.out.println("object"+dataFormBean.getQuery());
		}
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return ob;
	
	
}
public ArrayList<DataFormBean> getAllTitles(){
	
	ArrayList<DataFormBean> awf=null;
	try{
		
		pstmt=con.prepareStatement("select unique imagename from imagedata");
		
		
		rs=pstmt.executeQuery();
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			
			wf.setIname(rs.getString(1));
			
			
			
			awf.add(wf);
		
		}
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return awf;
	
	
}


    public ArrayList<DataFormBean> retreveImageId(DataFormBean df) throws SQLException
    {
    	
    	ArrayList<DataFormBean> awf=null;
    	pstmt=con.prepareStatement("select imageid,imagename,dist from imagedata4 order by imageid ");
		
    	rs=pstmt.executeQuery();
		awf=new ArrayList<DataFormBean>();
		
		while(rs.next()){
			
			DataFormBean wf=new DataFormBean();
			System.out.println("--------"+rs.getInt(1));
	      wf.setImageid(rs.getInt(1));
	      System.out.println("--------"+rs.getString(2));
			
	      wf.setIname(rs.getString(2));
	      wf.setDist(rs.getInt(3));
			awf.add(wf);
		
		}
    	
     	return awf;
    	
    }	
    	

        public Vector retreveDistance(DataFormBean df) throws SQLException
        {
        	
        Vector<DataFormBean> awf=null;
        	pstmt=con.prepareStatement("select imageid,imagename,dist from imagedata4  ");
    		
        	rs=pstmt.executeQuery();
    		awf=new Vector<DataFormBean>();
    		
    		while(rs.next()){
    			
    			DataFormBean wf=new DataFormBean();
    			System.out.println("--------"+rs.getInt(1));
    	      wf.setImageid(rs.getInt(1));
    	      System.out.println("--------"+rs.getString(2));
    			
    	      wf.setIname(rs.getString(2));
    	      wf.setDist(rs.getInt(3));
    			awf.add(wf);
    		
    		}
        	return awf;
   }

}

