<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="UTF-8FF">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <title>Government Metro Service Login</title>

                <style>
                    body {
                        /* background-image: url('https://c1.wallpaperflare.com/preview/613/806/400/subway-city-metro-transportation.jpg'); */

                        background-size: cover;
                        background-repeat: no-repeat;
                        background-position: center;
                    }
                </style>
            </head>

            <body class="bg bg-dark">
                <!-- Navigation Bar -->
                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <div>
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
                        </div>
                        <div>
                            <span class="navbar-text h5 text-dark  ">Namma Metro </span>
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
                                        href="getIndex">Back</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </nav>

                <div class="container my-5">
                    <div class="row justify-content-center">
                        <div class="col-md-6">
                            <div class="card p-4" style="background-color: rgb(52, 73, 85,0.6);">
                                <h5 class=" mb-4 text-white">${userLoginMsg}</h5>
                                <h2 class="text-center mb-4 text-white">Login</h2>

                                <form action="onLoginSaveDetailsByEmail" method="post" onblur="checkForm()">
                                    <div class="mb-3">
                                        <label class="form-label text-light">E-mail</label>
                                        <input type="email" id="email" name="emailId" placeholder="Enter E-mail Id"
                                            class="form-control" onblur="checkEmail()" required>
                                        <span id="eId"></span>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label text-light">Password</label>
                                        <input type="password" id="pass" name="password" placeholder="Enter Password"
                                            class="form-control" onblur="checkPassword()" required>
                                        <span id="password"></span>
                                    </div>

                                    <div class="d-grid">
                                        <button type="submit" class="btn btn-danger">Login</button>
                                        <span id="button"></span>
                                    </div>
                                    <div class=" row ">
                                        <p class=" text-center text-light">
                                            Forgot Password ? <a class="text-center text-warning"
                                                href="getForgotPassword"> Reset</a>
                                        </p>
                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>

                </div>
                <br>
                <br>
                <!-- Footer -->
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

                    const checkEmail = async () => {
                        var email = document.getElementById("email").value;
                        var button = document.getElementById("button");
                        console.log("emil in login is " + email);


                        var response = await axios('http://localhost:8083/metro-application/isEmailExists?emailId=' + email);
                        if (email.length < 5) {
                            document.getElementById("eId").innerHTML = "<span style='color:red;'>invalid email</span>";
                            button.setAttribute("disabled", "");
                        }
                        else if (response.data === "Email Exists") {
                            document.getElementById("eId").innerHTML = "";
                        } else if (response.data === "Email Accepted") {
                            document.getElementById("eId").innerHTML = "<span style ='color:yellow'> Email does not exists </span>";
                        }
                        checkForm();

                    }
                    function checkPassword() {
                        var pass = document.getElementById("pass").value;
                        var button = document.getElementById("button");


                        if (pass.trim !== '' && pass.length >= 8 && pass.length <= 12) {
                            document.getElementById("password").innerHTML = "";
                            button.removeAttribute("disabled")
                        } else {
                            document.getElementById("password").innerHTML = "<span style = 'color :yellow'> password must have atleast 8 letters </span>";
                            button.setAttribute("disabled", "");
                        }
                        checkForm();
                    }



                    function checkForm() {
                        var email = document.getElementById("email").value;
                        var pass = document.getElementById("pass").value;
                        var button = document.getElementById("button");
                        if (email.length >= 5 && pass.length >= 8 && pass.length <= 12) {
                            button.removeAttribute("disabled");
                        } else {
                            // if (condition) {

                            // }
                            button.setAttribute("disabled", "true");
                        }
                    }
                </script>


            </body>

            </html>