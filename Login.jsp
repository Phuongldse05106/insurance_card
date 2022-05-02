<%-- 
    Document   : Login
    Created on : Apr 14, 2022, 6:26:28 PM
    Author     : chubo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <div class="form-login">
                <form action="LoginController" method="post">
                    <h1 class="form-heading">Login</h1>
                    <a class="text-danger">${mess}</a>

                    <div class="form-group">
                        <input name="username" type="text" class="form-input" placeholder="Username" >
                    </div>
                    <div class="form-group">
                        <input name="password" type="password" class="form-input" placeholder="Password">
                    </div>

                    <input type="submit" value="Login" class="form-submit">

                </form>
                <form action="" method="post">
                    <input type="submit" value="Register" class="form-submit">
                </form>
                <form action="" method="post">
                    <input type="submit" value="Quên mật khẩu" class="form-getPass">
                </form>
            </div>
        </div>
    </body>
</html>
