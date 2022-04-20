
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
                <h2 class="col-lg-10 mx-auto justify-content-end" >Danh sách hợp đồng</h2>
            </div>

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <nav class="navbar navbar-light justify-content-between">
                        <div style="color: red">
                            ${message}
                        </div>
                        <form class="form-inline" action="ViewContractController" method="GET">
                            <input class="form-control mr-sm-2"name="search" type="search" placeholder="Tìm kiếm" aria-label="Tìm kiếm" value="${search}">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                        </form>
                    </nav>
                    <table id="datatable" class="table table-striped table-bordered mx-auto" cellspacing="0" width="70%">
                        <tr>
                            <th><center>Mã hợp đồng</center></th>
                            <th><center>Tên hợp đồng</center></th>
                            <th><center>Mã số xe</center></th>
                            <th><center>Mã khách hàng</center></th>
                            <th><center>Ngày tạo</center></th>
                            <th><center>Trạng thái</center></th>
                            <th><center>Chi tiết</center></th>
                        </tr>
                        
                        <c:forEach var="contract" items="${contract}">
                            <tr>
                                <td><center>${contract.contractId}</center></td>
                                <td>${contract.nameame}</td>
                                <td>${contract.motoId}</td>
                                <td>${contract.userId}</td>
                                <td>${contract.date}</td>
                                <td>${contract.status}</td>
                            </tr>
                        </c:forEach>

                    </table>
                            
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
