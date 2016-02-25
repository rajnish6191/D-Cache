  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" href="menu_style1.css" type="text/css" />
	 <script type="text/javascript" src="<%=request.getContextPath()+"/scripts/jquery.js"%>">
       </script>
	 <script type="text/javascript">
		$(document).ready(function () {
		$('.menu li').hover(
		function () {
		//show its submenu
		$('ul', this).slideDown(350);
		},
		function () {
		//hide its submenu
		$('ul', this).slideUp(350);
		}
		);
		});
    </script>
</head>
<body>
	
	<div class="menu" >
		<ul>
			<li><a href="./userhome.jsp" >Home</a></li>
			<li><a href="#" id="current">Upload Data In SubServer</a>
				<ul>
					<li><a href="./UploadWebpage.jsp"> Upload Data Server 1 </a></li>
					<li><a href="./UploadWebpage1.jsp">Upload Data Server 2 </a></li>
					<li><a href="./UploadWebpage2.jsp">Upload Data Server 3 </a></li>
					<li><a href="./UploadWebpage3.jsp">Upload Data Server 4 </a></li>
					<li><a href="./UploadWebpage4.jsp">Upload Data Server 5 </a></li>
					</ul>
		  </li>
			
			
			<li><a href="./#">UserSearchInfo</a>
			<ul>
                
                <li><a href="./SearchQueryAction">User Search Details</a></li>
                
               </ul>
			
			</li>
			
			
			<li><a href="./#">SearchInfo</a>
			<ul>
                
                <li><a href="./SearchIndexAction">Index Construction Time</a></li>
                <li><a href="./SearchMtreexAction">M-tree Construction Time</a></li>
                <li><a href="./SearchDcacheAction">D-Cache Searching Time</a></li>
                
               </ul>
			
			</li>
			
			<li><a href="./#">Graph</a>
			<ul>
                
                <li><a href="./SearchGraph"> Graph </a></li>
                
               </ul>
			
			</li>
			
			
			<li><a href="./#">UsersInfo</a>
			<ul>
                
                <li><a href="./ViewUsersAction">ViewCustomers</a></li>
                
               </ul>
			
			</li>
			
			
			
			<li><a href="#">Security</a>
			<ul>
                <li><a href="./Changepassword.jsp">ChangePassword</a></li>
                
               </ul>
			
			</li>
			<li><a href="./LogoutAction">Logout</a>
			
			
			</li>
		</ul>
	</div>

</body>
</html>
