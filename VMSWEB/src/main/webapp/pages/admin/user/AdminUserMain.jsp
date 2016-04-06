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
	<script src="${path}/js/pager.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${path}/js/validator.js"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<script type="text/javascript">
		//删除
		function doDel(userid){
			$.ligerDialog.confirm('确定删除？', 
				function (yes){
					if(yes){
						window.parent.frames["browerFrame"].location.href = "${path}/admin/user/doDel.html?userid="+userid;
					}
				}
			);
		}
		
		//密码重置 
		function pwdReset(userid){
			$.ligerDialog.confirm('确定重置密码？', 
					function (yes){
						if(yes){
							$.ajax({
					 			url:"${path}/admin/user/resetPwd.html", 
					 			type:"post",
					 			dataType:"json",
					 			data:"userid="+userid, 
					 			success:function(data){
					 				if(data.success){
					 					$.ligerDialog.success('密码重置成功！');  
		 							}else{
		 								$.ligerDialog.error('密码重置失败！'); 
					 				}
					 			},
					 			error:function(){
					 				$.ligerDialog.error('出错！');  
					 			}
					 		});
						}
					}
				);
		}
		
	  	function search_reset(){
	  		$('#search_name').val('');
	  		$('#search_nickname').val('');
	  		$('#search_dept').val('');
	  		$('#search_company').val('');
	  		$('#search_phonenumber').val('');
	  		$('#search_email').val('');
	  		var isZongGongsi = '${request.isZongGongsi}';
	  		if(isZongGongsi=='yes'){
	  			$('#search_company').val('default');
	  		}
	  	}
	  	
	  	function validateName(){
			var name = $("#name").val();
			if(name==''){
				$.ligerDialog.warn("用户名不能为空！"); 
			}else{
				$.ajax({
		 			url:"${path}/admin/user/isUserExists.html",
		 			type:"post",
		 			dataType:"json",
		 			data:"name="+name,
		 			success:function(data){
		 				if(data.success){
		 					$.ligerDialog.warn("用户名已经存在，换一个名吧！"); 
		 					//$('#name').focus();
		 					$("#name").val('');
		 				}else{
		 					
		 				}
		 			},
		 			error:function(){
		 				$.ligerDialog.error("查询出错！");  
		 			}
		 		});
			}
		}	
	  	
	  //增加管理员 
	  	function add(){
	  		$(".formtips").remove();    
	  		$.ligerDialog.open({
					title : "增加管理员",
					target : $("#add"),
					width : 500,
					height : 220,
					buttons : [ {
						text : '提交',
						onclick : function(item, d) {
							$("#addForm :input.required").trigger('blur');    
							var numError = $("form .onError").length; 
							if(numError>0){     
								return false;  
							}else{
								$('#addForm').submit();
							}
				  			d.close();
						}
					},{
						text : '重置',
						onclick : function(item, d) {
							$('#username').val('');
							$('#nickname').val('');
							$('#email').val('');
							$('#phonenumber').val('');
							$('#dept').val('');
							$(".formtips").remove();    
						}
					}]
			});
	  	}
   	</script>
</head>
<body>
	<div>
		<span style="color:blue">当前位置：系统管理员-用户信息</span>
		<a href="javascript:void(0)" style="font-size: 10px"onclick="add()">增加</a>
	</div>
	<!-- 搜索栏 -->
	<div style="font-size: 10px">
		<fieldset style="border:1px dashed blue" >
			<legend><a href="javascript:void(0)" onclick="showAndHide()"><b>快速查询</b></a></legend>
			<div id="search">
			<form id="searchForm" action="${path}/admin/user/goMain.html" method="post">
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
   	 				<td style="text-align: right;">用户名称：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.name" id="search_name"/></td>
   	 				<td style="text-align: right;">用户昵称：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.nickname" id="search_nickname"/></td>
   	 				<td style="text-align: right;">部门：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.dept" id="search_dept"/></td>
   	 				<c:choose>
	   	 				<c:when test="${'yes'==request.isZongGongsi}">
	       	      			<td style="text-align: right;">所属公司：</td>
		   	 				<td style="text-align: left;">
		   	 				<s:select list="companies" style="width:135px" name="search.company" id="search_company"
		   								listKey="company_id" listValue="company_name" headerKey="default" headerValue="-----请选择子公司-----"></s:select>
		   	 				</td>
	       	      		</c:when>
	     	      		<c:otherwise>
	     	      			<td></td>
	   	 					<td></td>
	     	      		</c:otherwise>
     	      		</c:choose>
   	 				<td></td>
   	 				<td></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">手机号码：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.phonenumber" id="search_phonenumber"/></td>
   	 				<td style="text-align: right;">邮箱：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.email" id="search_email"/></td>
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
	   		<col width="13%""/>
	   		<col width="13%""/>
	   		<col width="13%""/>
	   		<col width="13%""/>
	   		<col width="16%""/>
	   		<col width="16%""/>
	   		<col width="16%""/>
			<thead>
				<tr>
		            <th style="text-align: center">用户名称</th>
		            <th style="text-align: center">用户昵称</th>
		            <th style="text-align: center">邮箱</th>
		            <th style="text-align: center">手机号码</th>
		            <th style="text-align: center">部门</th>
		            <th style="text-align: center">所属公司</th>
		            <th style="text-align: center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="users" status="s">
					<tr>
						<td style="text-align: center"><s:property value="name"/></td>
						<td style="text-align: center"><s:property value="nickname"/></td>
						<td style="text-align: center"><s:property value="email"/></td>
						<td style="text-align: center"><s:property value="phonenumber"/></td>
						<td style="text-align: center"><s:property value="dept"/></td>
						<td style="text-align: center"><s:property value="companyName"/></td>
						<td style="text-align: center">
							 <a href="javascript:void(0)" onclick="doDel('${userid}');" >删除</a>
							 <a href="javascript:void(0)" onclick="pwdReset('${userid}');" >重置密码</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>	

	<!-- 分页 -->
	<jsp:include page="/pages/pager.jsp"></jsp:include>
	
	<!--增加 -->
	<div id="add" style="display: none">
		<form id="addForm" action="${path}/admin/user/doAdd.html" method="post">
			<table style="width: 90%;margin-left:5%;" class="gridtable">
				<col style="width: 30%;" />
				<col style="width: 70%;"/>
   	 			<tr>
   	 				<td style="text-align: right;">用户名：</td>
   	 				<td style="text-align: left;"><input type="text" id="username" name="user.name" class="required" onblur="validateName();"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">用户昵称：</td>
   	 				<td style="text-align: left;"><input type="text" id="nickname" name="user.nickname" class="required"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">邮箱：</td>
   	 				<td style="text-align: left;"><input type="text" id="email" name="user.email" class="required"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">手机号码：</td>
   	 				<td style="text-align: left;"><input type="text" id="phonenumber" name="user.phonenumber" class="required"/></td>
   	 			</tr>
   	 			<tr>
   	 				
   	 				<td style="text-align: right;">部门：</td>
   	 				<td style="text-align: left;"><input type="text" id="dept" name="user.dept" class="required"/></td>
   	 			</tr>
   	 		</table>
		</form>
	</div>
</body>
</html>
