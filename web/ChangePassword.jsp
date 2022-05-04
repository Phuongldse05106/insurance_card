<%-- 
    Document   : ChangePassword
    Created on : Apr 25, 2022, 9:57:05 PM
    Author     : chubo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        .mainDiv {
            display: flex;
            min-height: 100%;
            align-items: center;
            justify-content: center;
            background-color: #f9f9f9;
            font-family: 'Open Sans', sans-serif;
        }
        .cardStyle {
            width: 500px;
            border-color: white;
            background: #fff;
            padding: 36px 0;
            border-radius: 4px;
            margin: 30px 0;
            box-shadow: 0px 0 2px 0 rgba(0,0,0,0.25);
        }
        #signupLogo {
            max-height: 100px;
            margin: auto;
            display: flex;
            flex-direction: column;
        }
        .formTitle{
            font-weight: 600;
            margin-top: 20px;
            color: #2F2D3B;
            text-align: center;
        }
        .inputLabel {
            font-size: 12px;
            color: #555;
            margin-bottom: 6px;
            margin-top: 24px;
        }
        .inputDiv {
            width: 70%;
            display: flex;
            flex-direction: column;
            margin: auto;
        }
        input {
            height: 40px;
            font-size: 16px;
            border-radius: 4px;
            border: none;
            border: solid 1px #ccc;
            padding: 0 11px;
        }
        input:disabled {
            cursor: not-allowed;
            border: solid 1px #eee;
        }
        .buttonWrapper {
            margin-top: 40px;
        }
        .submitButton {
            width: 70%;
            height: 40px;
            margin: auto;
            display: block;
            color: #fff;
            background-color: #065492;
            border-color: #065492;
            text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.12);
            box-shadow: 0 2px 0 rgba(0, 0, 0, 0.035);
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        }
        .submitButton:disabled,
        button[disabled] {
            border: 1px solid #cccccc;
            background-color: #cccccc;
            color: #666666;
        }

        #loader {
            position: absolute;
            z-index: 1;
            margin: -2px 0 0 10px;
            border: 4px solid #f3f3f3;
            border-radius: 50%;
            border-top: 4px solid #666666;
            width: 14px;
            height: 14px;
            -webkit-animation: spin 2s linear infinite;
            animation: spin 2s linear infinite;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!
       
    </head>
    <body>
        <!--        <form action="ChangePassword">
                    <label for="oldPassword">Mật khẩu cũ:</label>
                    <input type="Password" id="oldPassword" name="oldPassword"><br><br>
                    <label for="newPassword">Mật khẩu mới:</label>
                    <input type="password" id="newPassword" name="newPassword" minlength="8"><br><br>
                     <label for="newPassword">Nhập lại mật khẩu mới:</label>
                    <input type="password" id="newPasswordAgain" name="newPasswordAgain" minlength="8"><br><br>
                    <input type="submit">
                </form>-->

        <div class="mainDiv">
            <div class="cardStyle">
                <form action="ChangePassword" method="post" name="signupForm" id="signupForm">

                    <img src="" id="signupLogo"/>

                    <h2 class="formTitle">
                        Change Password
                    </h2>
                    <div style="text-align: center" ><a class="text-danger text-center" style="color: red">${mess}</a>
                    </div>
                        

                    <div class="inputDiv">
                        <label class="inputLabel" for="oldPassword">Mật khẩu cũ</label>
                        <input type="password" id="oldPassword" name="oldPassword" required>
                    </div>
                    <div class="inputDiv">
                        <label class="inputLabel" for="newPassword">Mật khẩu mới</label>
                        <input type="password" id="newPassword" name="newPassword" required>
                    </div>

                    <div class="inputDiv">
                        <label class="inputLabel" for="confirmPassword">Nhập lại mật khẩu mới</label>
                        <input type="password" id="newPasswordAgain" name="newPasswordAgain">
                    </div>

                    <div class="buttonWrapper">
                        <button type="submit" id="submitButton" onclick="validateSignupForm()" class="submitButton pure-button pure-button-primary">
                            <span>Xác nhận</span>
                            <span id="loader"></span>
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </body>

    <script>
        var password = document.getElementById("password")
                , confirm_password = document.getElementById("confirmPassword");

        document.getElementById('signupLogo').src = "https://s3-us-west-2.amazonaws.com/shipsy-public-assets/shipsy/SHIPSY_LOGO_BIRD_BLUE.png";
        enableSubmitButton();

        function validatePassword() {
            if (password.value != confirm_password.value) {
                confirm_password.setCustomValidity("Passwords Don't Match");
                return false;
            } else {
                confirm_password.setCustomValidity('');
                return true;
            }
        }

        password.onchange = validatePassword;
        confirm_password.onkeyup = validatePassword;

        function enableSubmitButton() {
            document.getElementById('submitButton').disabled = false;
            document.getElementById('loader').style.display = 'none';
        }

        function disableSubmitButton() {
            document.getElementById('submitButton').disabled = true;
            document.getElementById('loader').style.display = 'unset';
        }

        function validateSignupForm() {
            var form = document.getElementById('signupForm');

            for (var i = 0; i < form.elements.length; i++) {
                if (form.elements[i].value === '' && form.elements[i].hasAttribute('required')) {
                    console.log('There are some required fields!');
                    return false;
                }
            }

            if (!validatePassword()) {
                return false;
            }

            onSignup();
        }

        function onSignup() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {

                disableSubmitButton();

                if (this.readyState == 4 && this.status == 200) {
                    enableSubmitButton();
                }
                else {
                    console.log('AJAX call failed!');
                    setTimeout(function () {
                        enableSubmitButton();
                    }, 1000);
                }

            };

            xhttp.open("GET", "ajax_info.txt", true);
            xhttp.send();
        }
    </script>
</html>



