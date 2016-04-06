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
		//修改 
	  	function doEdit(company_id,company_name,address,telephone,manager){
			$('#edit_company_id').val(company_id);
			$('#edit_company_name').val(company_name);
			$('#edit_address').val(address);
			$('#edit_telephone').val(telephone);
			$('#edit_manager').val(manager);
			$.ligerDialog.open({
				title : "修改子公司信息",
				target : $("#edit"),
				width : 500,
				height : 220,
				buttons : [ {
					text : '提交',
					onclick : function(item, d) {
							$("#editForm :input.required").trigger('blur');    
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
						$('#edit_company_name').val('');
						$('#edit_address').val('');
						$('#edit_telephone').val('');
						$('#edit_manager').val('');
						$(".formtips").remove(); 
					}
				}]
		});
	    }
		
		//删除
		function doDel(company_id){
			$.ligerDialog.confirm('确定删除？', 
				function (yes){
					if(yes){
						window.parent.frames["browerFrame"].location.href = "${path}/super/company/doDel.html?company_id="+company_id;
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
	  	}
	  	
	  	//增加子公司
	  	function add(){
	  		$.ligerDialog.open({
					title : "增加子公司信息",
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
							$('#company_id').val('');
							$('#company_name').val('');
							$('#address').val('');
							$('#telephone').val('');
							$('#manager').val('');
							$(".formtips").remove();   
						}
					}]
			});
	  	}
	  	
		function validateID(){
			var company_id = $("#company_id").val();
			if(company_id!=''){
				$.ajax({
		 			url:"${path}/super/company/isCompanyIdExists.html",
		 			type:"post",
		 			dataType:"json",
		 			data:"company_id="+company_id,
		 			success:function(data){
		 				if(data.success){
		 					$.ligerDialog.warn("用公司id已经存在，换一个id吧！"); 
		 					$("#company_id").val('');
		 				}else{
		 					
		 				}
		 			},
		 			error:function(){
		 				$.ligerDialog.error("查询出错！");  
		 			}
		 		});
			}
		}
		
		//上传文件 
	  	function fileUpLoad(){
			//<a href="javascript:void(0)" style="font-size: 10px"onclick="fileUpLoad()">上传文件</a> 
	  		$.ligerDialog.open({
				title : "上传文件 ",
				target : $("#fileUpLoad"),
				width : 500,
				height : 150,
				buttons : [ {
					text : '提交',
					onclick : function(item, d) {
						$("#fileUpLoadForm").submit();
					}
				}]
			});
	  	}
		
		//导出子公司信息 
	  	function exportCompines(){
	  		$.ligerDialog.confirm('确定导出子公司信息列表？',   
				function (yes){
					if(yes){
						window.location.href = "${path}/super/company/doReport.html";
					}
				}
			);
	  	}
   	</script>
</head>
<body>
	<div>
		<span style="color:blue">当前位置：超级管理员-公司信息</span>
		<a href="javascript:void(0)" style="font-size: 10px"onclick="add()">增加</a>&nbsp;&nbsp; 
		<a href="javascript:void(0)" style="font-size: 10px"onclick="exportCompines()">导出子公司信息
	</div>
	<!-- 搜索栏 -->
	<div style="font-size: 10px">
		<fieldset style="border:1px dashed blue" >
			<legend><a href="javascript:void(0)" onclick="showAndHide()"><b>快速查询</b></a></legend>
			<div id="search">
			<form id="searchForm" action="${path}/super/company/goMain.html" method="post">
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
   	 				<td style="text-align: right;">公司名字：</td>
   	 				<td style="text-align: left;"><input type="text" id="search_name" name="search.company_name"/></td>
   	 				<td style="text-align: right;">公司地址：</td>
   	 				<td style="text-align: left;"><input type="text" id="search_nickname" name="search.address"/></td>
   	 				<td style="text-align: right;">公司电话：</td>
   	 				<td style="text-align: left;"><input type="text" id="search_dept" name="search.telephone"/></td>
   	 				<td style="text-align: right;">总经理：</td>
   	 				<td style="text-align: left;"><input type="text" id="search_company" name="search.manager"/></td>
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
	   		<col width="15%""/>
	   		<col width="15%""/>
	   		<col width="15%""/>
	   		<col width="25%""/>
			<thead>
				<tr>
		            <th style="text-align: center">公司ID</th>
		            <th style="text-align: center">公司名字</th>
		            <th style="text-align: center">公司地址</th>
		            <th style="text-align: center">公司电话</th>
		            <th style="text-align: center">总经理</th>
		            <th style="text-align: center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="companies" status="s">
					<tr>
						<td style="text-align: center"><s:property value="company_id"/></td>
						<td style="text-align: center"><s:property value="company_name"/></td>
						<td style="text-align: center"><s:property value="address"/></td>
						<td style="text-align: center"><s:property value="telephone"/></td>
						<td style="text-align: center"><s:property value="manager"/></td>
						<td style="text-align: center">
							 <a href="javascript:void(0)" onclick="doDel('${company_id}');" >删除</a>
							 <a href="javascript:void(0)" onclick="doEdit('${company_id}','${company_name}','${address}','${telephone}','${manager}');" >修改</a>
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
		<form id="addForm" action="${path}/super/company/doAdd.html" method="post">
			<table style="width: 90%;margin-left:5%;" class="gridtable">
				<col style="width: 30%;" />
				<col style="width: 70%;"/>
   	 			<tr>
   	 				<td style="text-align: right;">公司ID：</td>
   	 				<td style="text-align: left;">
   	 					<input type="text" id="company_id" name="company.company_id" class="required" onblur="validateID();"/>
 	 				</td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">公司名称：</td>
   	 				<td style="text-align: left;"><input type="text" id="company_name" class="required" name="company.company_name"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">公司地址：</td>
   	 				<td style="text-align: left;"><input type="text" id="address" class="required" name="company.address"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">公司电话：</td>
   	 				<td style="text-align: left;"><input type="text" id="phonenumber" class="required" name="company.telephone"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">总经理：</td>
   	 				<td style="text-align: left;"><input type="text" id="manager" class="required" name="company.manager"/></td>
   	 			</tr>
   	 		</table>
		</form>
	</div>
	
	<!--修改 -->
	<div id="edit" style="display: none">
		<form id="editForm" action="${path}/super/company/doEdit.html" method="post">
			<table style="width: 90%;margin-left:5%;" class="gridtable">
				<col style="width: 30%;" />
				<col style="width: 70%;"/>
   	 			<tr>
   	 				<td style="text-align: right;">公司ID：</td>
   	 				<td style="text-align: left;"><input type="text" id="edit_company_id" name="company.company_id" readonly="readonly"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">公司名称：</td>
   	 				<td style="text-align: left;"><input type="text" id="edit_company_name" class="required" name="company.company_name"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">公司地址：</td>
   	 				<td style="text-align: left;"><input type="text" id="edit_address" class="required" name="company.address"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">公司电话：</td>
   	 				<td style="text-align: left;"><input type="text" id="edit_telephone" class="required" name="company.telephone"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">总经理：</td>
   	 				<td style="text-align: left;"><input type="text" id="edit_manager" class="required" name="company.manager"/></td>
   	 			</tr>
   	 		</table>
		</form>
	</div>
	
	<!-- fileUpLoad -->
	 <div id="fileUpLoad" style="display:none">
   	 	<form id="fileUpLoadForm" method="post" action="${path}/super/company/fileUpLoad.html" enctype="multipart/form-data">
   	 		<table>
   	 			<col style="width: 20%;" />
				<col style="width: 30%;"/>
				<col style="width: 20%;" />
				<col style="width: 30%;"/>
				<tr>
					<th>请选择文件:</th>
				</tr>
				<tr>
					<td colspan="3">
						 <input type="file" id="some" name="some" style="width:90%;height:25px;"/>
					</td>
				</tr>
   	 		</table>
   	 	</form>
   	 </div>
</body>
</html>
