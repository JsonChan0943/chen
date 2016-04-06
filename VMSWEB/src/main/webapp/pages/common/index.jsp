<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<jsp:include page="/pages/common/common.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>宝冶汽车租赁管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="${path}/js/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="${path}/js/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="${path}/js/jquery-easyui-1.3.1/themes/default/easyui.css" type="text/css"></link>
		<link rel="stylesheet" href="${path}/js/jquery-easyui-1.3.1/themes/icon.css" type="text/css"></link>
  	</head>
	<body class="easyui-layout">
		<div data-options="region:'north'" style="height:60px;">北</div>
		<div data-options="region:'south'" style="height:20px;">南</div>
		<div data-options="region:'west'" style="width:200px;">西</div>
		<div data-options="region:'center',title:'欢迎使用SSHE示例系统'" style="overflow: hidden;">中</div>
	</body>
</html>
