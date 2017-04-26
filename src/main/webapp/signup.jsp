<%-- 
    Document   : signup
    Created on : 31-mar-2017, 17:46:17
    Author     : Adria Viñas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean_signup" scope="request" class="model.pojo.BeanUser" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-eq.javauiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css"/>

        <title>JSP Page</title>
    </head>
    <body>
        <jsp:setProperty  name="bean_signup" property="*" />
        <div id="nav-container">
            <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"  aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand ml-5" href="index.html">Todolist</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav text-center">
                        <li class="nav-item ">
                            <a class="nav-link  ml-5 pt-2" href="signin.jsp">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ml-5 pt-2" href="#">Sign up</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container mt-5">
            <h1 class="text-center pt-5">Sign up to Todolist</h1>
            <% 
               out.print(request.getAttribute("messageFinal"));
            %>

            <% if (request.getParameter("username") == null) { %>           
            <form class="form-horizontal" method="post">
                <div class="form-group mt-5">
                    <div class="input-group col-md-4 offset-4">
                        <span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="username" placeholder="Your username" required />
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group col-md-4 offset-4">
                        <span class="input-group-addon">@</span>
                        <input type="text" class="form-control" name="email" placeholder="Your email" required />
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group col-md-4 offset-4">
                        <span class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></span>
                        <input type="password" class="form-control" name="password"  placeholder="Your password" required />
                    </div>
                </div>            
                <div class="form-group  mt-5">
                    <div class="col-md-4 offset-4">
                        <button class="btn btn-success" value="signin">Sign up</button>
                    </div>                    
                </div>
            </form> 

            <% } else { %>
            <jsp:forward page="ControlRegistro?action=insertUser"/>
            <% }%>

        </div>        

        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    </body>
</html>
