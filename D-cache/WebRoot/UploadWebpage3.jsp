<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 
 <script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>"></script>
 
 </head>
  
  <body>
            
           
          
          <jsp:include page="Header.jsp"></jsp:include>
          
          
		<form action="./UploadDataAction3" name="content">
		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#D8BFD8"><font color="#F5FFFA" size="5"><i>Server 4 Upload Content</i></font> </tr>
    <caption><font color="#708090"><i><b>Upload Image Here</b></i> </font>  </caption>
    <tr>
    <br/>
     
      
     
     
                <tr>
    <td width="128"><span class="style17"><font color="#228B22" size="4">Image Name</font> </span></td>
    <td width="269"><label>
    <input type="text" name="iname">
      </label></td>
     </tr>              <tr>
                             <td width="128"><span class="style17"><font color="#228B22" size="4">Image Description</font> </span></td>
                                <td width="269"><label>
                                
                                <textarea rows="5" cols="30" name="description"></textarea>
                           
                            
                                </label></td>
                              </tr>
                              
                            
                              <tr>
    <td width="128"><span class="style17"><font color="#228B22" size="4">Distance</font> </span></td>
    <td width="269"><label>
    <input type="text" name="distance">
      </label></td>
     </tr>
                              
                              
                              <tr>
                                <td><span class="style17"><font color="#228B22" size="4">Image</font></span></td>
                                <td>
                                 
                         
                                <input type="file" name="image"  />
                                     
                                    
                                    
                                </td>
                              </tr>
                           
                           
                              <br/>
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="UpLoad">
                              </td></tr>
    </table>
    
    
    
<br/>
			
                 
    </form>
    
    
     
          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("content");

     frmvalidator.addValidation("cname","req","Content Title is required");
     
     frmvalidator.addValidation("color","req","Color is required");
    
    frmvalidator.addValidation("company","req","company is required");
    
    frmvalidator.addValidation("description","req","Description Name is required");
   
    frmvalidator.addValidation("ccode","req","ccode is required");
    frmvalidator.addValidation("price","req","price is required");
    frmvalidator.addValidation("price","numeric");
    
    
  </script>
 
    <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
