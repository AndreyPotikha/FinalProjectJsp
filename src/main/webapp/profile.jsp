<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 24.01.18
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="css/sidebar.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="form-group">
    <label class="aria-current">Name:</label>
    <%= request.getAttribute("name")%><br>
</div>
<div class="form-group">
    <label class="aria-current">Email:</label>
    <%= request.getAttribute("email")%><br>
</div>
<div class="form-group">
    <label class="aria-current">Status:</label>
    <%= request.getAttribute("status")%><br>
</div>
</body>
</html>
