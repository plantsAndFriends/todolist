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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">

    </head>
    <body>
        <jsp:setProperty  name="bean_signup" property="*" />
        <div class="container">
            <div class="row">
                <h1 class="text-center">Sign Up!</h1>
            </div>                    
        
            <% if(request.getParameter("username") == null) {%>
            <form method="post">
                <div class="form-group">
                    <label class="col-3">Username: </label>
                    <div class="col-6">
                        <input type="text" class="form-control" name="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-3">Email: </label>
                    <div class="col-6">
                        <input type="text" class="form-control" name="email"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-3">Password: </label>
                    <div class="col-6">
                        <input type="password" class="form-control" name="password"/>
                    </div>
                </div>            
                <div class="form-group">
                    <div class="col-sm-6 col-sm-offset-3">
                        <input class="form-control" role="button" type="submit" value="Sign Up" name="send" />
                    </div>                    
                </div>
            </form> 
            <%}else{%>
            <jsp:forward page="ControlRegistro?action=insertUser"/>
            <%}%>
        </div>        
        
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    </body>
</html>
