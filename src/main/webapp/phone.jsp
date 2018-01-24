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
    <title>Phone</title>
    <link rel="stylesheet" href="css/sidebar.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:useBean id="workWithJson" scope="application" class="service.WorkWithJson"/>

<%@include file="META-INF/jspf/head.jspf"%>

<div class="row">
    <div class="container">
        <div class="col-md-3">
            <%@include file="META-INF/jspf/sidebar.jspf"%>
        </div>
  <c:forEach items="${workWithJson.phoneJson}" var="elem">
        <div class="col-md-3">
            <br>
            <br>
            <img class="card-img-top" src="${elem.imgPath}" height="140" width="110" alt="Card image cap">
            <h4 class="card-text">${elem.name}</h4>
            <p class="card-text">${elem.diagonal}</p>
            <p class="card-text">${elem.wifi}</p>
            <p class="card-text">${elem.os}</p>
            <%--<a href="">Detail</a>--%>
        </div>
  </c:forEach>
    </div>
</div>

<%--<section>

        <c:forEach items="${workWithJson.json}" var="elem">
            <div class="card">
                <img class="card-img-top" src="${elem.name}" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${elem.cpu}</h5>
                    <p class="card-text">${elem.ram}</p>
                    <p class="card-text">${elem.hardMemory}</p>
                    <h5 class="card-title" style="color: red">${elem.videoCard}</h5>
                    <a href="#" class="btn btn-primary">GO</a>
                </div>
            </div>
        </c:forEach>
</section>--%>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="META-INF/jspf/footer.jspf"%>

</body>
</html>
