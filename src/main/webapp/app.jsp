<%-- 
    Document   : app
    Created on : 24-abr-2017, 19:11:15
    Author     : Adria Viñas
--%>

<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="model.bd.DAOTask"%>
<%@ page import="model.pojo.BeanTask"%>
<%@ page import="model.pojo.BeanUser"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css" />

        <title>Todolist App</title>
    </head>
    <body>
        <div id="nav-container">
            <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"  aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand ml-5" href="index.html">Todolist</a>
                <div class="collapse navbar-collapse col-md-2" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <%= session.getAttribute("sessusername")%>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="ControlLogin?action=logout">Logout</a>
                            </div>
                        </div>
                    </ul>
                </div>
            </nav>
        </div>

        <div class="container justify-content-center">
            <h1 class="text-center">Tasks</h1>            
            <form class="form-inline mt-5" action="ControlTask?action=addTask" method="post">
                <div class="input-group col-md-6 offset-3">    

                    <input type="text" class="form-control" name="task" placeholder="Create a task" />

                    <span class="input-group-btn">
                        <button id="buttonadd" class="btn btn-secondary" type="submit">+</button><
                    </span>
                </div>
            </form>


        </div>        

        <div class="container mt-5">
            <div class="row">
                <div class="col-sm-8 offset-2">                    
                    <%
                        int cont = 0;
                        DAOTask task = new DAOTask();
                        int id = Integer.parseInt(session.getAttribute("sessid").toString());
                        ArrayList<BeanTask> beanTask = task.getTasks(id);
                        Collections.reverse(beanTask);

                        if (task != null) {
                            out.println("<div id='accordion' role='tablist' aria-multiselectable='true' class='text-center'>");
                            for (BeanTask ts : beanTask) {
                                out.println("<div class='card mb-2'>");
                                out.println("<div class='card-header' role='tab' id=heading" + cont + " >");
                                out.println("<h5>");
                                if (request.getAttribute("time") != null) {
                                    out.print("<span class='pull-left'>" + request.getAttribute("time") + "</span>");
                                    request.removeAttribute("time");
                                } else {
                                    out.println("<span class='test'></span>");
                                }
                                out.println("<div class='d-flex justify-content-center'><a class='collapsed' data-toggle='collapse' data-parent='#accordion' href='#collapse" + cont + "' aria-expanded='false' aria-controls='collapse" + cont + "' >" + ts.getTask() + "</a></div>");
                                out.println("<div class='d-flex flex-row-reverse'>");

                                // Trash
                                out.println("<span><a href='ControlTask?action=removeTask&id=" + ts.getId() + "'><i class='fa fa-trash' aria-hidden='true'></i></a></span>");

                                // Done
                                out.println("<span class='pr-3'><a href='ControlTask?action=doneTask&id=" + ts.getId() + "'><i class='fa fa-check' aria-hidden='true'></i></a></span>");

                                out.println("</div>");
                                out.println("</h5>");
                                out.println("</div>");
                                out.println("<div id='collapse" + cont + "' class='collapse' role='tabpanel' aria-labelledby=heading" + cont + " >");
                                out.println("<div class='card-block text-center'>");

                                // Start
                                //out.println("<span class=''><a href='ControlTask?action=start&id=" + ts.getId() + "'><button class='btn btn-secondary play'><i class='fa fa-play' aria-hidden='true'></i></button></a></span>");
                                out.println("<span class=''><button onclick='getStartedAt("+ts.getId()+")' class='btn btn-secondary play'><i class='fa fa-play' aria-hidden='true'></i></button></a></span>");
                                // Pause                               
                                out.println("<span class=''><a href='ControlTask?action=pause&id=" + ts.getId() + "'><button class='btn btn-secondary pause'><i class='fa fa-stop' aria-hidden='true'></i></button></a></span>");

                                out.println("<p id='totalTime'></p>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</div>");

                                cont++;
                            }

                            out.println("</div>");
                        }
                    %>                    
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

        <script>
            
            $(document).ready(function () {
               $('.pause').prop('disabled', true);
            });
            
            $('.fa-check').click(function () {
                $(this).parents('.card-header').addClass('alert alert-success');
                $(this).parents('.card').addClass('animated fadeOutRight');
            });

            $('.fa-trash').click(function () {
                $(this).parents('.card').addClass('animated zoomOut');
            });
            
            function getStartedAt(id){
                $.get("ControlTask?action=start&id="+id, function(data, status){
                    alert(data);
                    $('.play').prop('disabled', true);
                    $('.pause').prop('disabled', false);
                });
            }

            $('.play').click(function () {
                /*var getParameter = function getParameter(param) {
                 var url = decodeURIComponent(window.location.search.substring(1)),
                 variables = url.split('&'),
                 paramName,
                 i;
                 
                 for (i = 0; i < variables.length; i++) {
                 paramName = variables[i].split('=');
                 
                 if (paramName[0] === param) {
                 return paramName[1] === undefined ? true : paramName[1];
                 }
                 }
                 }*/


                alert(id);
                /*$.ajax({
                 url: 'http://localhost:8080/provatodolistCopy/ControlTask?action=getStarted&id='+id;
                 success: function(response) {
                 alert(id);
                 }
                 });*/
                //$('.pause').prop('disabled', false);
            });

            /*if ($('.play').data('clicked')) {
             $('.pause').prop('disabled', true);
             console.log("play");
             }*/

            $('.pause').click(function () {
                $('.play').prop('disabled', true);
            });
        </script>
    </body>
</html>
