<%@ page contentType="text/html; charset=utf-8" language="java"%>
<% 
	String path=request.getContextPath(); 
	request.setAttribute("path",path); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("basePath", basePath);
%>
<!-- ---------------------------------------------开发路径描述------------------------------------------------>
<!-- 1：当前页面是通过“${actionName}”类跳转到当前页面 -->
<!-- 2：具体的跳转方法为：“${actionMathod}” -->
<!-- 3：访问的命名空间为：“${namespace}” -->
<!-- 4：当前页面的地址：<%=request.getRequestURI()%>  -->
<!---- ----------------------------------------------END--------------------------------------------------->
