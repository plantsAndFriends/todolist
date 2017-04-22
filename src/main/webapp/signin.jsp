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
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <div class="container">
            <%
                /*if (exception.getCause() instanceof InvalEa
                        ) {
                out.print("missatge a mostrar");
                } else {
                    out.print("asdf");

                }*/
            %>
            <h1 class="text-center mt-5 mb-5">Sign in to Plants</h1>
            
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
            
            
            <%} else {%>
            <jsp:forward page="ControlLogin?accio=login"/>
            <%}%>
        </div>
        
            <div class="error>"<%= ${error_msg} %></div>
        

    </body>
</html>
