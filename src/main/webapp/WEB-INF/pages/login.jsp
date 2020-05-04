<%--
  Created by IntelliJ IDEA.
  User: 17634
  Date: 2020/4/29
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/webjars/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/jquery/3.4.1/jquery.min.js" type="javascript"></script>
    <script src="/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form action="login" method="post">
    <div class="form-group">
        <label for="userNo">UserNo</label>
        <input type="number" class="form-control" id="userNo" name="uno" placeholder="UserNo">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="upass" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-default">Sign In</button>
    <h3 class="warning" align="center" >${loginTip}</h3>
</form>
</body>
</html>
