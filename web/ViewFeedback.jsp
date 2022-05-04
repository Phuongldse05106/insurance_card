<%-- 
    Document   : viewAllAccount
    Created on : Apr 20, 2022, 1:26:48 PM
    Author     : chubo
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Account Management</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <h2 class="col-lg-10 mx-auto justify-content-end" >Quản lý feedback</h2>
            </div>

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <nav class="navbar navbar-light justify-content-between">


                        <form class="form-inline" action="SearchAccountController" method="GET">
                            <input class="form-control mr-sm-2"name="search" type="search" placeholder="Tìm kiếm" aria-label="Tìm kiếm" value="${search}">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                        </form>
                    </nav>
                    <table id="datatable" class="table table-striped table-bordered mx-auto" cellspacing="0" width="70%">
                        <tr>
                            <th>ID</th>
                            <th>Họ và tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Message</th>
                            <th>Thao tác</th>
                        </tr>

                        <c:forEach var="i" items="${listFeed}" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${i.fullName}</td>
                                <td>${i.email}</td>
                                <td>${i.phone}</td>
                                <td>${i.message}</td>
                                <td>
                                    <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#view${i.id}" >
                                        <i class="fa-solid fa-eye"></i>
                                    </button>
                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit${i.id}" >
                                        <i class="fa-solid fa-pen"></i>
                                    </button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete${i.id}" >
                                        <i class="fa-solid fa-trash-can"></i>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>


                    <c:forEach var="i" items="${listFeed}">
                        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="view" aria-hidden="true" id="view${i.id}">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">                   
                                        <h4 class="modal-title custom_align" id="Heading">Chi tiết feedback</h4>

                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="inputRole">ID</label>
                                                    <input type="text" class="form-control" name="inputRole" value="${i.id}" readonly>
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label for="inputAccount">Họ và tên</label>
                                                    <input type="text" class="form-control" name="inputAccount" value="${i.fullName}" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="text" class="form-control" name="inputEmail" value="${i.email}" readonly>
                                            </div>

                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label>Số điện thoại</label>
                                                    <input type="phone" class="form-control" name="inputPhone" value="${i.phone}" readonly>
                                                    
                                                </div>
                                            </div>
                                                    <div class="form-group">
                                                        <label>Message</label>
                                                        <input type="text" class="form-control" name="inputMessage" value="${i.message}" readonly>
                                                    </div>
                                        </form>
                                    </div>

                                </div>
                                <!-- /.modal-content --> 
                            </div>
                            <!-- /.modal-dialog --> 
                        </div>

                                            <form action="DeleteFeedback">
                                                <div hidden>
                                                    <input name="id" value="${i.id}">
                                                </div>
                                                <div class="modal fade" id="delete${i.id}">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title custom_align" id="Heading">Xóa Feedback</h4>
                        
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span>Bạn chắc chắn muốn xóa tài khoản ${i.fullName} này chứ?</div>
                                                            </div>
                                                            <div class="modal-footer ">
                                                                <button type="submit" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Có</button>
                                                                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Không</button>
                                                            </div>
                                                        </div>
                                                         /.modal-content  
                                                    </div>
                                                     /.modal-dialog  
                                                </div>
                                            </form>
                                                            <!--


                    <div class="modal fade" id="edit${user.userId}">
                        <div class="modal-dialog">
                            <form action="UpdateAccountController" method="GET">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title custom_align" id="Heading">Chỉnh sửa tài khoản</h4>

                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="inputRole">Chức vụ</label>
                                                <select id="inputRole" class="form-control" name="roleId" value="${user.role}">
                                                    <option value="1">Admin</option>
                                                    <option value="2">Manager</option>
                                                    <option value="3">Doctor</option>
                                                    <option value="4">Customer</option>
                                                </select>                                    
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="inputAccount">Tài khoản</label>
                                                <input type="text" class="form-control" required maxlength="20" name="username" value="${user.username}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Họ và tên</label>
                                            <input type="text" class="form-control"required maxlength="20" name="fullName" value="${user.fullName}">
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="email" class="form-control"required maxlength="30" name="email" value="${user.email}">
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>Địa chỉ</label>
                                                <input type="text" class="form-control"required maxlength="30" name="address" value="${user.address}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Số điện thoại</label>
                                                <input type="tel" class="form-control"required maxlength="15" name="phone" value="${user.phone}" pattern="[0][0-9]{9}">

                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Ngày sinh</label>
                                                <input type="date" class="form-control" name="date" required id="inputBirthDate" value="${user.birthDate}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Giới tính</label>
                                                <select id="inputGender" class="form-control" name="gender" value="${user.gender == "true" ? "Nam" : "Nữ"}">
                                                    <option value="1">Nam</option>
                                                    <option value="2">Nữ</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6" hidden>
                                        <input type="text" class="form-control" name="userId" id="inputBirthDate" value="${user.userId}">
                                    </div>
                                    <div class="modal-footer ">
                                        <button type="submit" class="btn btn-primary btn-xs btn-lg col-md-6" style="width: 100%;">Lưu</button>
                                        <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-danger btn-lg col-md-6" style="width: 100%;">Hủy</button>
                                    </div>
                                </div>
                            </form>

                             /.modal-content  
                        </div>
                         /.modal-dialog  
                    </div>-->
                    </c:forEach>
                    <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
                    <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
                    <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
                    <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
                    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
                    <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
                    <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

                    <script>
                        function myFunction() {
                            document.getElementById("myForm").reset();
                        }
                    </script>
                    </body>
                    </html>
