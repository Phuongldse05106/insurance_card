<%-- 
    Document   : contruct-create
    Created on : Apr 20, 2022, 9:51:10 AM
    Author     : Duongdt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contract Create</title>
       
        <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="./assets/img/favicon.png">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
        <!-- Nucleo Icons -->
        <link href="./assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="./assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link id="pagestyle" href="./assets/css/material-dashboard.css?v=3.0.2" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body class="g-sidenav-show  bg-gray-200">
      <jsp:include page="side-menu.jsp"/>
      <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
        <!-- Navbar -->
        <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" navbar-scroll="true">
          <div class="container-fluid py-1 px-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Pages</a></li>
                <li class="breadcrumb-item text-sm text-dark active" aria-current="page">contract-create</li>
              </ol>
              <h6 class="font-weight-bolder mb-0">Create Contract</h6>
            </nav>
            <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
              <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                <div class="input-group input-group-outline">
                  <label class="form-label">Tìm kiếm...</label>
                  <input type="text" class="form-control">
                </div>
              </div>
            </div>
          </div>
        </nav>
        <!-- End Navbar -->
        <div class="container-fluid py-4">
            <div class="row">
              <div class="col-12">
                <div class="card my-4">
                  <div
                    class="card-header p-0 position-relative mt-n4 mx-3 z-index-2"
                  >
                    <div
                      class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3"
                    >
                      <h6 class="text-white text-capitalize ps-3">Tạo hợp đồng</h6>
                    </div>
                  </div>
                  <div class="card-body px-0 pb-2">
                    <div action="contract-create" method="POST" class="table-responsive p-0">
                        <form action="contract-create" method="POST" class="m-3 mx-3">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="inputState">Người Dùng Trong Hệ Thống</label>
                                    <select name="customerId" class="form-control form-select" aria-label="Default select example">
                                        <option selected value="null">---- Người dùng ----</option>
                                        <c:forEach items="${listCustomer}" var="customer">
                                            <option value="${customer.user_id}">${customer.fullname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-2" style="float: bottom">
                                    <label>Người Dùng Mới</label>
                                    <br>
                                    <button type="button" class="btn btn-primary">Tạo tài khoản</button>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputState">Nhân viên*</label>
                                    <select name="staffId" class="form-control form-select" aria-label="Default select example">
                                        <option selected value="null">---- Nhân viên ----</option>
                                        <c:forEach items="${listStaff}" var="staff">
                                            <option value="${staff.user_id}">${staff.fullname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
<!--                              <div class="form-group col-md-6">
                                <label for="inputEmail4">Ngày tạo hợp đồng*</label>
                                <input type="date" class="form-control" name="contractDate" placeholder="Email">
                              </div>-->
                              <div class="form-group col-md-12">
                                    <label for="inputState">Hình thức bảo hiểm*</label>
                                    <select name="contractType" class="form-control form-select" aria-label="Default select example">
                                      <option selected value="null">---- Hình thức bảo hiểm ----</option>
                                      <option value="electric motorcycle">Xe máy điện: 60.500đ/năm</option>
                                      <option value="Under 50cc">Xe máy dưới 50cc: 60.500đ/năm</option>
                                      <option value="Over 50cc">Xe máy (mô tô) trên 50cc: 66.000đ/năm</option>
                                      <option value="Over 175cc">Xe phân khối lớn (trên 175cc), các loại xe khác: 319.000đ/năm</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Đăng kí</button> 
                            <c:if test = "${success != null}"> 
                                <h3 style="color: greenyellow">Thành công</h3>
                                <h5 style="color: orange">Đang chờ thanh toán</h5>
                            </c:if>
                            <div class="form-row">
                                <c:if test = "${customer != null}">
                                    <div class="form-group col-md-6">
                                        <h4>Khách hàng:</h4>
                                        <p>Họ và tên: <c:out value = "${customer.fullname}"/></p>
                                        <p>Email: <c:out value = "${customer.email}"/></p>
                                        <p>Phone: <c:out value = "${customer.phone}"/></p>
                                        <p>Địa chỉ: <c:out value = "${customer.address}"/></p>
                                        <p>Xe: <c:out value = "${bike.brand}"/> <c:out value = "${bike.color}"/></p>
                                        <p>Biển số: <c:out value = "${bike.lisence_plate}"/></p>
                                    </div>
                                </c:if>
                                 <c:if test = "${staff != null }">
                                    <div class="form-group col-md-6">
                                        <h4>Nhân viên:</h4>
                                        <p>Họ và tên: <c:out value = "${staff.fullname}"/></p>
                                        <p>Email: <c:out value = "${staff.email}"/></p>
                                        <p>Phone: <c:out value = "${staff.phone}"/></p>
                                        <p>Địa chỉ: <c:out value = "${staff.address}"/></p>
                                    </div>
                                </c:if>
                            </div>
                        </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
      </main>
<!--      <div class="fixed-plugin">
        <a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
          <i class="material-icons py-2">settings</i>
        </a>
      </div>-->
      
      <!-- Github buttons -->
      <script async defer src="https://buttons.github.io/buttons.js"></script>
      <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
      <script src="./assets/js/material-dashboard.min.js?v=3.0.2"></script>
    </body>
</html>
