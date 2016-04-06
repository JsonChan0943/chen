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
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script><!-- 日期控件 -->
	<link rel="stylesheet" type="text/css" href="${path}/js/ligerUI/skins/Aqua/css/ligerui-all.css" />
	<link rel="stylesheet" type="text/css" href="${path}/css/pager.css" />
	<link href="${path}/css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${path}/js/validator.js"></script>
	<script src="${path}/js/pager.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<script type="text/javascript">
		function rentCar(carid){
			$('#sbook_carid').val(carid);
				//增加管理员 
		  		$.ligerDialog.open({
						title : "车辆租赁信息录入 ",
						target : $("#rent"),
						width : 500,
						height : 300,
						buttons : [ {
							text : '提交',
							onclick : function(item, d) {
								$("#rentForm :input.required").trigger('blur');    
								var numError = $("form .onError").length; 
								if(numError>0){     
									return false;  
								}else{
									$('#rentForm').submit();
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
	  		$('#search_name').val('');
	  		$('#search_plate_num').val('');
	  		$('#search_type').val('');
	  		$('#search_status').val('default');
	  		$('#search_origin').val('default');
	  		var isZongGongsi = '${request.isZongGongsi}';
	  		if(isZongGongsi=='yes'){
	  			$('#search_company').val('default');
	  		}
	  	}
   	</script>
</head>
<body>
	<span style="color:blue">当前位置：系统用户-汽车信息</span>
	<!-- 搜索栏 -->
	<div style="font-size: 10px">
		<fieldset style="border:1px dashed blue" >
			<legend><a href="javascript:void(0)" onclick="showAndHide()"><b>快速查询</b></a></legend>
			<div id="search">
			<form id="searchForm" action="${path}/user/car/goMain.html" method="post">
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
   	 				<td style="text-align: right;">汽车名称：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.name" id="search_name"/></td>
   	 				<td style="text-align: right;">车牌号：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.plate_num" id="search_plate_num"/></td>
   	 				<td style="text-align: right;">汽车类型：</td>
   	 				<td style="text-align: left;"><s:textfield name="search.type" id="search_type"/></td>
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
   	 				<td style="text-align: right;">汽车状态：</td>
   	 				<td style="text-align: left;">
   	 					<s:select list="status" style="width:135px" name="search.status" id="search_status"
   								listKey="enValue" listValue="enName" headerKey="default" headerValue="-----请选择状态-----"></s:select>
   	 				</td>
   	 				<td style="text-align: right;">汽车来源：</td>
   	 				<td style="text-align: left;">
   	 					<s:select list="origins" style="width:135px" name="search.origin" id="search_origin"
   								listKey="enValue" listValue="enName" headerKey="default" headerValue="-----请选择来源-----"></s:select>
   	 				</td>
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
	   		<col width="14%""/>
	   		<col width="14%""/>
	   		<col width="14%""/>
	   		<col width="14%""/>
	   		<col width="14%""/>
	   		<col width="14%""/>
	   		<col width="16%""/>
			<thead>
				<tr>
		            <th style="text-align: center">汽车名称</th>
		            <th style="text-align: center">车牌号</th>
		            <th style="text-align: center">车辆类型</th>
		            <th style="text-align: center">汽车状态</th>
		            <th style="text-align: center">汽车来源</th>
		            <th style="text-align: center">汽车所属公司</th>
		            <th style="text-align: center">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="cars" status="s">
					<tr>
						<td style="text-align: center"><s:property value="name"/></td>
						<td style="text-align: center"><s:property value="plate_num"/></td>
						<td style="text-align: center"><s:property value="type"/></td>
						<td style="text-align: center"><s:property value="statusName"/></td>
						<td style="text-align: center"><s:property value="originName"/></td>
						<td style="text-align: center"><s:property value="company_name"/></td>
						<td style="text-align: center">
							<!-- 只有未租车辆才显示‘租用该车辆’ -->
							<c:choose>
			       	      		<c:when test="${status=='N'}">
			       	      			<a href="javascript:void(0)" onclick="rentCar('${carid}');">租用该车辆</a>	</c:when>
			     	      		<c:otherwise>
			     	      			<span style="color:red;">车辆已被租用</span>
			     	      		</c:otherwise>
				     	    </c:choose>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>	

	<!-- 分页 -->
	<jsp:include page="/pages/pager.jsp"></jsp:include>
	
	<!--edit -->
	<div id="rent" style="display:none">
	<br/>
	<form id="rentForm" action="${path}/user/car/doRentCar.html" method="post">
		<input type="hidden" value="${session.userid}" name="sbook.userid" id="sbook_userid"/>
		<input type="hidden" name="sbook.carid" id="sbook_carid"/>
		<table style="width: 90%;margin-left:5%;" class="gridtable">
				<col style="width: 30%;" />
				<col style="width: 70%;"/>
				<tr>
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
