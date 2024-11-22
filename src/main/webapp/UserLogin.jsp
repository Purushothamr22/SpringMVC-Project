<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <title>Government Metro Service Login</title>

                <style>
                    body {
                        background-size: cover;
                        background-repeat: no-repeat;
                        background-position: center;
                    }
                </style>
            </head>

            <body class="bg bg-dark">
                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <div>
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
                        </div>
                        <div>
                            <span class="navbar-text h5 text-dark">Namma Metro</span>
                        </div>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary btn-outline-dark text-light"
                                        href="getLoginPage">Back</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="container my-5">
                    <div class="row justify-content-center">
                        <div class="col-md-5">
                            <div class="card rounded-0 border-warning box-shadow p-4" style="background-color: rgba(235, 242, 247, 0.6);">
                                
                                <h2 class="text-center mb-4 text-dark text-shadow">User Login</h2>
                                <form action="getUserOtpDetails" method="get">
                                    <div class="mb-4   ">
                                        <label for="emailId" class="form-label text-light"> Email id</label>
                                        <input type="email" id="userEmail" name="emailId"
                                            placeholder="Enter your email id" class="form-control border-dark shadow-sm "  onblur="checkUserEmail()"
                                            value="${userDto.emailId}" required>
                                        <span id="ueId"></span>
                                    </div>
                                    <div class="d-grid col-4 mx-auto">
                                        <button type="submit" class="btn btn-primary rounded-pill"> ✈️ Get OTP</button>
                                    </div>
                                </form>

                                <form action="verifyUserOtp" method="post" class="mt-4">
                                    <div class="mb-3">
                                        <input type="email" class="form-control" placeholder="Enter your email"
                                            name="emailId" value="${userDto.emailId}" hidden>
                                        <label for="inputPassword5" class="form-label text-light">Enter OTP</label>
                                        <input type="password" class="form-control border-dark shadow-sm" placeholder="Enter your otp"
                                            name="otp" required>
                                    </div>
                                    <div class="text-center">
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-success rounded-3" id="verifyOtp"> Login
                                                </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer fixed-bottom py-3" style="background-color: rgb(87, 93, 95);">
                    <div class="text-white text-center">
                        <nav>
                            <a href="#" class="mx-2 text-white">Privacy Policy</a>
                            <a href="#" class="mx-2 text-white">Terms of Service</a>
                        </nav>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

                <script>
                    
                    const checkUserEmail = async () => {
                        const email = document.getElementById("userEmail").value;
                        const button = document.getElementById("button");
                        const ueId = document.getElementById("ueId");
                        ueId.innerHTML ="";

                        if (email.length < 5) {
                            ueId.innerHTML = "<span style='color:red;'>Invalid email</span>";
                            button.setAttribute("disabled", "true");
                            return;
                        }
                        const response = await axios('http://localhost:8083/metro-application/isUserEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            ueId.innerHTML = "";
                            button.removeAttribute("disabled");
                        } else if (response.data === "Email Does not exists") {
                            ueId.innerHTML = "<span style='color:red;'>Email does not exist</span>";
                            button.setAttribute("disabled", "true");
                        }

                        checkUserForm();
                    };
                    function checkUserForm() {
                        var email = document.getElementById("userEmail").value;
                        
                        var button = document.getElementById("button");
                        if (email.length >= 5 ) {
                            button.removeAttribute("disabled");
                        } else {
                            button.setAttribute("disabled", "true");
                        }
                    }


                </script>

            </body>

            </html>