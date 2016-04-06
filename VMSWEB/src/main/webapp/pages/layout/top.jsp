<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="/pages/common/common.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>上海宝冶集团汽车租赁管理系统</title>
    <link href="${path}/style/login/style/alogin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${path}/js/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${path}/js/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="${path}/js/jquery-easyui-1.3.1/themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="${path}/js/jquery-easyui-1.3.1/themes/icon.css" type="text/css"></link>
    <script type="text/javascript"> 
    	//退出系统 
    	function loginOut(){
   			jQuery.messager.confirm('提示:','确认退出？',function(event){   
   	    		if(event){   
   	    			window.parent.location.href = "${path}/login/loginOut.html"; 
   	    		}  
	    	});  
	   	}
	</script>	
</head>
<body>
	<div style="text-align:right;">
		<b>
		欢迎<span style="color:red;">${session.nickname}</span>登陆系统&nbsp;&nbsp;
		<a href="javascript:void(0)" onclick="loginOut();">安全退出</a>
		</b>
	</div>
</body>
</html>
