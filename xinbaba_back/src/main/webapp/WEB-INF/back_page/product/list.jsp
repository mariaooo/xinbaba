<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>babasport-list</title>
    <script type="text/javascript">
        function getTableForm() {
            return document.getElementById('tableForm');
        }
        function optDelete() {
            if (Pn.checkedCount('ids') <= 0) {
                alert("请至少选择一个!");
                return;
            }
            if (!confirm("确定删除吗?")) {
                return;
            }
            var f = getTableForm();
            f.action = "o_delete.do";
            f.submit();
        }
        function changePageNo() {
            $("input[name='pageNo']").val(1);
        }
    </script>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 商品管理 - 列表</div>
    <form class="ropt">
        <input class="add" type="button" value="添加" onclick="javascript:window.location.href='/product/toAdd.do'"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form action="/product/list.do" method="post" style="padding-top:5px;">
        名称: <input type="text" name="name" value="${name}"/>
        <select name="brandId">
            <option value="">请选择品牌</option>
            <c:forEach items="${brands}" var="brand">
                <option value="${brand.id}"
                        <c:if test="${brand.id == brandId}">selected="selected"</c:if> >${brand.name}</option>
            </c:forEach>
        </select>
        <select name="isShow">
            <option value="false"
                    <c:if test="${isShow}">selected="selected"</c:if>  >上架
            </option>
            <option value="true"
                    <c:if test="${!isShow}">selected="selected"</c:if> >下架
            </option>
        </select>
        <input type="submit" class="query" value="查询"/>
    </form>
    <form method="post" id="tableForm">
        <table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>图片</th>
                <th width="4%">新品</th>
                <th width="4%">热卖</th>
                <th width="4%">推荐</th>
                <th width="4%">上下架</th>
                <th width="12%">操作选项</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">
            <c:forEach items="${products.list}" var="product">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="73"/></td>
                    <td>${product.id}</td>
                    <td align="center">${product.name}</td>
                    <td align="center"><img width="50" height="50" src="/res/img/pic/ppp.jpg"/></td>
                    <td align="center">
                        <c:if test="${product.isNew}">
                            是
                        </c:if>
                        <c:if test="${!product.isNew}">
                            否
                        </c:if>
                    </td>
                    <td align="center">
                        <c:if test="${product.isHot}">
                            是
                        </c:if>
                        <c:if test="${!product.isHot}">
                            否
                        </c:if>
                    </td>
                    <td align="center">
                        <c:if test="${product.isCommend}">
                            是
                        </c:if>
                        <c:if test="${!product.isCommend}">
                            否
                        </c:if>
                    </td>
                    <td align="center">
                        <c:if test="${product.isShow}">
                            上架
                        </c:if>
                        <c:if test="${!product.isShow}">
                            下架
                        </c:if>
                    </td>
                    <td align="center">
                        <a href="#" class="pn-opt">查看</a> | <a href="#" class="pn-opt">修改</a> | <a href="#"
                                                                                                   onclick="if(!confirm('您确定删除吗？')) {return false;}"
                                                                                                   class="pn-opt">删除</a>
                        |
                        <a href="../sku/list.jsp" class="pn-opt">库存</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="page pb15">
	<span class="r inb_a page_b">
	
		<a href="#" onclick="pageList(1)"><font size="2">首页</font></a>
	
		        <c:if test="${pageNo > 1}">
                    <a href="#" onclick="pageList(${pageNo - 1})"><font size="2">上一页</font></a>
                </c:if>

        <c:forEach begin="${pageNo - 4 <= 1 ? 1: pageNo - 4}"
                   end="${pageNo + 4 >products.pageTotal ? products.pageTotal : pageNo + 4 }" step="1" var="n">
            <c:if test="${pageNo == n}">
                <strong style="margin-right: 10px">${n}</strong>
            </c:if>
            <c:if test="${pageNo != n}">
                <a href="#" onclick="pageList(${n})">${n}</a>
            </c:if>
        </c:forEach>

        <c:if test="${pageNo < products.pageTotal}">
            <a href="#" onclick="pageList(${pageNo + 1})"><font size="2">下一页</font></a>
        </c:if>

		<a href="#" onclick="pageList(${products.pageTotal})"><font size="2">尾页</font></a>

		共<var>${products.pageTotal}</var>页 到第  <input type="number" min="1" max="${products.pageTotal}" size="3" id="PAGENO"
                                                  width="20"/>  页 <input type="button"
                                                                         onclick="javascript:pageList($('#PAGENO').val()) "
                                                                         value="确定" class="hand btn60x20" id="skip"/>
	</span>
        </div>
        <div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/><input
                class="add" type="button" value="上架" onclick="optDelete();"/><input class="del-button" type="button"
                                                                                    value="下架" onclick="optDelete();"/>
        </div>
    </form>
    <script type="text/javascript">
        function pageList(pageNo) {
            if (isNaN(pageNo)) {
                $('#PAGENO').val('');
                alert("invalided input!");
                return;
            }
            if (pageNo > ${products.pageTotal} || pageNo < 1) {
                $('#PAGENO').val('');
                alert('sorry,  page limit is 1 ~ ${products.pageTotal}');
                // window.location.href ='${pageContext.request.contextPath}/product/list.do?name=${name}&isShow=${isShow}&pageNo=${products.pageTotal}&brandId=${brandId}';
            } else {
                window.location.href = '${pageContext.request.contextPath}/product/list.do?name=${name}&isShow=${isShow}&pageNo='+pageNo+'&brandId=${brandId}';
            }
        }
    </script>
</div>
</body>
</html>