<%--
  Created by IntelliJ IDEA.
  User: 17634
  Date: 2020/4/27
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/js/bootstrap.js"></script>
    <title>Title</title>
</head>
<body>
<table class="table table-condensed">
    <tr align="center">
        <td colspan="5">当前${pageInfo.pageNum}页,共${pageInfo.pages }页,总${pageInfo.total }条记录</td>
    </tr>
    <tr align="center">
        <td class="active">ID</td>
        <td class="success">NO</td>
        <td class="warning">PASS</td>
        <td class="danger">NAME</td>
        <td class="info">SEX</td>
        <td class="danger">操作</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="item">
        <tr align="center">
            <td class="active">${item.id}</td>
            <td class="success">${item.uno}</td>
            <td class="warning">${item.upass}</td>
            <td class="danger">${item.uname}</td>
            <td class="info">${item.sex}</td>
            <td class="danger"><a href="${pageContext.request.contextPath}/del/${pageInfo.pageNum}/${item.uno}"><button class="btn-warning">删除</button></a> </td>
        </tr>
    </c:forEach>
</table>
<!-- 分页码 -->
<div class="col-lg-offset-5">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <!--
                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
                        2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
                      -->
            <li>
                <a href="${pageContext.request.contextPath}/list/1">首页</a>
            </li>`
            <!-- 如果还有前页就访问当前页码-1的页面， -->
            <c:if test="${pageInfo.hasPreviousPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/list/${pageInfo.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <li>
                <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果不相等就普通显示  -->
                <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                <c:if test="${page_Nums==pageInfo.pageNum }">
            <li class="active"><a href="#">${page_Nums}</a></li>
            </c:if>
            <c:if test="${page_Nums!=pageInfo.pageNum }">
                <li ><a href="${pageContext.request.contextPath}/list/${page_Nums}">${page_Nums}</a></li>
            </c:if>
            </c:forEach>
            </li>
            <!-- 如果还有后页就访问当前页码+1的页面， -->
            <c:if test="${pageInfo.hasNextPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/list/${pageInfo.pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <li><a href="${pageContext.request.contextPath}/list/${pageInfo.pages}">末页</a></li>
        </ul>
    </nav>
</div>
</body>
</html>
