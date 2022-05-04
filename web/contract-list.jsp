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
<!--                            <div class="row">
                                <div class="col-md-4">
                                    <button type="button" class="btn btn-secondary" 
                                            style="width: 150px; margin: 20px 0 0 100px">
                                        Tất cả
                                    </button>
                                </div>
                                <div class="col-md-4">
                                    <button type="button" class="btn btn-primary"  
                                            style="width: 150px; margin: 20px 0 0 100px"
                                            href="/contract-expired">
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
                            </div>-->
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
                                                <form action="contract-delete" method="POST">
                                                    <a href="contract-detail?contractId=${contract.id}"
                                                    class="btn btn-primary"
                                                    data-toggle="tooltip"
                                                    data-original-title="Edit user"
                                                    >
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                                            <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                                            <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                                        </svg>
                                                    </a>
                                                    <a href="contract-edit?contractId=${contract.id}"
                                                    class="btn btn-primary"
                                                    data-toggle="tooltip"
                                                    data-original-title="Edit user"
                                                    >
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                                        </svg>
                                                    </a>
                                                    <input type="hidden" name="contractId" value="${contract.id}">
                                                    <button type="submit" class="btn btn-danger ">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                                            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                                        </svg>
                                                    </button>
                                                </form>
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
