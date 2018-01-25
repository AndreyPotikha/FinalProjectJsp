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
    <title>New Table</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="/newTable" role="login">
                    <img src="image/table.jpg" class="img-responsive" alt="" width="310" height="300"/>
                    <input type="text" name="name" placeholder="Name" required class="form-control input-lg"/>
                    <input type="text" name="diagonal" placeholder="Diagonal" required class="form-control input-lg"/>
                    <input type="text" name="wifi" placeholder="Wifi" required class="form-control input-lg"/>
                    <input type="text" name="os" placeholder="os" required class="form-control input-lg"/>
                    <input type="text" name="imgPath" placeholder="Img Path" required class="form-control input-lg"/>

                    <div class="pwstrength_viewport_progress"></div>

                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Save</button>

                </form>

            </section>
        </div>

        <div class="col-md-4"></div>


    </div>



</div>

</body>
</html>
