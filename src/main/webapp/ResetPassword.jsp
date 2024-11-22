<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Namma Metro</title>

                <!-- Include Bootstrap CSS for styling and responsiveness -->
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
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
                                        href="getForgotPassword">Back</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </nav>


                <div class="container-fluid my-5">
                    <div class="row justify-content-center">
                        <div class="col-md-6">
                            <div class="card p-4 mx-auto"
                                style="background-color: rgba(145, 150, 161, 0.534); width: 35vw;">
                                <h5>${passwordError}</h5>
                                <h2 class="text-center text-light justify-content-center mb-3">Password Reset </h2>
                                <form action="onPasswordReset" method="post" onblur="checkForm()">
                                    <div class="mb-3">
                                        <label class="form-label text-light"> Email Id </label>
                                        <input type="email" id="emailId" name="emailId"
                                            placeholder="${registrationDto.emailId}" class="form-control"
                                            value="${registrationDto.emailId}" readonly>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label text-light">New Password</label>
                                        <input type="password" id="pass" name="password"
                                            placeholder="Enter New Password" onblur="checkPassword()"
                                            class="form-control" required>
                                        <span id="password"></span>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label text-light">Confirm Password</label>
                                        <input type="password" id="cPassword" name="confirmPassword"
                                            onblur="checkConfirmPassword()" placeholder="Confirm Password"
                                            class="form-control" required>
                                        <span id="confirPassword"></span>
                                    </div>
                                    <div class="d-grid">
                                        <button type="submit" id="button" class="btn btn-primary">Submit</button>

                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>

                <footer class="footer text-white py-3 fixed-bottom"
                    style="background-color: rgba(124, 128, 133, 0.534);">
                    <div class="container text-center">
                        <p class="mb-0">User Password Reset Page</p>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

                <script>
                    function checkPassword() {
                        var pass = document.getElementById("pass").value;
                        var password = document.getElementById("password");
                        if (pass.trim !== '' && pass.length >= 8 && pass.length <= 12) {
                            password.innerHTML = "";
                        } else {
                            password.innerHTML = "<span style ='color:yellow'> password must have atleast 8 letters </span>";
                        }
                        checkForm();
                    }

                    function checkConfirmPassword() {
                        var pass = document.getElementById("pass").value;
                        var cpass = document.getElementById("cPassword").value;
                        var confirmPassword = document.getElementById("confirPassword");
                        if (cpass.trim !== '' && cpass.length >= 8 && cpass.length <= 12) {
                            confirmPassword.innerHTML = "";
                        }else{
                            confirmPassword.innerHTML = "<span style ='color:yellow'> password must have atleast 8 letters </span>";
                        }
                        if (pass === cpass) {
                            confirmPassword.innerHTML = "";
                        } else {
                            confirmPassword.innerHTML = "<span style ='color:yellow'> password does not match </span>";
                        }
                        checkForm();
                    }

                    function checkForm() {
                        var pass = document.getElementById("pass").value;
                        var cpass = document.getElementById("cPassword").value;
                        var button = document.getElementById("button");

                        if ((pass.trim !== '' && pass.length >= 8 && pass.length <= 12) && (cpass.trim !== '' && cpass.length >= 8 && cpass.length <= 12) && (pass === cpass)) {
                            button.removeAttribute("disabled");
                        } else {
                            button.setAttribute("disabled", "");
                        }
                    }

                </script>
            </body>

            </html>