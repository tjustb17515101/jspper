<%--
  Created by IntelliJ IDEA.
  User: 17634
  Date: 2020/4/26
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/js/bootstrap.js"></script>
</head>
<body>

    <header class="navbar navbar-static-top bs-docs-nav">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <span class="glyphicon glyphicon-user col-lg-3" style="font-size: 30px"></span>
                </div>
            </div>
        </nav>
    </header>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">@</span>
        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
    </div>

    <div class="input-group">
        <input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2">
        <span class="input-group-addon" id="basic-addon2">@example.com</span>
    </div>

    <div class="input-group">
        <span class="input-group-addon">$</span>
        <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
        <span class="input-group-addon">.00</span>
    </div>

    <label for="basic-url">Your vanity URL</label>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon3">https://example.com/users/</span>
        <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
    </div>

</body>
</html>
