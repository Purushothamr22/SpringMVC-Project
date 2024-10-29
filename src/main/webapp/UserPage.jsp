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

            <body class="bg-dark text-white">

                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                        <div class="container-fluid">
                            <a class="navbar-brand">
                                <img src="https://www.x-workz.in/Logo.png" alt="Company Logo" style="max-height: 40px;">
                            </a>
                            <h1 class="h3 text-white mx-2">User Profile</h1>
                
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
                                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                
                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav ms-auto text-center align-items-center">
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light" data-bs-toggle="modal" data-bs-target="#addStationDetails" href="#">Add Station Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light" data-bs-toggle="modal" data-bs-target="#addTimeDetails" href="#">Add Time Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light" data-bs-toggle="modal" data-bs-target="#savePriceDetails" href="#">Add Price Details</a>
                                    </li>
                                    
                                    <li class="nav-item mx-auto">
                                        <img src="getImage/${details.userImage}" alt="User Image" class="rounded-circle border border-warning shadow-sm" style="width: 50px; height: 50px;">
                                    </li>
                
                                    <!-- Dropdown Menu -->
                                    <li class="nav-item dropdown mx-3">
                                        <a class="nav-link dropdown-toggle btn btn-primary text-light" href="#" id="userDropdown" 
                                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            ${details.firstName}
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                            <li><a class="dropdown-item" href="editProfile?emailId=${details.emailId}">Profile</a></li>
                                            <li><a class="dropdown-item" href="getLoginByEmail">Log out</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                

                <!--ADD Station Details Modal -->
                <div class="modal fade" id="addStationDetails" tabindex="-1" aria-labelledby="addStationDetailsLabel"
                    aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content" style="background-color: white">
                            <div class="modal-header text-white text-center rounded-top"
                                style="background-color: rgb(177, 228, 252);">
                                <h5 class="modal-title text-dark" id="addDeatilsLabel">Add Train Details</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="addStationDetails" method="post">
                                    <input type="email" name="emailId" value="${details.emailId}" hidden>

                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Train type</label>
                                            <input type="text" class="form-control" id="traintype" name="stationType"
                                                placeholder="Enter train Type" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Station Name</label>
                                            <input type="text" class="form-control" id="trainName" name="stationName"
                                                placeholder="Enter train name" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Train Number</label>
                                            <input type="text" class="form-control" id="trainNumber"
                                                name="stationNumber" placeholder="Enter train number" required>
                                        </div>
                                    </div>

                                    <div class="modal-footer rounded-bottom"
                                        style="background-color:rgb(252, 176, 228);">
                                        <button type="button" class="btn btn-outline-light text-dark"
                                            style="color: rgb(156, 161, 145);" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <button type="submit" class="btn text-dark"
                                            style="background-color: rgb(228, 252, 176);">
                                            Save changes
                                        </button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>



                <!-- train Time Details Model -->
                <div class="modal fade" id="addTimeDetails" tabindex="-1" aria-labelledby="addDetailsLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                        <div class="modal-content rounded-3" style="background-color: white">
                            <div class="modal-header  text-white text-center rounded-top "
                                style="background-color: rgb(177, 228, 252);">

                                <h5 class="modal-title text-dark  " id="addDetailsLabel">Train Time Details</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="addTrainTimeDetails" method="post">
                                    <input type="email" name="emailId" value="${details.emailId}" hidden>

                                    <div class="row mb-3">
                                        <div class="col-md-6 mx-auto">
                                            <label class="form-label text-dark ">Train Type</label>
                                            <input type="text" class="form-control" id="trainType" name="trainType"
                                                placeholder="Enter train type" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">From Day</label>
                                            <input type="text" class="form-control" id="fromDay" name="fromDay"
                                                placeholder="Select starting day" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">To Day</label>
                                            <input type="text" class="form-control" id="toDay" name="toDay"
                                                placeholder="Select ending day" required>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">Source</label>
                                            <input type="text" class="form-control" id="source" name="source"
                                                placeholder="Enter source station" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">Destination</label>
                                            <input type="text" class="form-control" id="destination" name="destination"
                                                placeholder="Enter destination station" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">Source Time</label>
                                            <input type="time" class="form-control" id="sourceTime" name="sourceTime"
                                                required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label text-dark ">Destination Time</label>
                                            <input type="time" class="form-control" id="destinationTime"
                                                name="destinationTime" required>
                                        </div>
                                    </div>

                                    <div class="modal-footer rounded-bottom"
                                        style="background-color:rgb(252, 176, 228);">
                                        <button type="button" class="btn btn-outline-light text-dark"
                                            style="color: rgb(156, 161, 145);" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <button type="submit" class="btn text-dark"
                                            style="background-color: rgb(228, 252, 176);">
                                            Save changes
                                        </button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- train Price Details Model -->
                <div class="modal fade" id="savePriceDetails" tabindex="-1" aria-labelledby="savePriceDetailsLabel"
                    aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content" style="background-color: #FEDBD0">
                            <div class="modal-header text-white text-center rounded-top"
                                style="background-color: #442C2E;">
                                <h5 class="modal-title text-light" id="addDeatilsLabel">Add Price Details</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="savePriceDetails" method="post">
                                    <input type="email" name="emailId" value="${details.emailId}" hidden>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Train type</label>
                                            <input type="text" class="form-control " id="traintype" name="trainType"
                                                placeholder="Enter train Type" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Train Source</label>
                                            <input type="text" class="form-control text-white" id="trainSource"
                                                name="source" placeholder="Enter train Type" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Train Destination</label>
                                            <input type="text" class="form-control" id="destination" name="destination"
                                                placeholder="Enter train Destination" required>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Ticket Price</label>
                                            <input type="text" class="form-control" id="price" name="price"
                                                placeholder="Enter Ticket Price" required>
                                        </div>
                                    </div>

                                    <div class="modal-footer rounded-bottom">
                                        <button type="button" class="btn  text-dark"
                                            style="background-color: rgb(252, 176, 228);" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <button type="submit" class="btn text-dark"
                                            style="background-color: rgb(228, 252, 176);">
                                            Save changes
                                        </button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Main Section -->
                <div class="container position-relative mt-5 text-center">
                    <h3 class="text-dark justify-content-center">${trainMsg}</h3>
                </div>
                <div class="container position-relative mt-5 text-center">
                    <h3 class="text-dark justify-content-center">${TimeDetailsMsg}</h3>
                </div>
                <div class="container position-relative mt-5 text-center">
                    <h3 class="text-dark justify-content-center">${PriceMsg}</h3>
                </div>
                <h6 style="color: green;">${msg}</h6>
                <h6 style="color: rgb(68, 44, 46);">${errMsg}</h6>
                <h6 style="color: green;">${successMsg}</h6>

                <!-- Footer Section -->
                <footer class="text-white py-3 fixed-bottom" style="background-color: rgb(87, 93, 95);">
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