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
                    .bg-color {
                        background-color: rgb(139, 156, 170);
                    }
                </style>

            </head>

            <body class="bg-light text-dark">

                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(9, 10, 10);">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="getAdminPage?emailId=${details.emailId}">
                                <img src="https://www.x-workz.in/Logo.png" alt="Company Logo" style="max-height: 40px;">
                            </a>
                            <h1 class="h3 text-white mx-2">Admin Page</h1>

                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                                aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav ms-auto text-center align-items-center">
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="getDetails?emailId=${details.emailId}">Metro Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="getStationDetails?emailId=${details.emailId}">Add Station Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="getTimeDetails?emailId=${details.emailId}">Add Time Details</a>
                                    </li>


                                    <li class="nav-item mx-auto">
                                        <img src="getImage/${details.userImage}" alt="User Image"
                                            class="rounded-circle border border-warning shadow-sm"
                                            style="width: 50px; height: 50px; cursor: pointer;" data-bs-toggle="modal"
                                            data-bs-target="#profileImageModal">
                                    </li>

                                    <!-- Dropdown Menu -->
                                    <li class="nav-item dropdown mx-3">
                                        <a class="nav-link dropdown-toggle btn btn-primary text-light" href="#"
                                            id="userDropdown" role="button" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                            ${details.firstName}
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                            <li><a class="dropdown-item"
                                                    href="editProfile?emailId=${details.emailId}">Profile Edit</a></li>
                                            <li><a class="dropdown-item" href="getLoginPage">Log out</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>

                <div class="container my-5 py-5">
                    <div class="row justify-content-center">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header bg-dark text-white text-center rounded-top">
                                    <h5 class="mb-0">Add Train Details</h5>
                                </div>
                                <div class="card-body bg-color">
                                    <form action="addStationDetails" method="post">
                                        <input type="hidden" name="emailId" value="${details.emailId}">

                                        <div class="mb-3">
                                            <label class="form-label">Train Type</label>
                                            <select class="form-select shadow-sm" id="traintype" name="stationType"
                                                required>
                                                <option value="" disabled selected>Select train type</option>
                                                <option value="Purple Line">Purple Line</option>
                                                <option value="Green Line">Green Line</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Station Name</label>
                                            <input type="text" class="form-control shadow-sm" id="trainName"
                                                name="stationName" placeholder="Enter train name" required>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Train Number</label>
                                            <input type="text" class="form-control shadow-sm" id="trainNumber"
                                                name="stationNumber" placeholder="Enter metro number" required>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Distance</label>
                                            <input type="text" class="form-control shadow-sm" id="distance"
                                                name="distance" placeholder="Enter distance" required>
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-success shadow-sm px-4">Save
                                                Changes</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="profileImageModal" tabindex="-1" aria-labelledby="profileImageModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-dark" id="profileImageModalLabel">${details.firstName}'s
                                    Profile</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="card">
                                    <img src="getImage/${details.userImage}" class="card-img-top" alt="User Image">
                                    <div class="card-body text-center">
                                        <h5 class="card-title">${details.firstName}</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Main Section -->
                <div class="container position-relative mt-5 text-center">
                    <h3 class="text-light justify-content-center">${trainMsg}</h3>
                </div>
                

                <h6 style="color: green;">${successMsg}</h6>

                <footer class="text-white py-3 " style="background-color: rgb(87, 93, 95);">
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