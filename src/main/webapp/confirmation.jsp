<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 20.01.18
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>


<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="/confirm" role="login">
                    <img src="image/mainpage.png" class="img-responsive" alt="" width="300" height="110"/>
                    <input type="text" name="confirm" placeholder="Confirm" required class="form-control input-lg"/>

                    <div class="pwstrength_viewport_progress"></div>

                    <div>
                        <button type="submit" class="btn btn-primary">Confirm</button>
                    </div>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>


    </div>

    <p>
        <br>
        <br>

    </p>


</div>

</body>
</html>
