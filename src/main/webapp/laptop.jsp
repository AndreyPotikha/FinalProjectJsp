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
</head>
<body>

<jsp:useBean id="workWithJson" scope="application" class="service.WorkWithJson"/>

<%@include file="META-INF/jspf/head.jspf"%>


<section>
    <form method="get" action="/login" role="login">
    <div class="row">
        <div class="container">
            <div class="col-md-3">
                <%@include file="META-INF/jspf/sidebar.jspf"%>
            </div>
            <div class="list-group" style="width: 500px">
                <c:forEach items="${workWithJson.json}" var="elem">
                    <a href="#" class="list-group-item list-group-item-action">${elem.name}</a>
                </c:forEach>
            </div>
            <div class="col-md-3">
1
            </div>
            <div class="col-md-3">
2
            </div>
        </div>
    </div>
    </form>
</section>

<div>
    <button type="submit" class="btn btn-primary">OK</button>
</div>
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
