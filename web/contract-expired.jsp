<%-- 
    Document   : list-contract
    Created on : Apr 24, 2022, 5:30:15 PM
    Author     : Duongdt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách hợp đồng</title>
        
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
                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">contract-list</li>
                  </ol>
                  <h6 class="font-weight-bolder mb-0">List Contract</h6>
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
            <div class="container-fluid py-4">
                <div class="row">
                    <div class="col-12">
                        <div class="card my-4">
                            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                                <div
                                    class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3"
                                >
                                <h6 class="text-white text-capitalize ps-3">Danh sách hợp đồng</h6>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <button type="button" class="btn btn-secondary" 
                                            style="width: 150px; margin: 20px 0 0 100px">
                                        Tất cả
                                    </button>
                                </div>
                                <div class="col-md-4">
                                    <button type="button" class="btn btn-primary"  
                                            style="width: 150px; margin: 20px 0 0 100px"
                                            href="">
                                        Hết hạn
                                    </button>
                                </div>
                                <div class="col-md-4">
                                    <button type="button" class="btn btn-primary" 
                                            style="width: 150px; margin: 20px 0 0 100px"
                                            href="">
                                        Đang chờ
                                    </button>
                                </div>
                            </div>
                        <div class="card-body px-0 pb-2">
                        <div class="table-responsive p-0">
                          <table class="table align-items-center mb-0">
                            <thead>
                              <tr>
                                <th
                                  class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                >
                                  Người Dùng
                                </th>
                                <th
                                  class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
                                >
                                  Số điện thoại
                                </th>
                                <th
                                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                >
                                  Trạng thái
                                </th>
                                <th
                                  class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                                >
                                  Ngày tạo Hợp Đồng
                                </th>
                                <th class="text-secondary opacity-7"></th>
                              </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listContract}" var="contract">
                                    <tr>
                                        <td>
                                            <div class="d-flex px-2 py-1">
                                              <div
                                                class="d-flex flex-column justify-content-center"
                                              >
                                                <h6 class="mb-0 text-sm">${contract.fullname}</h6>
                                                <p class="text-xs text-secondary mb-0">
                                                  ${contract.email}
                                                </p>
                                              </div>
                                            </div>
                                          </td>
                                          <td class="align-middle">
                                            <span class="text-secondary text-xs font-weight-bold">
                                              ${contract.phone}
                                            </span>
                                          </td>
                                          <c:choose>
                                                <c:when test = "${contract.status == 'pending'}">
                                                   <td class="align-middle text-center text-sm">
                                                       <span class="badge badge-sm bg-gradient-warning">Chờ thanh toán</span>
                                                   </td>
                                                </c:when>
                                                <c:when test = "${contract.status == 'accepted'}">
                                                   <td class="align-middle text-center text-sm">
                                                       <span class="badge badge-sm bg-gradient-success">Đã kích hoạt</span>
                                                       </td>
                                                </c:when>
                                                       <c:when test = "${contract.status == 'expired'}">
                                                   <td class="align-middle text-center text-sm">
                                                       <span class="badge badge-sm bg-gradient-danger">Đã hết hạn</span>
                                                       </td>
                                                </c:when>
                                                <c:otherwise>
                                                   <td class="align-middle text-center text-sm">
                                                       <span class="badge badge-sm bg-gradient-secondary">Bị từ chối</span>
                                                   </td>
                                                </c:otherwise>
                                            </c:choose>
<!--                                          <td class="align-middle text-center text-sm">
                                            <span class="badge badge-sm bg-gradient-success"
                                              ></span
                                            >
                                          </td>-->
                                          <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">
                                                <fmt:formatDate type = "date" dateStyle = "short" timeStyle = "short" value = "${contract.date}"/>
                                            </span>
                                          </td>
                                          <td class="align-middle">
                                            <a
                                              href="contract-edit?contractId=${contract.id}"
                                              class="text-secondary font-weight-bold text-xs"
                                              data-toggle="tooltip"
                                              data-original-title="Edit user"
                                            >
                                              Sửa
                                            </a>
                                            <a
                                              href="contract-edit?contractId=${contract.id}"
                                              class="text-secondary font-weight-bold text-xs"
                                              data-toggle="tooltip"
                                              data-original-title="Edit user"
                                            >
                                              Từ chối
                                            </a>
                                          </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                          </table>
                    </div>
                  </div>
                </div>
            </div>
        </main>
    </body>
</html>
