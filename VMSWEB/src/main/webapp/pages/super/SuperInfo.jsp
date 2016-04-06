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
 	<link href="${path}/css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${path}/js/validator.js"></script>
	<script src="${path}/js/pager.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
   	<script type="text/javascript">
	  //页面加载完成时的事件 
		  $(function(){
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
				return;
		  });
	  	//修改我的信息 
   		function edit(userid,name,nickname,email,phonenumber){
   			$('#userid').val(userid);
			$('#username').val(name);
			$('#nickname').val(nickname);
			$('#email').val(email);
			$('#phonenumber').val(phonenumber);
   			$.ligerDialog.open({
				title : "修改我的信息", 
				target : $("#edit"),
				width : 500,
				height : 220,
				buttons : [ {
					text : '提交',
					onclick : function(item, d) {
						$("form :input.required").trigger('blur');    
						var numError = $("form .onError").length; 
						if(numError>0){     
							return false;  
						}else{
							$('#editForm').submit();
						}
						d.close();
					}
				},{
					text : '重置',
					onclick : function(item, d) {
						$('#nickname').val('');
						$('#email').val('');
						$('#phonenumber').val('');
						$(".formtips").remove();    
					}
				}]
			});
   		}
   	</script>
</head>
<body>
	<span style="color:blue"> 当前位置：超级管理员-我的信息</span>
	<!-- 列表区 -->
	<div>
	   	<table border="1" style="width:1150px;" class="gridtable">
	   		<col width="12%""/>
	   		<col width="12%""/>
	   		<col width="12%""/>
	   		<col width="12%""/>
	   		<col width="12%""/>
	   		<col width="12%""/>
	   		<col width="12%""/>
	   		<col width="16%""/>
			<thead>
				<tr>
		            <th style="text-align: center">用户名称</th>
		            <th style="text-align: center">用户昵称</th>
		            <th style="text-align: center">邮箱</th>
		            <th style="text-align: center">手机号码</th>
		            <th style="text-align: center">部门</th>
		            <th style="text-align: center">公司</th>
		            <th style="text-align: center">角色</th>
		            <th style="text-align: center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="list" status="s">
					<tr>
						<td style="text-align: center"><s:property value="name"/></td>
						<td style="text-align: center"><s:property value="nickname"/></td>
						<td style="text-align: center"><s:property value="email"/></td>
						<td style="text-align: center"><s:property value="phonenumber"/></td>
						<td style="text-align: center"><s:property value="dept"/></td>
						<td style="text-align: center"><s:property value="companyName"/></td>
						<td style="text-align: center"><s:property value="roleName"/></td>
						<td style="text-align: center">
							 <a href="javascript:void(0)" 
							 onclick="edit('${userid}','${name}','${nickname}','${email}','${phonenumber}');" >修改我的信息</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>	
   	<!--edit -->
	<div id="edit" style="display:none">
	<br/>
		<form id="editForm" action="${path}/super/mine/myInfoEdit.html" method="post">
			<table style="width: 90%;margin-left:5%;" class="gridtable">
				<col style="width: 30%;" />
				<col style="width: 70%;"/>
				<tr>
					<input type="hidden" id="userid" name="user.userid"></input>
					<td style="text-align: right">用户名：</td>
					<td style="text-align: left"><input name="user.name" id="username" readonly="true"/></td>
				</tr>
				<tr>
					<td style="text-align: right">用户昵称：</td>
					<td style="text-align: left"><input type="text" name="user.nickname" class="required" id="nickname"/></td>
				</tr>
				<tr>
					<td style="text-align: right">邮箱：</td>
					<td style="text-align: left"><input type="text" name="user.email" class="required" id="email"/></td>
				</tr>
				<tr>
					<td style="text-align: right">手机号码：</td>
					<td style="text-align: left"><input type="text" name="user.phonenumber" class="required" id="phonenumber"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
