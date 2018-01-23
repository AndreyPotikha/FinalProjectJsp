<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 21.01.18
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<script src="https://code.jquery.com/jquery.min.js"></script>--%>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <%--<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="css/sidebar.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>>--%>
</head>
<body>

<%@include file="META-INF/jspf/head.jspf"%>

<section>
    <div class="row">
        <div class="container">
            <div class="col-md-3">
                <%@include file="META-INF/jspf/sidebar.jspf"%>
            </div>
            <div class="col-md-7">
                <br>
                <br>
                <h3>Information site,
                    about novelties of computer technologies</h3>
            </div>
        </div>
    </div>
</section>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="META-INF/jspf/footer.jspf"%>



<%--<section>
    <div class="row">
        <div class="container">
            <div class="col-md-3">
            1
            </div>
            <div class="col-md-3">
            2
            </div>
            <div class="col-md-3">
3
            </div>
            <div class="col-md-3">
4
            </div>
        </div>
    </div>
</section>--%>


</body>
</html>
