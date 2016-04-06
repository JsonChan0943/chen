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
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script><!-- 日期控件 -->
	<link href="${path}/css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${path}/js/validator.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/css/pager.css" />
	<script src="${path}/js/pager.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<script type="text/javascript">
		//修改 
	  	function goEdit(userid){
			window.parent.frames["browerFrame"].location.href = "${path}/supers/goEdit.html?userid="+userid;
	    }
		
		//车辆退租 
		function doReturnCar(idsbook){
			$.ligerDialog.confirm('确定退租该车辆？', 
				function (yes){
					if(yes){
						window.parent.frames["browerFrame"].location.href = "${path}/user/sbook/doReturnCar.html?idsbook="+idsbook;
					}
				}
			);
		}
		
		//删除 
		function doDel(idsbook){
			$.ligerDialog.confirm('确定删除该条租赁信息？',  
					function (yes){
						if(yes){
							window.parent.frames["browerFrame"].location.href = "${path}/user/sbook/doDel.html?idsbook="+idsbook;
						}
					}
				);
		}
		
		//修改 
		function doEdit(idsbook,lessee,lease,startDateString,endDateString,usedept,driver,comment){
				$('#sbook_idsbook').val(idsbook);
				$('#sbook_lessee').val(lessee);
	  			$('#sbook_lease').val(lease);
	  			$('#startDate').val(startDateString);
	  			$('#endDate').val(endDateString);
	  			$('#dept').val(usedept);
  				$('#driver').val(driver);
	  			$('#comment').val(comment);
					//增加管理员 
			  		$.ligerDialog.open({
							title : "车辆租赁信息修改 ",
							target : $("#edit"),
							width : 500,
							height : 300,
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
									$('#sbook_lessee').val('');
									$('#sbook_lease').val('');
									$('#startDate').val('');
									$('#endDate').val('');
									$('#dept').val('');
									$('#driver').val('');
									$('#comment').val('');
									$(".formtips").remove();   
								}
							}]
					});
		}
	  	
	  	function search_reset(){
	  		$('#search_user').val('default');
	  		$('#search_lessee').val('');
	  		$('#search_lease').val('');
	  		$('#search_name').val('');
	  		$('#search_plate_num').val('');
	  		$('#search_type').val('');
	  		$('#search_origin').val('default');
	  		$('#search_usedept').val('');
	  		$('#search_isexpire').val('default');
	  	}
	  	
	  	//导出租赁信息 
	  	function exportSbooks(){
	  		$.ligerDialog.confirm('确定导出车辆租赁信息列表？',    
				function (yes){
					if(yes){
						window.location.href = "${path}/user/sbook/doReport.html";
					}
				}
			);
	  	}
   	</script>
</head>
<body>
	<span style="color:blue">当前位置：系统用户-租赁信息</span>
	&nbsp;&nbsp;&nbsp;
	<a href="javascript:void(0)" style="font-size: 10px"onclick="exportSbooks()">导出租赁信息</a>
	<!-- 搜索栏 -->
	<div style="font-size: 10px">
		<fieldset style="border:1px dashed blue" >
			<legend><a href="javascript:void(0)" onclick="showAndHide()"><b>快速查询</b></a></legend>
			<div id="search">
			<form id="searchForm" action="${path}/user/sbook/goMain.html" method="post">
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
					<input type="hidden" id="toPage" name="pageModel.toPage"></input>
   	 				<td style="text-align: right;">经办人：</td>
   	 				<td style="text-align: left;">
   	 					<s:select list="users" style="width:135px" name="search.userid" id="search_user"
   								listKey="id" listValue="name" headerKey="default" headerValue="----请选择经办人----"></s:select>
   	 				</td>
   	 				<td style="text-align: right;">承租方：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.lessee" id="search_lessee"/></td>
   	 				<td style="text-align: right;">出租方：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.lease" id="search_lease"/></td>
   	 				<td style="text-align: right;">设备名称：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.name" id="search_name"/></td>
   	 				<td style="text-align: right;">车牌号：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.plate_num" id="search_plate_num"/></td>
   	 			</tr>
   	 			<tr>
   	 				<td style="text-align: right;">型号：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.type" id="search_type"/></td>
   	 				<td style="text-align: right;">来源：</td>
   	 				<td style="text-align: left;">
   	 					<s:select list="orgins" style="width:135px" name="search.origin" id="search_origin"
   								listKey="enValue" listValue="enName" headerKey="default" headerValue="-----请选择来源-----"></s:select>
   	 				</td>
   	 				<td style="text-align: right;">使用部门：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.usedept" id="search_usedept"/></td>
   	 				<td style="text-align: right;">是否过期：</td>
   	 				<td style="text-align: left;">
   	 					<s:select list="status" style="width:135px" name="search.isexpire" id="search_isexpire"
   								listKey="enValue" listValue="enName" headerKey="default" headerValue="---请选择是否过期---"></s:select>
 	 				</td>
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
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
	   		<col width="7%"/>
   			<col width="8%"/>
			<col width="12%"/>
			<thead>
				<tr>
		           <th style="text-align: center">设备名称</th>
					<th style="text-align: center">车牌号</th>
					<th style="text-align: center">型号</th>
					<th style="text-align: center">来源</th>
		            <th style="text-align: center">承租方</th>
		            <th style="text-align: center">出租方</th>
		            <th style="text-align: center">承载人</th>
		            <th style="text-align: center">起租时间</th>
		            <th style="text-align: center">到租时间</th>
		            <th style="text-align: center">使用部门</th>
		            <th style="text-align: center">是否过期</th>
		            <th style="text-align: center">经办人</th>
		            <th style="text-align: center">备注</th>
		            <th style="text-align: center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="sbooks" status="s">
					<tr>
						<td style="text-align: center"><s:property value="name"/></td>
						<td style="text-align: center"><s:property value="plate_num"/></td>
						<td style="text-align: center"><s:property value="type"/></td>
						<td style="text-align: center"><s:property value="originName"/></td>
						<td style="text-align: center"><s:property value="lessee"/></td>
						<td style="text-align: center"><s:property value="lease"/></td>
						<td style="text-align: center"><s:property value="driver"/></td>
						<td style="text-align: center"><s:property value="startDateString"/></td>
						<td style="text-align: center"><s:property value="endDateString"/></td>
						<td style="text-align: center"><s:property value="usedept"/></td>
						<td style="text-align: center"><s:property value="isexpireString"/></td>
						<td style="text-align: center"><s:property value="username"/></td>
						<td style="text-align: center"><s:property value="comment"/></td>
						<td style="text-align: center">
							 <a href="javascript:void(0)" onclick="doDel('${idsbook}');" >删除</a>
							 <a href="javascript:void(0)" onclick="doEdit('${idsbook}','${lessee}','${lease}','${startDateString}','${endDateString}','${usedept}','${driver}','${comment}');" >修改</a>
							 <a href="javascript:void(0)" onclick="doReturnCar('${idsbook}');" >退租</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>	

	<!-- 分页 -->
	<jsp:include page="/pages/pager.jsp"></jsp:include>
	<!-- 修改区 -->
	<div id="edit" style="display:none">
	<br/>
	<form id="editForm" action="${path}/user/sbook/doEdit.html" method="post">
		<table style="width: 90%;margin-left:5%;" class="gridtable">
				<col style="width: 30%;" />
				<col style="width: 70%;"/>
				<tr>
					<input type="hidden" name="sbook.idsbook" id="sbook_idsbook"/>
					<td style="text-align: right">承租方：</td>
					<td style="text-align: left"><input type="text" name="sbook.lessee" id="sbook_lessee" class="required"/></td>
				</tr>
				<tr>	
					<td style="text-align: right">出租方：</td>
					<td style="text-align: left"><input type="text" name="sbook.lease" id="sbook_lease" class="required"/></td>
				</tr>
				<tr>
					<td style="text-align: right">起租时间：</td>
					<td style="text-align: left">
						<input type="text" name="sbook.startDateString"  id="startDate"  
onclick="JavaScript:new WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMdd',isShowWeek:true,el:startDate,maxDate:'#F{$dp.$D(\'endDate\')}'})" 
   					style="width:130px;" size="12" class="required"/>
					</td>
				</tr>
				<tr>	
					<td style="text-align: right">到租时间：</td>
					<td style="text-align: left">
						<input type="text" name="sbook.endDateString"  id="endDate" 
onclick="JavaScript:new WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMdd',isShowWeek:true,el:endDate,minDate:'#F{$dp.$D(\'startDate\')}'})" 
   					style="width:130px;" size="12" class="required"/>
   					</td>
				</tr>
				<tr>
					<td style="text-align: right">使用部门：</td>
					<td style="text-align: left"><input type="text" name="sbook.usedept" id="dept" class="required"/></td>
				</tr>
				<tr>
					<td style="text-align: right">承载人：</td>
					<td style="text-align: left"><input type="text" name="sbook.driver" id="driver" class="required"/></td>
				</tr>	
				<tr>
					<td style="text-align: right">备注：</td>
					<td style="text-align: left"><input type="text" name="sbook.comment" id="comment" class="required"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
