<%-- 
    Document   : signin
    Created on : 31-mar-2017, 17:59:40
    Author     : clara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css"/>
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <jsp:setProperty  name="bean_signin" property="*" />
        <div id="nav-container">
            <nav class="navbar navbar-toggleable-md navbar-light bg-faded container-fluid fixed-top" data-spy="affix">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data--target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link page-scroll navbar-brand text-center ml-5" href="index.html">Todolist</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link page-scroll text-center ml-5" href="#">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link page-scroll text-center ml-5" href="signup.jsp">Sign up</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container mt-5">
            <%
                /*if (exception.getCause() instanceof InvalEa
                 ) {
                 out.print("missatge a mostrar");
                 } else {
                 out.print("asdf");

                 }*/
            %>
            <h1 class="text-center pt-5 mb-5">Sign in to Plants</h1>

            <% if (request.getParameter("email") == null) {%>

            <form class="form-horizontal" method="post">
                <div class="form-group mb-2">
                    <div class="col-md-4 offset-4">
                        <input type="text" class="form-control" name="email" placeholder="Your email" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 offset-4">
                        <input type="password" class="form-control" name="password"  placeholder="Your password" />
                    </div>
                </div>            
                <div class="form-group mt-5">
                    <div class="col-md-4 offset-4">
                        <button class="btn btn-success" value="signin">Sign in</button>
                    </div>                    
                </div>
            </form> 
            <% } else { %>
            <jsp:forward page="ControlLogin?accio=login"/>
            <% }%>
        </div>

        <!--<div class="error">
        <%-- <%= ${error_msg} %> --%>
     </div>-->


    </body>
</html>
