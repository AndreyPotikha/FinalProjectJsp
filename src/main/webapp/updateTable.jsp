<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 26.01.18
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update table</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>

        <%
            String status = (String) session.getAttribute("userStatus");
        %>

        <%
            if (status.equals("Admin")) {
        %>
        <br>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="/updateTable" role="login">
                    <img src="image/phone.jpg" class="img-responsive" alt="" width="230" height="150"/>
                    <input type="text" name="name" placeholder="Name" value="<%= request.getAttribute("name")%>" required class="form-control input-lg"/>
                    <input type="text" name="diagonal" placeholder="Diagonal" value="<%= request.getAttribute("diagonal")%>" required class="form-control input-lg"/>
                    <input type="text" name="wifi" placeholder="Wifi" value="<%= request.getAttribute("wifi")%>" required class="form-control input-lg"/>
                    <input type="text" name="os" placeholder="OS" value="<%= request.getAttribute("os")%>" required class="form-control input-lg"/>
                    <input type="text" name="imgPath" placeholder="Img path" value="<%= request.getAttribute("imgPath")%>" required class="form-control input-lg"/>

                    <div class="pwstrength_viewport_progress"></div>

                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Save</button>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>

        <%}%>


    </div>



</div>

</body>
</html>
