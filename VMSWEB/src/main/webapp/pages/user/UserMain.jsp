<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="/pages/common/common.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>管理员</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="${path}/js/ligerUI/skins/Aqua/css/ligerui-all.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script src="${path}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerDialog.js"  type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerAccordion.js" type="text/javascript"></script>
	<script src="${path}/js/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript">
		//Layout布局 
		$(function(){
			//初始化页面布局 
			$("#div1").ligerLayout({
				leftWidth:200,//左侧的宽度 
				topHeight :90,//上面的高度 
				bottomHeight:20,//下面的高度 
				allowLeftCollapse:false,
				allowLeftResize:false,
				allowTopResize:false,
				allowBottomResize:false
			}); 
		});
		//页面载入默认显示用户列表 
		$(function(){
			$("#browerFrame").attr("src","${path}/user/sbook/goMain.html");
			// window.frames["browerFrame"].location.href = "${path}/user/sbook/goMain.html";
		});
		//我的信息 
		function myInfo(userid){
			$("#browerFrame").attr("src","${path}/user/mine/goMain.html");
			//window.frames["browerFrame"].location.href = "${path}/user/mine/goMain.html"; 
		}
		//用户列表 
	  	function listSbook(){
	  		$("#browerFrame").attr("src","${path}/user/sbook/goMain.html");
	  		// window.frames["browerFrame"].location.href = "${path}/user/sbook/goMain.html";
	  	}
		
		//车辆列表 
		function listCar(){
			$("#browerFrame").attr("src","${path}/user/car/goMain.html");
			//window.frames["browerFrame"].location.href = "${path}/user/car/goMain.html";
		}
		
		function listFinishSBook(){
			$("#browerFrame").attr("src","${path}/user/finishSBook/goMain.html");
			//window.frames["browerFrame"].location.href = "${path}/user/finishSBook/goMain.html"; 
		}
		//主浏览页面 
		function goLocation(url){
			window.frames["browerFrame"].location.href = "${path}"+url;
		}
		
		function loginOut(){
	  		$.ligerDialog.confirm('确定退出系统？',  
				function (yes){
					if(yes){
						window.location.href = "${path}/login/loginOut.html";
					}
				}
			);
	  	}
		
		//修改密码 
		function editPwd(){
			$.ligerDialog.open({
				title : "修改密码",
				target : $("#editPwd"),
				width : 350,
				height : 150,
				buttons : [ {
					text : '提交',
					onclick : function(item, d) {
						if($('#oldPwd').val()==''){
							$.ligerDialog.warn("原始密码不能为空！");
							$('#oldPwd').focus();
						}else if($('#newPwd').val()==''){
							$.ligerDialog.warn("新密码不能为空！"); 
							$('#newPwd').focus();
						}else if($('#repPwd').val()==''){
							$.ligerDialog.warn("重复新密码不能为空！"); 
							$('#repPwd').focus();
						}else if(${session.password}!=$('#oldPwd').val()){
							$.ligerDialog.warn("原始密码不正确 ！");
							$('#oldPwd').focus();
						}else if($('#newPwd').val()!=$('#repPwd').val()){
							$.ligerDialog.warn("两次密码输入不一致！");
							$('#newPwd').focus();
						}else{
							var userid = $('#id').val();
							var password = $('#repPwd').val();
							$.ajax({
					 			url:"${path}/super/mine/editPwd.html",
					 			type:"post",
					 			dataType:"json",
					 			data:"user.userid="+userid+"&user.password="+password, 
					 			success:function(data){
					 				if(data.success){
					 					$.ligerDialog.success('密码修改成功！');  
		 							}else{
		 								$.ligerDialog.error('密码修改失败！'); 
					 				}
					 			},
					 			error:function(){
					 				$.ligerDialog.error('出错！');  
					 			}
					 		});
							d.close();
						}
					}
				},{
					text : '重置',
					onclick : function(item, d) {
						$('#oldPwd').val('');
						$('#newPwd').val('');
						$('#repPwd').val('');
					}
				}]
			});
	  	}
	</script> 
</head>
<body>
	<div id="div1" style="background:url(${path}/style/view/bg.png)">
			<!-- 上面部分 -->
			<div position="top" style="height:90px;width: 1366px;background:url(${path}/style/view/top.png)">
				<div style="text-align:right;">
					<b>
						欢迎<span style="color:red;">${session.companyname}&nbsp;&nbsp;${session.role}&nbsp;&nbsp;${session.nickname}</span>登陆系统&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="editPwd();">修改密码</a>&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="loginOut();">安全退出</a>
					</b>	
				</div>
			</div>
			<!-- 左边部分 -->
			<div position="left" style="height:100%;">
				</br></br>
				<h3>
				<a href="javascript:void(0)" onclick="myInfo();">-->我的信息</a>
				</br></br>
				<a href="javascript:void(0)" onclick="listCar();">-->汽车信息</a>
				</br></br>
				<a href="javascript:void(0)" onclick="listSbook();">-->租赁信息</a>
		   		</br></br>
		   		<a href="javascript:void(0)" onclick="listFinishSBook();">-->台账信息</a>
		   		</h3>
			</div> 
			<!-- 中间部分 -->
			<div position="center" title="上海宝冶集团汽车租赁管理系统">
				<iframe id="browerFrame" style="width:100%;height:100%" >

				</iframe>
			</div>
			<!-- 下面部分 -->
			<div position="bottom" style="height:20px;text-align:center">经纬科技&copy版权所有</div>
		</div>
		
		<!--editPwd：密码修改 -->
	<div id="editPwd" style="display: none">
		<form id="editPwdForm" action="" method="post">
			<table width="98%" >
				<col style="width: 40%;"/>
				<col style="width: 60%;"/>
				<input type="hidden" id="id" value="${session.userid}" name="user.userid"/>
				<tr>	
					<td style="text-align: right;"><span style="color: red">*&nbsp</span>原密码：</td>
					<td>
						 <input type="password" id="oldPwd"/>
					</td>
				</tr>
				<tr>
					<td style="text-align: right;"><span style="color: red">*&nbsp</span>新密码：</td>
					<td>
						 <input type="password" id="newPwd"/>
					</td>
				</tr>
				<tr>	
					<td style="text-align: right;"><span style="color: red">*&nbsp</span>重复一遍：</td>
					<td>
						 <input type="password" name="user.password" id="repPwd"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
