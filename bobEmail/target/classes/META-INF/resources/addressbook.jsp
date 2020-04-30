<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>我的通讯录</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>

<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
function del(friendsid,userid,obj){
	//var b=document.getElementById('ti').value
	var del=window.confirm("您确定要删除吗？");
	if(del){
	$.ajax({
	type:"POST",
	url:'${pageContext.request.contextPath}/userController/deletefirends.do',
	data:{'friendsid':friendsid,
		  'userid':userid},
	dataType:'text',
	success:function(){	
		  //window.location.reload();//删除无刷新    重要	
		  alert("成功拉");
		  //window.location.href="${pageContext.request.contextPath}/emailController/outbox.do?senderid=${User.id}";
		  var tr=obj.parentNode.parentNode;
			var tbody=tr.parentNode;
			tbody.removeChild(tr);
	},
	error:function(){
		//$(id).parent().parent().remove();
		 // window.location.reload();//删除无刷新    重要
		 alert("你去哪拉");
		var tr=obj.parentNode.parentNode;
		var tbody=tr.parentNode;
		tbody.removeChild(tr);	
	}
	});
	}
	}


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
     
      <li><a href="login.jsp" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">退出</span></a></li>
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
          <li><a href="${pageContext.request.contextPath}/emailController/inbox.do?recvid=${User.id}"><span class="am-icon-th"></span>收件箱<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
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
          <li><a href="${pageContext.request.contextPath}/userController/alluser.do?userid=${User.id}&depid=${User.deparmentid}"><span class="am-icon-th"></span>邮件群发<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
          <li><a href="${pageContext.request.contextPath}/emailController/groupemail.do?userid=${User.id}"><span class="am-icon-th"></span>群发邮件回复汇检<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
        </ul>
      </li>
          <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-file"></span>系统管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav4">
          <li><a href="${pageContext.request.contextPath}/userController/checkdepartment.do?userrole=${User.isadmin}"><span class="am-icon-th"></span>查看编辑部门<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
          <li><a href="insertdepartment.jsp"><span class="am-icon-th"></span>添加部门<span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
          <li><a href="${pageContext.request.contextPath}/userController/checkuser.do?userrole=${User.isadmin}"><span class="am-icon-th"></span>查看修改用户<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
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

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">通讯录</strong> / <small>Table</small></div>
    </div>


    

    <div class="am-g">
      <div class="am-u-sm-12">
      
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-type">姓名</th><th class="table-title">性别</th><th class="table-type">邮箱</th><th class="table-date">电话</th><th class="table-set">添加时间</th><th class="table-set">部门</th><th class="table-set">职位</th><th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
         <!--  foreach循环 -->
         	<c:forEach items="${friends }" var="inlist" >
            <tr>
              <td><a href="#">${inlist.truename}</a></td>
              <td>${inlist.sex}</td>
              <td>${inlist.email}</td>
              <td>${inlist.tel}</td>
              <td>${inlist.addtime}</td>
              <td>${inlist.depname}</td>
              <td>${inlist.deprole}</td>
             <td>
     <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger" onclick="del(${inlist.id},${User.id},this);"><span class="am-icon-trash-o"></span> 删除</button>
   <a href="${pageContext.request.contextPath}/userController/tiaozhuan.do?email=${inlist.email}" target="_Self">发送邮件</a>
              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
          <div class="am-cf">
  共 15 条记录
  <div class="am-fr">
    <ul class="am-pagination">
      <li class="am-disabled"><a href="#">«</a></li>
      <li class="am-active"><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">»</a></li>
    </ul>
  </div>
</div>
          <hr />
          <p>注：.....</p>
        </form>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>

<footer>
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
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>
