<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <style>
                    .promotion-banner--bootcamp {
                        background-color: #ffc107;

                    }

                    .promotion-banner--bootcamp .btn-danger {
                        background-color: #ff5722;

                        border: none;
                    }
                </style>

            </head>

            <body class="bg-dark text-white" style="background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20240729/pngtree-yellow-train-in-budapest-metro-hungary-image_15933708.jpg'); 
    background-size: cover;
     background-position: center; 
     background-repeat: no-repeat; 
     height: 100vh;">

                <!-- Promotion Banner with Bootcamp Modifier
                <div class="promotion-banner promotion-banner--bootcamp text-center ">
                    <div class="container">
                        <h5 class="display">Join Our Coding Bootcamp</h5> <a href="/bootcamp" class="btn btn-danger btn-lg col-md-6">Learn More</a> 
                        
                    </div>
                </div> -->


                </div>
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark  ">
                    <div class="container-fluid ">
                        <a class="navbar-brand">
                            <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 40px;">
                        </a>
                        <span class="h5 text-white ">Metro Home Page</span>

                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <!-- <li class="nav-item">
                                    <a class="nav-link btn btn-primary btn-outline-dark text-light"
                                        href="metroFetch">user details</a>
                                </li> -->
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary btn-outline-dark text-light"
                                        href="getLoginByEmail">Login</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <p class=" h2 text-center justify-content-center" style="color: #ff5722;">${indexMsg}</p>
               
                <!-- Main Section -->
                <div class="container position-relative mt-5 text-center">
                    <h2 class="py-5">Welcome to Metro</h2>
                    <div class="d-flex justify-content-center mt-4">
                        <a href="Registration.jsp" class="btn btn-primary mx-2">New User Registration</a>
                    </div>
                </div>

               


                <!-- Footer Section -->
                <footer class="bg-dark text-white py-3 fixed-bottom">
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