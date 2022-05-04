<%-- 
    Document   : Feedback
    Created on : Apr 25, 2022, 5:32:12 PM
    Author     : my laptop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback Page</title>
        <link href="assets/css/homepage.css" rel="stylesheet" type="text/css"/>        
        <link href="assets/css/feedback1.css" rel="stylesheet" type="text/css"/>
        
</head>


<body>
    <div id="sideNav">
        <nav>
            <ul>
                <li><a href="HomePage.jsp">Home</a></li>
            </ul>
        </nav>
    </div>
    <div id="menuBtn">
        <img src="assets/img/menu.png" id="menu"/>

    </div>
    <div class="wrap">

        <form action="CreateFeedbackController" method="post">
            
            <h1>Feedback about us</h1>                    
            <label>Name*</label>
            <input  class="txt" type="text" name="name" placeholder="Nguyen Huy Hoang">
            <br/>
            <br/>
            <label>Email*</label>
            <input class="txt" type="text" name="email" placeholder="Hoangnhse05084@fpt.edu">
            <br/>
            <br/>
            <label>Phone*</label>
            <input class="txt" type="text" name="phone" placeholder="0962029497">
            <br/>
            <br/>
            <label>Message*</label> <a class="text-danger" style="color: red">${mess}</a>
            <br/>
            <br/>
            <textarea class="txtarea" name="message" placeholder="Write feedback here...!"></textarea>
            <input class="btn" type="submit" value="Sent feedback">
        </form>

    </div>
    <script>
        var menuBtn = document.getElementById("menuBtn");
        var sideNav = document.getElementById("sideNav");
        var menu = document.getElementById("menu");
        sideNav.style.right = "-250px";
        menuBtn.onclick = function () {
            if (sideNav.style.right == "-250px") {
                sideNav.style.right = "0";
                menu.src = "assets/img/close.png";
            } else {
                sideNav.style.right = "-250px";
                menu.src = "assets/img/menu.png";
            }
        }
    </script>
</body>
</html>
