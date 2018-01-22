<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 20.01.18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="#" role="login">
                    <img src="image/mainpage.png" class="img-responsive" alt="" width="300" height="110"/>
                    <input type="email" name="email" placeholder="Email" required class="form-control input-lg"/>

                    <input type="password" class="form-control input-lg" id="password" placeholder="Password" required="" />


                    <div class="pwstrength_viewport_progress"></div>


                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
                    <div>
                        <a href="registration.jsp">Create account</a> or <a href="resetPassword.jsp">reset password</a>
                    </div>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>


    </div>

    <p>
        <%--<a href="http://validator.w3.org/check?uri=http%3A%2F%2Fbootsnipp.com%2Fiframe%2FW00op" target="_blank"><small>HTML</small><sup>5</sup></a>--%>
        <br>
        <br>

    </p>


</div>

</body>
</html>
