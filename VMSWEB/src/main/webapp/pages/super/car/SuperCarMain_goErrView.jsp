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
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<style type="text/css">
		.current_page
			{
			    background: #FFF;
			    border: #89bdd8 solid 1px;
			    color: #067db5;
			}
			 a {text-decoration:none;}
				table.gridtable {
				font-family: verdana,arial,sans-serif;
				font-size:11px;
				color:#333333;
				border-width: 1px;
				border-color: #666666;
				border-collapse: collapse;
			}
			table.gridtable th {
				border-width: 1px;
				padding: 5px;
				border-style: solid;
				border-color: #666666;
				background-color: #eaf2fe;
			}
			table.gridtable td {
				border-width: 1px;
				padding: 4px;
				border-style: solid;
				border-color: #666666;
				background-color: #ffffff;
			}
	</style>
	<script type="text/javascript">
		//页面加载完成时的事件 
		window.onload = function(){
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
		}
		
		//删除
		function doDel(fileName){
			$.ligerDialog.confirm('确定删除？', 
				function (yes){
					if(yes){
						window.location.href = "${path}/super/car/doErrFileDel.html?fileName="+fileName;
					}
				}
			);
		}
		
		//下载 
		function doDownload(fileName){
			$.ligerDialog.confirm('确定下载？', 
					function (yes){
						if(yes){
							window.location.href = "${path}/super/car/doErrFileDownload.html?fileName="+fileName;
						}
					}
				);
		}

	  
   	</script>
</head>
<body>
	<div>
		<span style="color:blue">当前位置：超级管理员-车辆信息-批量增加业务上传错误详情</span>
	</div>
	
	<!-- 列表区 -->
	<div>
	   	<table border="1" style="width:780px;" class="gridtable">
	   		<col width="10%""/>
	   		<col width="30%""/>
	   		<col width="40%""/>
	   		<col width="20%""/>
			<thead>
				<tr>
					<th style="text-align: center">序号</th>
		            <th style="text-align: center">时间</th>
		            <th style="text-align: center">文件名</th>
		            <th style="text-align: center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="filePOJO" status="s">
					<tr>
						<td style="text-align: center"><s:property value="no"/></td>
						<td style="text-align: center"><s:property value="time"/></td>
						<td style="text-align: center"><s:property value="fileName"/></td>
						<td style="text-align: center">
							 <a href="javascript:void(0)" onclick="doDownload('${fileName}');" >下载</a>
							 <a href="javascript:void(0)" onclick="doDel('${fileName}');" >删除</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>	
	</br>
</body>
</html>
