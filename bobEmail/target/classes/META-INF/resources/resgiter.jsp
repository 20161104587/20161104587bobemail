<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>注册用户</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Slide Login Form template Responsive, Login form web template, Flat Pricing tables, Flat Drop downs Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
	 <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
        
        function checkEmail() {
     	 $.ajax({
     		type:"POST",
     		url:'${pageContext.request.contextPath}/userController/checkresemail.do',
     		data:{
     			'email':$("#cemail").val(),
     			},
     		dataType : 'text',
     		success:function(data){	
     	
     			  //window.location.reload();//删除无刷新    重要	
     			  if(data==1){
     			  $('#checkemail').html("<font color='green'>用户名合法</font>");
     			  }else if(data == 2){
     				 $('#checkemail').html("<font color='red'>用户名存在</font>");
					//document.getElementById("spanid").innerText="输入框不能为空!";
				}
     			  //window.location.href="${pageContext.request.contextPath}/emailController/outbox.do?senderid=${User.id}";
     		},
     		error:function(data){
     		}
     		});
        }
    </script>
    

	<!-- Custom Theme files -->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->

	<!-- web font -->
	<link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
	<!-- //web font -->

</head>
<style>
input{  
border:none;
  
  box-radius:25%;
  outline:medium;
r;
  }

</style>

<body>

<!-- main -->
<div class="w3layouts-main"> 
	<div class="bg-layer">
		<h1>企业内部邮箱管理系统</h1>
		<div class="header-main">
			<div class="main-icon">
				<span class="fa fa-eercast"></span>
			</div>
			<div class="header-left-bottom">
			
			
				<form action="${pageContext.request.contextPath}/userController/resgiter.do" method="post">
					<div class="icon1">
						<span class="fa fa-user"></span>
						<input type="email" placeholder="Email Address"  name="email"  id="cemail" onblur="checkEmail()" />
						<span id="checkemail"></span>
					</div>
					<div class="icon1">
						<span class="fa fa-user"></span>
						<input type="text" placeholder="True name"  name="truename" />
					</div>
					
					<div class="icon1">
						<span class="fa fa-lock"></span>
						<input type="password" placeholder="Password" required="" name="pwd"/>
					</div>
					<div class="login-check">
							<input  type="radio" checked ="checked" name="sex" value="男" ><font color="white">男 </font>
							<input  type="radio"  name="sex" value="女"><font color="white">女 </font>
					</div>
					<div class="icon1">
						<span class="fa fa-user"></span>
						<input type="text" placeholder="Phone" required="" name="tel"/>
					</div>
					
				    <div class="icon1">
					<span class="fa fa-user"></span>
						<input type="text" placeholder="Your departmentid " required="" name="deparmentid"/>
					</div>
		
					<div class="bottom">
						<button class="btn">注册</button>
					</div>
					<div class="links">
						<p class="right"><a href="login.jsp">已注册？去登录</a></p>
						<div class="clear"></div>
					</div>
				</form>	
			</div>
			
		</div>
		
		<!-- copyright -->
		<div class="copyright">
			
		</div>
		<!-- //copyright --> 
	</div>
</div>	
<!-- //main -->

</body>
</html>