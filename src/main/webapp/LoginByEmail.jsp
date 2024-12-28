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
                            background: linear-gradient(145deg, #e0f7fa, #f4f7fa);
                            font-family: 'Roboto', sans-serif;
                            color: #2c3e50;
                            margin: 0;
                        }

                        .navbar {
                            background-color: #000000;
                        }

                        .navbar-brand img {
                            max-height: 50px;
                        }

                        .navbar-text {
                            color: #fff;
                        }

                        .btn-primary {
                            background-color: #000000;
                            border-color: #2f4d55cc;
                        }

                        .btn-primary:hover {
                            background-color: #3f19c9;
                            border-color: #1a33a5;
                        }

                        .footer {
                            background-color: #000000;
                            color: white;
                            text-align: center;
                            padding: 30px 0;
                        }

                        .footer a {
                            color: #ddd;
                            text-decoration: none;
                        }

                        .divider {
                            display: flex;
                            justify-content: center;
                            align-items: center;
                        }

                        .divider h3 {
                            color: #00796b;
                        }

                        .section-header {
                            font-size: 1.75rem;
                            font-weight: 600;
                            color: #00796b;
                            justify-content: center;
                            text-align-last: auto;
                        }

                        .section-content {
                            font-size: 1.1rem;
                            color: #5d6d7e;
                        }

                        .card-header {
                            background-color: #00796b;
                            color: #fff;
                            font-weight: bold;
                        }
                    </style>
                </head>

                <body>

                    <!-- Navigation Bar -->
                    <nav class="navbar navbar-expand-lg navbar-dark">
                        <div class="container-fluid d-flex justify-content-between align-items-center">
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo">
                            </a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav ms-auto">
                                    <li class="nav-item">
                                        <a class="nav-link btn-primary rounded-3 btn-outline-light px-4" href="getIndex">Back</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>

                <h5 class="mb-4 text-danger">${userLoginMsg}</h5>
                <h5 class="mb-4 text-danger">${adminLoginMsg}</h5>
                <h5 class="mb-4 text-success">${adminLoginSuccessMsg}</h5>



                <div class="container my-5">
                    <div class="row justify-content-center">
                        <!-- Left Form -->
                        <div class="col-md-5">
                            <div class="card p-4">
                                <h2 class="text-center mb-4">Admin Login</h2>
                                <form action="onLoginSaveDetailsByEmail" method="post" onblur="checkForm()">
                                    <div class="mb-3">
                                        <label class="form-label">E-mail</label>
                                        <input type="email" id="email" name="emailId" placeholder="Enter E-mail Id"
                                            class="form-control" onblur="checkEmail()" required>
                                        <span id="eId"></span>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Password</label>
                                        <input type="password" id="pass" name="password" placeholder="Enter Password"
                                            class="form-control" onblur="checkPassword()" required>
                                        <span id="password"></span>
                                    </div>

                                    <div class="d-grid">
                                        <button type="submit" class="btn btn-primary">Login</button>
                                        <span id="button"></span>
                                    </div>

                                    <p class="text-center mt-3">
                                        Forgot Password? <a class="text-warning" href="getForgotPassword">Reset</a>
                                    </p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>



                <!-- Footer -->
                <footer class="footer py-3">
                       <div>
                           <h2 class="section-header text-light">Contact Us</h2>
                           <p class="section-content text-light">For more information, complaints, or inquiries, feel free to reach
                               out to
                               our customer service team at:</p>
                           <p class="section-content text-light"><strong>Email:</strong> support@namma.metro.in</p>
                       </div>
                   </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

                <script>

                    const checkEmail = async () => {

                        var email = document.getElementById("email").value;
                        var button = document.getElementById("button");
                        console.log("email id is ========== " + email);
                        var response = await axios('http://localhost:8083/metro-application/isEmailExists?emailId=' + email);
                        if (email.length < 5) {
                            document.getElementById("eId").innerHTML = "<span style='color:red;'>invalid email</span>";
                            button.setAttribute("disabled", "");
                        }
                        else if (response.data === "Email Exists") {
                            document.getElementById("eId").innerHTML = "";
                        } else if (response.data === "Email Accepted") {
                            document.getElementById("eId").innerHTML = "<span style ='color:red'> Email does not exists </span>";
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
                            document.getElementById("password").innerHTML = "<span style = 'color :red'> password must have atleast 8 letters </span>";
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
                            button.setAttribute("disabled", "true");
                        }
                    }




                </script>
            </body>

            </html>