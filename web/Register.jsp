<%-- 
    Document   : Register
    Created on : Apr 14, 2022, 11:36:38 PM
    Author     : my laptop
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
        <script src="https://kit.fontawesome.com/069a201b18.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Đăng ký</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <c:if test="${checkAdd != null}">
            <c:if test="${checkAdd == true}">
                <script>
                    $(document).ready(function () {
                        swal("Tạo tài khoản thành công !", "Yeahhh", "success");
                    });
                </script>
            </c:if>
            <c:if test="${checkAdd == false}">
                <script>
                    $(document).ready(function () {
                        swal("Tài khoản hoặc email đã tồn tại !", "Nhập lại", "error");
                    });
                </script>
            </c:if>
        </c:if>
        <c:if test="${checkPass != null}">
            <c:if test="${checkPass == false}">
                <script>
                    $(document).ready(function () {
                        swal("Mật khẩu không khớp !", "Nhập lại", "error");
                    });
                </script>
            </c:if>
        </c:if>

        <c:if test="${checkDate != null}">
            <c:if test="${checkDate == false}">
                <script>
                    $(document).ready(function () {
                        swal("Ngày sinh không phù hợp !", "Nhập lại", "error");
                    });
                </script>
            </c:if>
        </c:if>
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: #8fc4b7;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-8 col-xl-6">
                        <div class="card rounded-3">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2 mx-auto">Đăng ký</h3>
                                <form class="px-md-2" action="RegisterController" method="POST">
                                    
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Họ và tên<span class="text-danger"> *</span></label>
                                        <input type="text" id="form3Example1q" class="form-control" maxlength="30" required name="fullname" />
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Email<span class="text-danger"> *</span></label>
                                        <input type="email" id="form3Example1q" class="form-control" required maxlength="30" name="email"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Tên tài khoản<span class="text-danger"> *</span></label>
                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" required name="username" />
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Mật khẩu<span class="text-danger"> *</span></label>
                                        <input type="password" id="form3Example1q" class="form-control" required name="password"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Nhập lại mật khẩu<span class="text-danger"> *</span></label>
                                        <input type="password" id="form3Example1q" class="form-control" required name="repassword"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Ngày sinh<span class="text-danger" > *</span></label>
                                        <input type="date" id="form3Example1q" class="form-control" required name="birthDate"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Giới tính<span class="text-danger"> *</span></label>
                                        <br>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" value="1" checked />
                                            <label class="form-check-label" for="femaleGender">Nam</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" value="-1" />
                                            <label class="form-check-label" for="femaleGender">Nữ</label>
                                        </div>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Điện thoại<span class="text-danger"> *</span></label>
                                        <input type="tel" id="form3Example1q" class="form-control"  required name="phone" pattern="[0][0-9]{9}"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Địa chỉ<span class="text-danger"> *</span></label>
                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" required name="address"/>
                                    </div>
                                    <button type="submit" class="btn btn-success btn-lg mb-1 mb-md-5">Đăng ký</button>
                                </form>
                                <div style="color: red"> ${message}</div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
    </body>
</html>
