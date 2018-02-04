<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='${pageContext.request.contextPath}/view/brand/add.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="${pageContext.request.contextPath}/brand/list.do" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${name}" />
	<select name="isDisplay" >
		<option value="1" <c:if test="${isDisplay == 1}">selected</c:if> >是</option>
		<option value="0"  <c:if test="${isDisplay == 0}">selected</c:if>>不是</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkBox('ids',this.checked)"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	<c:forEach items="${page.list}" var="brand">
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="${brand.id}" name="ids"/></td>
			<td align="center">${brand.id}</td>
			<td align="center">${brand.name}</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">
				<c:if test="${brand.isDisplay == 1}">是</c:if>
				<c:if test="${brand.isDisplay == 0}">否</c:if>
			</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
	
		<a href="#" onclick="pageList(1)"><font size="2">首页</font></a>

        <c:if test="${pageNo > 1}">
            <a href="#" onclick="pageList(${pageNo - 1})" ><font size="2">上一页</font></a>
        </c:if>

        <c:forEach begin="${pageNo - 4 <= 1 ? 1: pageNo - 4}" end="${pageNo + 4 >page.pageTotal ? page.pageTotal : pageNo + 4 }" step="1" var="n" >
            <c:if test="${pageNo == n}" >
                <strong style="margin-right: 10px">${n}</strong>
            </c:if>
            <c:if test="${pageNo != n}" >
                <a href="#" onclick="pageList(${n})">${n}</a>
            </c:if>
        </c:forEach>

        <c:if test="${pageNo < page.pageTotal}">
            <a href="#" onclick="pageList(${pageNo + 1})" ><font size="2">下一页</font></a>
        </c:if>
	
		<a href="#" onclick="pageList(${page.pageTotal})"><font size="2">尾页</font></a>
	
		共<var>${page.pageTotal}</var>页 到第  <input type="number" min="1"	 max="${page.pageTotal}" size="3" id="PAGENO" width="20" />  页 <input type="button" onclick="javascript:pageList($('#PAGENO').val()) " value="确定" class="hand btn60x20" id="skip"/>
	
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
</div>
<script type="text/javascript" >
    function pageList(pageNo) {
    	if (isNaN(pageNo)){
			$('#PAGENO').val('');
			alert("invalided input!");
			return;
		}
    	if (pageNo > ${page.pageTotal} || pageNo < 1 ) {
			$('#PAGENO').val('');
    		alert('sorry,  page limit is 1 ~ ${page.pageTotal}');
			// window.location.href ='${pageContext.request.contextPath}/brand/list.do?name=${name}&isDisplay=${isDisplay}&pageNo=${page.pageTotal}';
		}else {
			window.location.href ='${pageContext.request.contextPath}/brand/list.do?name=${name}&isDisplay=${isDisplay}&pageNo='+pageNo;
		}
    }
</script>
</body>
</html>