<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 23.01.18
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Laptop</title>
    <link rel="stylesheet" href="css/sidebar.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:useBean id="workWithJson" scope="application" class="service.WorkWithJson"/>

<%@include file="META-INF/jspf/head.jspf"%>

<form method="post" action="#" role="login">
<div class="row">
    <div class="container">
        <div class="col-md-3">
            <%@include file="META-INF/jspf/sidebar.jspf"%>
        </div>
  <c:forEach items="${workWithJson.laptopJson}" var="elem">
        <div class="col-md-3">
            <br>
            <br>
            <img class="card-img-top" src="${elem.imgPath}" height="150" width="230" alt="Card image cap">
            <h4 class="card-text">${elem.name}</h4>
            <p class="card-text">${elem.cpu}</p>
            <p class="card-text">${elem.ram}</p>
            <p class="card-text">${elem.videoCard}</p>
            <p class="card-text">${elem.hardMemory}</p>
            <%--<a href="">Detail</a>--%>
        </div>
  </c:forEach>
    </div>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>

    <%
        String status = (String) session.getAttribute("userStatus");
    %>

    <%
        if (status.equals("Admin")) {
    %>

    <a href="addNewLaptop.jsp">ADD NEW LAPTOP</a>
    <%}%>
</div>
</form>



<br>
<%@include file="META-INF/jspf/footer.jspf"%>

</body>
</html>
