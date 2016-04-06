<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="/pages/common/common.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>上海宝冶集团汽车租赁管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="${path}/style/login/style/alogin.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/validate.css" rel="stylesheet" type="text/css" />
    <link href="${path}/js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerAccordion.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path}/js/validator.js"></script>
    <script type="text/javascript">
  	//页面加载完成时的事件  /VMSWEB/src/main/webapp/js/validator.js
  		$(function(){
			tip();
		});
  	
		//提示
		function tip(){
			var msg = '${request.msg}';
			var tipType = '${request.tipType}';
			if(msg==''||tipType==''){
			}else{
				if(tipType=='success'){
					$.ligerDialog.success(msg);
				}else if(tipType=='warn'){
					$.ligerDialog.warn(msg);
				}else if(tipType=='error'){
					$.ligerDialog.error(msg);
				}else{
				}
			}
		}
		
  		//登陆前验证 
		function login(){
			$("form :input.required").trigger('blur');    
			var numError = $("form .onError").length; 
			if(numError>0){     
				return false;  
			}else{
				$("#loginForm").submit();
			} 
		}
  		
  		//重置 
  		function doReset(){
  			$("#username").val('');
  			$("#password").val('');
			$(".formtips").remove();    
  		}
  		
		//键盘
		function handleEnter(event) {
			var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			if (keyCode == 13) {
				login();
			}
		}
    </script>
</head>
<body onkeydown="handleEnter(event)">
    <form id="loginForm" method="post" action="${path}/login/doLogin.html">
	    <div class="Main">
	        <ul>
	            <li class="top"></li>
	            <li class="top2"></li>
	            <li class="topA"></li>
	            <li class="topB">
	            	<span><img src="${path}/style/login/images/login/logo.gif" alt="" style="" /></span>
            	</li>
	            <li class="topC"></li>
	            <li class="topD">
	                <ul class="login">
	                	<li>
	                	<!-- 
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<span style="color:red">${request.msg}</span> -->	
	                    </li>
	                 	<li>
	                    	<span class="left">用户名：</span> 
	                    	<span style="left"><input id="username" name="user.name" type="text" class="required"/></span>
                    	</li>
	                    <li>
	                    	<span class="left">密 码：</span>
	                        <span style="left"><input id="password" name="user.password" type="password" class="required"/></span>
                        </li>
                    </ul>
	            </li>
	            <li class="topE"></li>	         
	            <li class="middle_A"></li>
	            <li class="middle_B"></li>	    
	            <li class="middle_C">
		    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    		<input id="register" type="button" value="" onclick="login()"/>
	    		 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		 	<input id="reset" type="reset" value="" onclick="doReset()"/>
	            </li>
	            <li class="middle_D"></li>
	            <li class="bottom_A"></li>
	            <li class="bottom_B">
	            	经纬科技&copy版权所有
	            </li>
	        </ul>
	    </div>
    <form>
</body>
</html>
