<%-- 
    Document   : contract-edit
    Created on : Apr 25, 2022, 12:31:12 AM
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
                <li class="breadcrumb-item text-sm text-dark active" aria-current="page">contract-edit</li>
              </ol>
              <h6 class="font-weight-bolder mb-0">Edit Contract</h6>
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
                      <h6 class="text-white text-capitalize ps-3">Chỉnh sửa hợp đồng</h6>
                    </div>
                  </div>
                  <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <form action="contract-edit?contractId=${contract.id}" method="POST" class="m-3 mx-3">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <h3 class="text-center">Người dùng</h3>
                                    <table>
                                        <tr>
                                            <td>Họ và tên: </td>
                                            <td style="padding-left: 10px"><b><c:out value = "${customer.fullname}"/></b></td>
                                        </tr>
                                        <tr>
                                            <td>Ngày sinh:  </td>
                                            <td  style="padding-left: 10px">
                                                <fmt:formatDate type = "date" dateStyle = "short" timeStyle = "short" value = "${customer.dob}" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Giới tính: </td>
                                            <c:if test = "${customer.gender == 1}">
                                                <td style="padding-left: 10px">Nam</td>
                                            </c:if>
                                            <c:if test = "${customer.gender == 0}">
                                                <td style="padding-left: 10px">Nữ</td>
                                            </c:if>
                                            
                                        </tr>
                                        <tr>
                                            <td>Số điện thoại: </td>
                                            <td style="padding-left: 10px"><c:out value = "${customer.phone}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Email: </td>
                                            <td style="padding-left: 10px"><c:out value = "${customer.email}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Địa chỉ: </td>
                                            <td style="padding-left: 10px"><c:out value = "${customer.address}"/></td>
                                        </tr>
                                    </table>
                                </div>
                                
                                <div class="form-group col-md-6">
                                    <h3 class="text-center">Hợp đồng</h3>
                                    <table>
                                        <tr>
                                            <td>Mã Hợp đồng: </td>
                                            <td style="padding-left: 10px"><c:out value = "${contract.id}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Nhân viên: </td>
                                            <td style="padding-left: 10px"><b><c:out value = "${staff.fullname}"/></b></td>
                                        </tr>
                                        <tr>
                                            <td>Ngày kích hoạt:  </td>
                                            <td  style="padding-left: 10px">
                                                <b><fmt:formatDate type = "date" dateStyle = "short" timeStyle = "short" value = "${contract.date}" /></b>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Phương tiện: </td>
                                            <td style="padding-left: 10px">
                                                <c:out value = "${bike.brand}"/> <c:out value = "${bike.color}"/> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Biển số: </td>
                                            <td style="padding-left: 10px">
                                                <c:out value = "${bike.lisence_plate}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Hình thức bảo hiểm: </td>
                                            <c:choose>
                                                <c:when test = "${contract.contract_type == 'electric motorcycle'}">
                                                   <td style="padding-left: 10px">Xe máy điện: 60.500đ/năm</td>
                                                </c:when>
                                                <c:when test = "${contract.contract_type == 'Under 50cc'}">
                                                   <td style="padding-left: 10px">Xe máy dưới 50cc: 60.500đ/năm</td>
                                                </c:when>
                                                <c:when test = "${contract.contract_type == 'Over 50cc'}">
                                                   <td style="padding-left: 10px">Xe máy (mô tô) trên 50cc: 66.000đ/năm</td>
                                                </c:when>
                                                <c:otherwise>
                                                   <td style="padding-left: 10px">Xe phân khối lớn (trên 175cc), các loại xe khác: 319.000đ/năm</td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                        <tr>
                                            <td>Trạng thái: </td>
                                            <c:choose>
                                                <c:when test = "${contract.status =='pending'}">
                                                    <td style="padding-left: 10px"><span class="badge badge-sm bg-gradient-warning">Chờ thanh toán</span></td>
                                                </c:when>
                                                <c:when test = "${contract.status =='accepted'}">
                                                    <td style="padding-left: 10px"><span class="badge badge-sm bg-gradient-success">Đã kích hoạt</span></td>
                                                </c:when>
                                                <c:otherwise>
                                                   <td style="padding-left: 10px"><span class="badge badge-sm bg-gradient-secondary">Đã hết hạn</span></td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <h2 class="text-center border-top border-secondary" style="padding: 20px">Thay đổi hợp đồng</h2>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputState">Hình thức bảo hiểm</label>
                                    <select name="contractType" value="${contract.contract_type}" class="form-control form-select" aria-label="Default select example">
                                      <option selected value="${contract.contract_type}">---- Hình thức bảo hiểm ----</option>
                                      <option value="electric motorcycle">Xe máy điện: 60.500đ/năm</option>
                                      <option value="Under 50cc">Xe máy dưới 50cc: 60.500đ/năm</option>
                                      <option value="Over 50cc">Xe máy (mô tô) trên 50cc: 66.000đ/năm</option>
                                      <option value="Over 175cc">Xe phân khối lớn (trên 175cc), các loại xe khác: 319.000đ/năm</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="date">Ngày tạo hợp đồng</label>
                                    <input type="date" class="form-control" name="contractDate" value="${contract.date}">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="inputState">Trạng thái</label>
                                    <select name="status" value="${contract.status}" class="form-control form-select" aria-label="Default select example">
                                      <option selected value="${contract.status}">---- Trạng thái bảo hiểm ----</option>
                                      <option value="pending">Chờ thanh toán</option>
                                      <option value="accepted">Đã kích hoạt</option>
                                      <option value="expired">Đã hết hạn</option>
                                      <option value="rejected">Đã ngừng sử dụng</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary text-center">Lưu thay đổi</button> 
                            <c:if test = "${success != null}"> 
                                <h3 style="color: greenyellow">Thành công</h3>
                            </c:if>
                        </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
      </main>
    </body>
</html>
