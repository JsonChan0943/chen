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
	<link rel="stylesheet" type="text/css" href="${path}/js/ligerUI/skins/Aqua/css/ligerui-all.css" />
	<link rel="stylesheet" type="text/css" href="${path}/css/pager.css" />
	<script src="${path}/js/pager.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<script type="text/javascript">
	  	function search_reset(){
	  		$('#search_operate_type').val('default');
	  	}
	  	
   	</script>
</head>
<body>
	<div>
		<span style="color:blue">当前位置：超级管理员-业务日志信息</span>
	</div>
	<!-- 搜索栏 -->
	<div style="font-size: 10px">
		<fieldset style="border:1px dashed blue" >
			<legend><a href="javascript:void(0)" onclick="showAndHide()"><b>快速查询</b></a></legend>
			<div id="search">
			<form id="searchForm" action="${path}/super/log/goMain.html" method="post">
			<input type="hidden" name="pageModel.toPage" id="toPage"></input>
			<table>
				<col width="6%""/>
		   		<col width="14%""/>
		   		<col width="6%""/>
		   		<col width="14%""/>
		   		<col width="6%""/>
		   		<col width="14%""/>
		   		<col width="6%""/>
		   		<col width="14%""/>
		   		<col width="6%""/>
		   		<col width="14%""/>
				<tr>
   	 				<td></td>
   	 				<td style="text-align: right;">操作类型：</td>
   	 				<td style="text-align: left;">
   	 					<s:select list="operateTypies" style="width:135px" name="search.operate_type" id="search_operate_type"
   								listKey="enValue" listValue="enName" headerKey="default" headerValue="---请选择操作类型---"></s:select>
   	 				</td>
   	 				<td></td>
   	 				<td></td>
   	 				<td></td>
   	 				<td></td>
   	 				<td></td>
   	 				<td><input type="submit" style="width:100px;"value="查询"></input></td>
   	 				<td><input type="button" onclick="search_reset()" style="width:100px;" value="重置"></input></td>
   	 			</tr>
			</table>
		</form>
		</div>
	</fieldset>
	</div>
	</br>
	<!-- 列表区 -->
	<div>
	   	<table border="1" style="width:1150px;" class="gridtable">
	   		<col width="15%""/>
	   		<col width="15%""/>
	   		<col width="60%""/>
	   		<col width="10%""/>
			<thead>
				<tr>
		            <th style="text-align: center">操作人</th>
		            <th style="text-align: center">操作时间</th>
		            <th style="text-align: center">操作内容</th>
		            <th style="text-align: center">操作类型</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="logs" status="s">
					<tr>
						<td style="text-align: center"><s:property value="operator"/></td>
						<td style="text-align: center"><s:property value="operate_timeString"/></td>
						<td style="text-align: center"><s:property value="operate_content"/></td>
						<td style="text-align: center"><s:property value="operate_typeString"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>	

	<!-- 分页 -->
	<jsp:include page="/pages/pager.jsp"></jsp:include>
</body>
</html>
