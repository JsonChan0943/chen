<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="/pages/common/common.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- 分页 -->
<div style="text-align: left">
	<span>总页数:</span><span id="TOTALPAGES"></span>&nbsp;&nbsp;
	<span>当前页码:</span><span id="CURRENTPAGENO"></span>&nbsp;&nbsp;
	<span>总记录数:</span><span id="TOTALDATA"></span>&nbsp;&nbsp;
	<span>本次查找记录数:</span><span id="FINDCNT"></span>&nbsp;&nbsp;
	<span>当前记录范围:</span><span id="FROM"></span>--<span id="TO"></span>
</div>
<div id="pages" style="text-align: center">
	<s:hidden id="currentPage" name="pageModel.current_page" />
	<s:hidden id="totalPage" name="pageModel.total_page" />
	<a href="javascript:void(0)" onclick="previous()">上一页</a>
	<c:forEach begin="1" end="${pageModel.total_page}" var="p">
		<c:choose>
      		<c:when test="${p==pageModel.current_page}">
      			<a href="javascript:void(0)" class="current_page" onclick="requestForThePage(${p})">&nbsp;${p}&nbsp;</a>
      		</c:when>
      		<c:otherwise>
      			<a href="javascript:void(0)" onclick="requestForThePage(${p})">&nbsp;${p}&nbsp;</a>
      		</c:otherwise>
   	    </c:choose>
	</c:forEach>
	<a href="javascript:void(0)" onclick="next()">下一页</a>
	<script type="text/javascript">
		$(function(){
			$("#TOTALPAGES").html(${pageModel.total_page});
			$("#CURRENTPAGENO").html(${pageModel.current_page});
			$("#TOTALDATA").html(${pageModel.totalData});
			$("#FINDCNT").html(${pageModel.findCnt});
			$("#FROM").html(${pageModel.from});
			$("#TO").html(${pageModel.to});
		});
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
	</script>
</div>