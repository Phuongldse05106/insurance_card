<%-- 
    Document   : HomePage
    Created on : Apr 22, 2022, 2:27:01 PM
    Author     : my laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePage</title>
        <link href="assets/css/homepage.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdn.jsdelivr.net/gh/cferdinandi/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>

    </head>
    <body>
        <section id="banner">
            <div class="banner-text">
                <h1>Insurance online</h1>
                <p>Hãy thôi lo về những ổ gà trên đường và tận hưởng cuộc hành trình</p>
                <div class="banner-btn">
                    <a href="Login.jsp"><span></span>Đăng nhập</a>
                    <a href="Register.jsp"><span></span>Đăng ký</a>
                </div>
            </div>
        </section>
        
        <div id="sideNav">
            <nav>
                <ul>
                   
                    <li><a href="#banner">Home</a></li>
                    <li><a href="#feature">Feature</a></li>
                    <li><a href="#service">Services</a></li>
                    <li><a href="#people-say">About Me</a></li>
                    <li><a href="#footer">Footer</a></li>
                    <li><a href="#">Login</a></li>
                    <li><a href="Register.jsp">Register</a></li>
                    <li><a href="Feedback.jsp" >Feedback</a></li>
                </ul>
            </nav>
        </div>
       
                            
                            
        <div id="menuBtn">
            
            <img src="assets/img/menu.png" id="menu"/>

        </div>

        <section id="feature">
            <div class="title-text">
                <p>FEATURES</p>
                <h1>Bảo Hiểm Xe Máy</h1>
            </div>
            <div class="feature-box">
                <div class="features">
                    <h1>Quyền lợi Của Bảo Hiểm Xe Máy</h1>
                    <div class="features-desc">
                        <div class="feature-icon">
                            <i class="fa fa-shield"></i>
                        </div>
                        <div class="feature-text">
                            <p>Khi tai nạn xảy ra, trong phạm vi mức trách nhiệm bảo hiểm, doanh nghiệp bảo hiểm phải bồi thường cho người được bảo hiểm số tiền mà người được bảo hiểm đã bồi thường hoặc sẽ phải bồi thường cho người bị thiệt hại.</p>
                        </div>
                    </div>
                    <div class="features-desc">
                        <div class="feature-icon">
                            <i class="fa fa-shield"></i>
                        </div>
                        <div class="feature-text">
                            <p>Trường hợp người được bảo hiểm chết, mất năng lực hành vi dân sự theo quyết định của Tòa án, doanh nghiệp bảo hiểm bồi thường trực tiếp cho người bị thiệt hại hoặc người thừa kế của người bị thiệt hại (trong trường hợp người bị thiệt hại đã chết) hoặc đại diện của người bị thiệt hại.</p>
                        </div>
                    </div>
                    <div class="features-desc">
                        <div class="feature-icon">
                            <i class="fa fa-shield"></i>
                        </div>
                        <div class="feature-text">
                            <p>Khi bị công an giao thông bắt, người điều khiển xe máy sẽ không bị phạt về vấn đề không có bảo hiểm xe.</p>
                        </div>
                    </div>
                </div>
                <div class="features-img">
                    <img src="assets/img/baohiem2.jpg">
                </div>
            </div>
        </section>
        
        <section id="service">
            <div class="title-text">
                <p>SERVICE</p>
                <h1>We provide Better</h1>
            </div>
            <div class="service-box">
                <div class="single-service">
                    <img src="assets/img/momo4.jpg">
                    <div class="overlay"></div>
                    <div class="service-decs">
                        <h3>Thanh toán online</h3>
                        <hr>
                        <p>Thanh toán qua momo</p>
                    </div>
                </div>
                <div class="single-service">
                    <img src="assets/img/momo4.jpg">
                    <div class="overlay"></div>
                    <div class="service-decs">
                        <h3>Thanh toán online</h3>
                        <hr>
                        <p>Thanh toán qua ví AirPay</p>
                    </div>
                </div>
                <div class="single-service">
                    <img src="assets/img/momo4.jpg">
                    <div class="overlay"></div>
                    <div class="service-decs">
                        <h3>Thanh toán online</h3>
                        <hr>
                        <p>Thanh toán qua QRCode</p>
                    </div>
                </div>
                <div class="single-service">
                    <img src="assets/img/momo4.jpg">
                    <div class="overlay"></div>
                    <div class="service-decs">
                        <h3>Thanh toán online</h3>
                        <hr>
                        <p>Thanh toán qua Chuuyển Khoản Ngân Hàng</p>
                    </div>
                </div>
            </div>
        </section>

        <section id="people-say">
            <div class="title-text">
                <p>About Me</p>
                <h1>What People Says</h1>
            </div>
            <div class="people-row">
                <div class="people-col">
                    <div class="users">
                        <img src="assets/img/hoangvip1.jpg">
                        <div class="user-info">
                            <h4>Hoàng Trầm Cảm</h4>
                        </div>
                    </div>
                    <p>Đừng từ chối bất cứ cơ hội nào để đi.Khi bạn đã có bảo hiểm,hãy mua bảo hiểm nhanh nhất khi bạn còn có thể di.</p>
                </div>
                <div class="people-col">
                    <div class="users">
                        <img src="assets/img/huong.jpg">
                        <div class="user-info">
                            <h4>Hương Hảo Hán</h4>
                        </div>
                    </div>
                    <p>Tôi rất thích câu "Hãy thôi lo về những ổ gà trên đường và tận hưởng cuộc hành trình" nên tôi sẽ mua bảo hiểm của bạn.</p>
                </div>
                <div class="people-col">
                    <div class="users">
                        <img src="assets/img/phuong.jpg">
                        <div class="user-info">
                            <h4>Phương chọc thủ</h4>
                        </div>
                    </div>
                    <p>Vì đã mua bảo hiểm nên tôi không sơ công an phạt tiền về vấn đề thiếu giấy tờ nữa.</p>
                </div>
                <div class="people-col">
                    <div class="users">
                        <img src="assets/img/hoavip.jpg">
                        <div class="user-info">
                            <h4>Hòa ProX</h4>
                        </div>
                    </div>
                    <p>Cuộc hành trình ngàn dặm bắt đầu từ một cái lăn bánh xe và tất nhiên không thể nào thiếu bảo hiểm được.</p>
                </div>
                <div class="people-col">
                    <div class="users">
                        <img src="assets/img/duongvip.jpg">
                        <div class="user-info">
                            <h4>Đào Tùng Dương</h4>
                        </div>
                    </div>
                    <p>Không có lý do gì khi đôi chân còn đang khỏe mà bạn phải ngồi im.Không có lý do gì khi bạn chưa mua bảo hiểm.</p>
                </div>
                <div class="people-col">
                    <div class="users">
                        <img src="assets/img/phuong.jpg">
                        <div class="user-info">
                            <h4>Phương chọc thủ</h4>
                        </div>
                    </div>
                    <p>Bảo hiểm không lấy đi nhiều tiền của bạn, ngược lại nó còn đảm bảo cho bạn một khoản tiền khi bạn cần đến nhất.</p>
                </div>
            </div>
            
        </section>
        
        <section id="footer">
            <img src="assets/img/baohiem.jpg" class="footer-img">
            <div class="title-text">
                <p>Contact</p>
                <h1>Visit Website</h1>
            </div>
            <div class="footer-row">
                <div class="footer-left">
                    <h1>Opening</h1>
                    <p>Every Time</p>
                </div>
                <div class="footer-right">
                    <h1>Get in Touch</h1>
                    <p>Khu đô thị Nam cường,cổ nhuế 1</p>
                    <p>hoangnhse05084@fot.edu.vn</p>
                    <p>0962029497</p>
                    
                </div>
            </div>
        </section>

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

            var scroll = new SmoothScroll('a[href*="#"]', {
                speed: 1000,
                speedAsDuration: true
            });
        </script>
    </body>
</html>
