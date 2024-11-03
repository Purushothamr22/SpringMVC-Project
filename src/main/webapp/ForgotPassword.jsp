<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Namma Metro</title>

                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <style>

                </style>
            </head>

            <body class="bg-dark">

                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <div>
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
                        </div>
                        <div>
                            <span class="navbar-text h5 text-dark  ">Government Metro </span>
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
                                        href="getIndex">Home</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary btn-outline-dark text-light"
                                        href="getLoginByEmail">Back</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="container my-5 ">
                    <div class="row justify-content-center">
                        <div class="col-md-8">
                            <div class="card shadow-sm p-5 mx-auto"
                                style="background-color: rgba(51, 99, 119, 0.753); width: 50%; ">
                                <h5 class="text-light justify-content-end">${Otpmsg}</h5>
                                <form action="getOtpDetails" method="get">
                                    <div class="mb-4 ">
                                        <label for="emailId" class="form-label text-light">Email id</label>
                                        <input type="email" id="emailId" name="emailId"
                                            placeholder="Enter your email id" class="form-control" onblur="checkEmail()"
                                            value="${emailDto.emailId}" required>
                                        <span id="email"></span>
                                    </div>
                                    <div class="d-grid col-4 mx-auto">
                                        <button type="submit" class="btn btn-primary">Get OTP</button>
                                    </div>
                                </form>

                                <form action="verifyOtp" method="post" class="mt-4">
                                    <div class="mb-3">
                                        <input type="email" class="form-control" placeholder="Enter your email"
                                            name="emailId" value="${emailDto.emailId}" hidden>
                                        <label for="inputPassword5" class="form-label text-light">Enter OTP</label>
                                        <input type="password" class="form-control" placeholder="Enter your otp"
                                            name="otp" required>
                                    </div>
                                    <div class="text-center">
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-success" id="verifyOtp">Verify
                                                OTP</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <footer class="footer text-white py-3 fixed-bottom" style="background-color: rgb(131, 138, 141, 0.6);">
                    <div class="container text-center">
                        <p class="mb-0">User Login Page</p>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script>
                    const checkEmail = async () => {
                        var email = document.getElementById("emailId").value;
                        var button = document.getElementById("button");
                        var response = await axios('http://localhost:8083/metro-application/isEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            document.getElementById("emailId").innerHTML = "";
                            button.setAttribute("disabled", "");

                        } else if (response.data === "Email Accepted") {
                            document.getElementById("emailId").innerHTML = "<span style ='color:yellow'> Email does not exists </span>";
                            button.removeAttribute("disabled");
                        }

                    }

                </script>
            </body>

            </html>