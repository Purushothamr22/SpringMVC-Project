<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            </head>

            <body class=" text-white">

                <!-- <div class="position-absolute top-0 start-0 w-100 h-100" style="background-color: rgba(0, 0, 0, 0.6);"></div> -->

                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
                        <div class="container-fluid ">
                            <a class="navbar-brand">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 40px;">
                            </a>
                            <h1 class="h3 text-white mx-2 ">User Profile</h1>

                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                                aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav ms-auto text-center align-items-center">
                                    <li class="nav-item mx-auto">
                                        <img src="getImage/${details.userImage}" alt="User Image"
                                            class="rounded-circle border border-warning shadow-sm"
                                            style="width: 50px; height: 50px;">
                                    </li>
                                    <li class="nav-item mx-auto">
                                        <a class="nav-link btn btn-primary btn-outline-dark text-light">
                                            ${details.userName}
                                        </a>
                                    </li>
                                    <li class="nav-item mx-2">
                                        <a class="d-flex dropdown-item text-light justify-content-center"
                                            href="editProfile?emailId=${details.emailId}">Profile</a>
                                    </li>
                                    <li class="nav-item ">
                                        <a class="d-flex dropdown-item text-light justify-content-center"
                                            href="getLoginByEmail">Log out</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>



                <!-- Main Section -->
                <div class="container position-relative mt-5 text-center">


                </div>
                <!-- <h6 style="color: green;">${details.userImage}</h6> -->
                <h6 style="color: green;">${msg}</h6>
                <h6 style="color: red;">${errMsg}</h6>
                <h6 style="color: green;">${successMsg}</h6>


                <!-- Footer Section -->
                <footer class=" text-white py-3 fixed-bottom" style="background-color: rgb(112, 146, 135);">
                    <div class="container text-center">
                        <p class="mb-1">&copy; 2024 Metro Service. All rights reserved.</p>
                        <nav>
                            <a href="PrivacyPolicy.jsp" class="text-white me-3">Privacy Policy</a>
                            <a href="TermsOfService.jsp" class="text-white me-3">Terms of Service</a>
                        </nav>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>