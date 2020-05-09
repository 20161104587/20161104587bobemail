<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>新邮件</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
   <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
   <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"> </script>
   <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    
</head>
<body>

<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	  submitsave = function(){
			alert("发送成功");
	        document.getElementById('body').innerHTML=UE.getEditor('editor').getContent();
	        alert("成功啦");
	        $("#loginForm1").attr("action", "${pageContext.request.contextPath}/emailController/send.do?type=save");
	        $("#loginForm1").submit();
	  }
	  submitdraft = function(){
			alert("存为草稿");
	        document.getElementById('body').innerHTML=UE.getEditor('editor').getContent();
	        alert("保存成功");
	        $("#loginForm1").attr("action", "${pageContext.request.contextPath}/emailController/send.do?type=draft");
	        $("#loginForm1").submit();
	  }
	  
	});

   </script>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>Bobemail</strong> <small>企业内部邮箱管理系统</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

 <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
     <li><a href="javascript:;">当前用户：  ${User.truename}</a></li>
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li><a href="${pageContext.request.contextPath}/userController/quit.do" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">退出</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="${pageContext.request.contextPath}/userController/readflag.do?id=${User.id}"><span class="am-icon-home"></span> 首页</a></li>

      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 邮件操作 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
          <li><a href="sendEmail.jsp" class="am-cf"><span class="am-icon-check"></span>新邮件</a></li>
          <li><a href="${pageContext.request.contextPath}/emailController/outbox.do?senderid=${User.id}"><span class="am-icon-puzzle-piece"></span>发件箱</a></li>
          <li><a href="${pageContext.request.contextPath}/emailController/inbox.do?recvid=${User.id}"><span class="am-icon-th"></span>收件箱<span class="am-badge am-badge-secondary am-margin-right am-fr">${countread}</span></a></li>
          <li><a href="${pageContext.request.contextPath}/emailController/draft.do?userid=${User.id}"><span class="am-icon-calendar"></span>草稿箱</a></li>
          <li><a href="${pageContext.request.contextPath}/emailController/selectdustbin.do?userid=${User.id}"><span class="am-icon-bug"></span> 垃圾箱</a></li>
        </ul>
      </li>
      
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-file"></span> 通讯录 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
          <li><a href="${pageContext.request.contextPath}/userController/addressbook.do?userid=${User.id}" class="am-cf"><span class="am-icon-check"></span>我的通讯录</a></li>
          <li><a href="insertaddressbook.jsp"><span class="am-icon-puzzle-piece"></span>添加通讯录</a></li>
        </ul>
      </li>
       <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-file"></span>邮件群发操作 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="${pageContext.request.contextPath}/userController/alluser.do?userid=${User.id}&depid=${User.deparmentid}"><span class="am-icon-th"></span>邮件群发<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
          <li><a href="${pageContext.request.contextPath}/emailController/groupemail.do?userid=${User.id}"><span class="am-icon-th"></span>群发邮件回复汇检<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
        </ul>
      </li>
          <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-file"></span>系统管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav4">
          <li><a href="${pageContext.request.contextPath}/userController/checkdepartment.do?userrole=${User.isadmin}"><span class="am-icon-th"></span>查看编辑部门<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
          <li><a href="insertdepartment.jsp"><span class="am-icon-th"></span>添加部门<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
          <li><a href="${pageContext.request.contextPath}/userController/checkuser.do?userrole=${User.isadmin}"><span class="am-icon-th"></span>查看修改用户<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
          <li><a href="insertpeople.jsp"><span class="am-icon-th"></span>添加用户<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
        </ul>
      </li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="admin-user.jsp" class="am-cf"><span class="am-icon-check"></span> 修改密码<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>  
        </ul>
      </li>
      <li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>
  </div>
  <!-- sidebar end -->

  <!-- 发送邮件 -->
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">发送邮件</strong> / <small>Personal information</small></div>
    </div>

    <hr/>

   <div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li><a href="#tab2">写邮件</a></li>
    </ul>

    <div class="am-tabs-bd">
      
      <div class="am-tab-panel am-fade" id="tab2">
      
      
      
      
        <form action=""  method="post" id="loginForm1" enctype="multipart/form-data" ><!-- action中写url地址 -->
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              邮件主题
            </div>
            <div class="am-u-sm-4">
              <input type="text" class="am-input-sm" name="title">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              收件人
            </div>
            <div class="am-u-sm-4 col-end">
              <input type="email" class="am-input-sm" name="accept" value="${email }">
            </div>
             <div class="am-u-sm-6">*必填，不可重复</div>
          </div>



          <div class="am-g am-margin-top-sm">
            <div class="am-u-sm-2 am-text-right">
              正文
            </div>
            <div class="am-u-sm-10">
             <textarea  id="body" name="body" style="display: none"></textarea>
              <script id="editor" type="text/plain" style="width:800px;height:500px;"></script>
            </div>
          </div>
          
      <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              附件
            </div>
            <div class="am-u-sm-4 col-end">
              <input type="file" class="am-input-sm" name="file">
            </div>
          </div>
          
              <input type="hidden"  name="senderid" value="${User.id}">

        </form>
      </div>

    </div>
  </div>
   <div class="am-margin">
      <button type="button"  class="am-btn am-btn-primary am-btn-xs" onclick="submitdraft();" >存入草稿</button>
      <button type="button"  class="am-btn am-btn-primary am-btn-xs" onclick="submitsave();">提交保存</button>
   
  </div>
</div>
<!-- content end -->

</div>
  <hr>
  
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script type="text/javascript"> 
//实例化编辑器 
var ue = UE.getEditor('editor'); 
</script> 

<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>
</html>
