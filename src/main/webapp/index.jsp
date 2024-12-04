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
                    .bg-cover {
                        background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20240729/pngtree-yellow-train-in-budapest-metro-hungary-image_15933708.jpg');
                        background-size: cover;
                        background-position: center;
                        background-repeat: no-repeat;
                    }

                    .overlay {
                        background: rgba(0, 0, 0, 0.7);
                    }
                </style>
                <style>
                    .font-arial {
                        font-family: Arial, sans-serif;
                    }

                    .font-georgia {
                        font-family: Georgia, serif;
                    }
                </style>



            </head>

            <body class="bg-dark text-white bg-cover bg-center position-relative" style="height: 100vh;">
                <div class="overlay position-absolute top-0 start-0 w-100 h-100"></div>





                </div>
                <nav class="navbar navbar-expand-lg  navbar-dark  " style="background-color: rgb(249, 170, 51);">
                    <div class="container-fluid ">
                        <a class="navbar-brand">
                            <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 40px;">
                        </a>

                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary  text-light" href="getUserRegistrationInfo"> New
                                        User
                                        Registration</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary font-georgia text-light"
                                        href="getLoginPage">Login</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class="row w-100">

                    <!-- Image Section -->
                    <!-- <div class="col-md-6 py-5 mx-0  ">
                        <div id="imageCarousel" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="https://www.prestigesouthernstar.info/images/prestige/metro-bangalore.webp"
                                        class="d-block w-100" alt="Registration image 1"
                                        style="object-fit: cover; height: 50%;">
                                </div>
                                <div class="carousel-item">
                                    <img src="https://png.pngtree.com/thumb_back/fh260/background/20230928/pngtree-a-green-and-white-metro-train-pull-into-a-station-image_13357538.jpg"
                                        class="d-block w-100" alt="Registration image 2"
                                        style="object-fit: cover; height: 50%;">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#imageCarousel"
                                data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#imageCarousel"
                                data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div> -->

                    <!-- Main Section -->
                    <div class="container position-relative mt-5 text-center">
                        <h2 class="py-5 fw-bold fst-italic fs-4 text-primary">Welcome to Namma Metro</h2>

                    </div>




                    <!-- Footer Section -->
                    <footer class=" text-white py-3 fixed-bottom" style="background-color: rgb(3, 54, 255);">
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