<%-- 
    Document   : ChangePassword
    Created on : Apr 25, 2022, 9:57:05 PM
    Author     : chubo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ChangePassword">
            <label for="oldPassword">Mật khẩu cũ:</label>
            <input type="Password" id="oldPassword" name="oldPassword"><br><br>
            <label for="newPassword">Mật khẩu mới:</label>
            <input type="password" id="newPassword" name="newPassword" minlength="8"><br><br>
             <label for="newPassword">Nhập lại mật khẩu mới:</label>
            <input type="password" id="newPasswordAgain" name="newPasswordAgain" minlength="8"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
