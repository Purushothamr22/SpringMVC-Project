<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Bootstrap Icons -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
                    rel="stylesheet">

            </head>

            <body class="bg-light text-dark d-flex flex-column min-vh-100">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">
                            <img src="https://www.x-workz.in/Logo.png" alt="Metro Logo" style="max-height: 50px;">
                        </a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item me-2">
                                    <a class="nav-link btn btn-primary text-light" href="getUserRegistrationInfo">
                                        <i class="bi bi-person-plus-fill me-1"></i> New User Registration
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary text-light" href="getLoginPage">
                                        <i class="bi bi-box-arrow-in-right me-1"></i> Login
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="container-fluid bg-primary text-white text-center min-vh-100 py-5">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQw-aNLlRb7L5prZL2byTNKoT2nH20mBHiN9A&s"
                        alt="Namma Metro" class="img-fluid mb-4" style="max-width: 500px;">

                    <h1 class="display-1 fw-bold">Welcome to Namma Metro</h1>
                    <p class="lead">Connecting the city, connecting people.</p>

                    <div class="d-block ">
                        <img src="https://blog.tummoc.com/wp-content/uploads/2021/06/Namma-Metro-Green-Line_-Routes-Stations-Fares-Timings-More-1.png"
                            alt="Metro Map" class="img-fluid mt-4 mx-3" style="max-width: 300px;">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRR_hIWXUrSCdBEhaY3np1GsVC3TExWYx--Rw&s"
                            alt="Metro Map" class="img-fluid mt-4 mx-3" style="max-width: 300px;">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZaS7FDck1cpi2cGD0umX7O3qAGvd1mYZJsQ&s"
                            alt="Metro Map" class="img-fluid mt-4" style="max-width: 300px;">

                    </div>
                </div>

               <div class="container my-5 py-3 " style="width: 950px;">
                   <div class="card shadow-lg border-0 rounded-3">
                       <div class="row g-0">
                           <div class="col-md-4">
                               <img  src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9VIqsuk0gwNEmyihuh0XB4y1OvYJESdR6FA&s"
                                    alt="Metro Logo" class="img-fluid rounded-start " style="width: 100%; height: 100%;">
                           </div>
                           <div class="col-md-8">
                               <div class="card-body text-center ">
                                   <h2 class="fs-3 fw-bold mb-4 mt-4 mx-3 text-primary text-start">About Us</h2>
                                   <h4 class="fs-5 fw-bold mb-3 mx-5 text-start  text-dark">Bangalore Metro Rail Corporation Limited (BMRCL)</h4>
                                   <p class="fs-6 text-muted mb-2">BMRCL is a joint venture between the Government of India and the Government of Karnataka. It is a Special Purpose Vehicle entrusted with implementing and operating the Bangalore Metro Rail Project.</p>
                                   <p class="fs-6 text-muted mb-2">'Namma Metro' is not only a contribution to Bangalore’s skyline but also provides a safe, quick, reliable, and comfortable public transport system. It is an environmentally friendly initiative, significantly reducing carbon emissions and contributing to a sustainable future.</p>
                                   <p class="fs-6 text-muted mb-2">Currently, the metro services span a total of 77 km, enhancing daily commutes for thousands of citizens.</p>
                               </div>
                           </div>
                       </div>
                   </div>
               </div>

                




                <div class="container my-5 py-5">
                    <h2 class="text-center fw-bold mb-4">Our Services</h2>
                    <div class="row mt-4 p-3 g-4">
                        <div class="col-md-4">
                            <div class="card h-100">
                                <div class="card-body text-center">
                                    <i class="bi bi-map-fill display-4 text-primary mb-3"></i>
                                    <h5 class="card-title">Route Map</h5>
                                    <p class="card-text">Find the quickest and most convenient routes for your travel.
                                    </p>
                                    <a href="routeMap.jsp" class="btn btn-primary">Learn More</a>
                                </div>
                            </div>
                        </div>


                        <div class="col-md-4">
                            <div class="card h-100">
                                <div class="card-body text-center">
                                    <i class="bi bi-ticket-perforated-fill display-4 text-primary mb-3"></i>
                                    <h5 class="card-title">Ticket Booking</h5>
                                    <p class="card-text">Book tickets easily online and save time during your commute.
                                    </p>
                                    <a href="getUserLogin" class="btn btn-primary">Book Now</a>
                                </div>
                            </div>
                        </div>


                        <div class="col-md-4">
                            <div class="card h-100">
                                <div class="card-body text-center">
                                    <i class="bi bi-clock-fill display-4 text-primary mb-3"></i>
                                    <h5 class="card-title">Metro Updates</h5>
                                    <p class="card-text">Stay updated with the latest schedules and announcements.</p>
                                    <a href="metroUpdates.jsp" class="btn btn-primary">Get Updates</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Footer -->
                <footer class="py-4 text-center bg-dark">
                    <div class="container">
                        <h2 class="section-header text-light">Contact Us</h2>
                        <p class="section-content text-light">For more information, complaints, or inquiries, feel free
                            to reach out to
                            our customer service team at:</p>
                        <p class="section-content text-light"><strong>Email:</strong> support@namma.metro.in</p>
                        <p class="mb-0">&copy; 2024 Namma Metro. All rights reserved.</p>
                        <nav class="mt-2">
                            <a href="#">Privacy Policy</a> |
                            <a href="#">Terms of Service</a> |
                            <a href="#">Contact Us</a>
                        </nav>
                        <div class="mt-3">
                            <a href="#"><img src="https://img.icons8.com/ios-glyphs/30/ffffff/facebook-new.png"
                                    alt="Facebook"></a>
                            <a href="#"><img src="https://img.icons8.com/ios-glyphs/30/ffffff/twitter.png"
                                    alt="Twitter"></a>
                            <a href="#"><img src="https://img.icons8.com/ios-glyphs/30/ffffff/instagram-new.png"
                                    alt="Instagram"></a>
                        </div>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>