<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 25.01.18
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Laptop</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>

    <%
        String status = (String) session.getAttribute("userStatus");
    %>

    <%
        if (status.equals("Admin")) {
    %>

    <br>

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="/newLaptop" role="login">
                    <img src="image/laptop.jpg" class="img-responsive" alt="" width="300" height="300"/>
                    <input type="text" name="name" placeholder="Name" required class="form-control input-lg"/>
                    <input type="text" name="cpu" placeholder="Cpu" required class="form-control input-lg"/>
                    <input type="text" name="ram" placeholder="Ram" required class="form-control input-lg"/>
                    <input type="text" name="videoCard" placeholder="Video Card" required class="form-control input-lg"/>
                    <input type="text" name="hardMemory" placeholder="Hard" required class="form-control input-lg"/>
                    <input type="text" name="imgPath" placeholder="Img path" required class="form-control input-lg"/>

                    <div class="pwstrength_viewport_progress"></div>

                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Save</button>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>


    </div>

    <%}%>


</div>

</body>
</html>
