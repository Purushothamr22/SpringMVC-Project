<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Details</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

                <style>
                    .bg-color {
                        background-color: rgb(216, 203, 184);
                    }
                </style>
            </head>

            <body class="bg-light">


                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(12, 13, 14);">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="getAdminPage?emailId=${metroDto.emailId}">
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
                                            href="getDetails?emailId=${metroDto.emailId}">Metro Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="getStationDetails?emailId=${metroDto.emailId}">Add Station Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="getTimeDetails?emailId=${metroDto.emailId}">Add Time Details</a>
                                    </li>


                                    <li class="nav-item mx-auto">
                                        <img src="getImage/${metroDto.userImage}" alt="User Image"
                                            class="rounded-circle border border-warning shadow-sm"
                                            style="width: 50px; height: 50px; cursor: pointer;" data-bs-toggle="modal"
                                            data-bs-target="#profileImageModal">
                                    </li>

                                    <li class="nav-item dropdown mx-3">
                                        <a class="nav-link dropdown-toggle btn btn-primary text-light" href="#"
                                            id="userDropdown" role="button" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                            ${metroDto.firstName}
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                            <li><a class="dropdown-item"
                                                    href="editProfile?emailId=${metroDto.emailId}">Profile Edit</a></li>
                                            <li><a class="dropdown-item" href="getLoginPage?emailId=${metroDto.emailId}">Log out</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>


                <div class="modal fade" id="profileImageModal" tabindex="-1" aria-labelledby="profileImageModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-dark" id="profileImageModalLabel">${metroDto.firstName}'s
                                    Profile</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="card">
                                    <img src="getImage/${metroDto.userImage}" class="card-img-top" alt="User Image">
                                    <div class="card-body text-center">
                                        <h5 class="card-title">${metroDto.firstName}</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="container mt-5 py-4">
                    <div class="row justify-content-center">
                        <div class="col-md-8">
                            <form action="editMetroDetails" method="post" class="border p-5 shadow rounded bg-light">
                                <!-- Form Header -->
                                <div class="text-center mb-4">
                                    <h2 class="fw-bold text-primary">Edit Train Details</h2>
                                    <p class="text-muted">Update the train and station details below</p>
                                </div>

                                <!-- First Row -->
                                <div class="row g-3">
                                    <div class="col-md-3">
                                        <label for="stationNumber" class="form-label">Station No</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-123"></i>
                                            </span>
                                            <input type="text" id="stationNumber" name="stationNumber"
                                                class="form-control border-dark" placeholder="Enter number"
                                                value="${stationDetails.stationNumber}" required>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <label for="stationId" class="form-label">Station ID</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-card-text"></i>
                                            </span>
                                            <input type="text" id="stationId" name="stationId"
                                                class="form-control border-dark" placeholder="Enter ID"
                                                value="${stationDetails.stationId}" required>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="trainType" class="form-label">Train Type</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-train-front"></i>
                                            </span>
                                            <input type="text" id="trainType" name="trainType"
                                                class="form-control border-dark" placeholder="Enter train type"
                                                value="${trainDetails.trainType}" required>
                                        </div>
                                    </div>
                                </div>

                                <!-- Second Row -->
                                <div class="row g-3 mt-3">
                                    <div class="col-md-6">
                                        <label for="source" class="form-label">Source</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-pin-map"></i>
                                            </span>
                                            <input type="text" id="source" name="source"
                                                class="form-control border-dark" placeholder="Enter source"
                                                value="${trainDetails.source}" required>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="destination" class="form-label">Destination</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-map"></i>
                                            </span>
                                            <input type="text" id="destination" name="destination"
                                                class="form-control border-dark" placeholder="Enter destination"
                                                value="${trainDetails.destination}" required>
                                        </div>
                                    </div>
                                </div>

                                <!-- Third Row -->
                                <div class="row g-3 mt-3">
                                    <div class="col-md-6">
                                        <label for="sourceTime" class="form-label">Source Time</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-clock"></i>
                                            </span>
                                            <input type="text" id="sourceTime" name="sourceTime"
                                                class="form-control border-dark" placeholder="Enter source time"
                                                value="${trainDetails.sourceTime}" required>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="destinationTime" class="form-label">Destination Time</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-clock-fill"></i>
                                            </span>
                                            <input type="text" id="destinationTime" name="destinationTime"
                                                class="form-control border-dark" placeholder="Enter destination time"
                                                value="${trainDetails.destinationTime}" required>
                                        </div>
                                    </div>
                                </div>

                                <!-- Fourth Row -->
                                <div class="row g-3 mt-3">
                                    <div class="col-md-6">
                                        <label for="source" class="form-label">From Day</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-pin-map"></i>
                                            </span>
                                            <input type="text" id="source" name="fromDay"
                                                class="form-control border-dark" placeholder="Enter source"
                                                value="${trainDetails.fromDay}" required>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <label for="destination" class="form-label">To Day</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-map"></i>
                                            </span>
                                            <input type="text" id="destination" name="toDay"
                                                class="form-control border-dark" placeholder="Enter destination"
                                                value="${trainDetails.toDay}" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" id="distance" name="distance"
                                            class="form-control border-dark" placeholder="Enter distance"
                                            value="${stationDetails.distance}" hidden>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" id="distance" name="trainId"
                                            class="form-control border-dark" placeholder="Enter trainId"
                                            value="${trainDetails.trainId}" hidden>
                                    </div>
                                </div>

                                <!-- Fifth Row -->
                                <div class="row g-3 mt-3">
                                    <div class="col-md-6 mx-auto">
                                        <label for="price" class="form-label">Price</label>
                                        <div class="input-group">
                                            <span class="input-group-text bg-primary text-white">
                                                <i class="bi bi-currency-dollar"></i>
                                            </span>
                                            <input type="text" id="price" name="price" class="form-control border-dark"
                                                placeholder="Enter price" value="${trainDetails.price}" readonly>
                                        </div>
                                    </div>

                                </div>

                                <!-- Submit Button -->
                                <div class="d-grid mt-4">
                                    <button type="submit" class="btn btn-primary btn-lg">
                                        <i class="bi bi-send"></i> Submit
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <footer class="bg-dark text-light   text-center ">
                    <div class="container">
                        <p class="mb-2">For assistance, email us at <strong>support@namma.metro.in</strong></p>
                        <p class="mb-2">&copy; 2024 Namma Metro. All rights reserved.</p>
                        <div>
                            <a href="#"><img src="https://img.icons8.com/ios-glyphs/30/ffffff/facebook-new.png"
                                    alt="Facebook"></a>
                            <a href="#"><img src="https://img.icons8.com/ios-glyphs/30/ffffff/twitter.png"
                                    alt="Twitter"></a>
                            <a href="#"><img src="https://img.icons8.com/ios-glyphs/30/ffffff/instagram-new.png"
                                    alt="Instagram"></a>
                        </div>
                    </div>
                </footer>


            </body>

            </html>