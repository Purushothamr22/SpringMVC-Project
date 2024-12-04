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
                            <a class="navbar-brand" href="getIndex">
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
                                        <a class="nav-link btn btn-primary text-light" data-bs-toggle="modal"
                                            data-bs-target="#addStationDetails" href="#">Add Station Details</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light" data-bs-toggle="modal"
                                            data-bs-target="#addTimeDetails" href="#">Add Time Details</a>
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


                <!--ADD Station Details Modal -->
                <div class="modal fade" id="addStationDetails" tabindex="-1" aria-labelledby="addStationDetailsLabel"
                    aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content" style="background-color: white">
                            <div class="modal-header text-white text-center rounded-0"
                                style="background-color: rgb(93, 182, 223);">
                                <h5 class="modal-title text-dark" id="addDeatilsLabel">Add Train Details</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="addStationDetails" method="post">
                                    <input type="email" name="emailId" value="${details.emailId}" hidden>

                                    <div class="row mb-3">
                                        <div class="col-md-12 ">
                                            <label class="form-label text-dark ">Train Type</label>
                                            <select class="form-select rounded-0 border-dark shadow " id="traintype"
                                                name="stationType" required>
                                                <option value="" disabled selected>Select train type</option>
                                                <option value="Purple Line">Purple Line</option>
                                                <option value="Green Line">Green Line</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Station Name</label>
                                            <input type="text" class="form-control rounded-0 border-dark shadow"
                                                id="trainName" name="stationName" placeholder="Enter train name"
                                                required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Train Number</label>
                                            <input type="text" class="form-control rounded-0 border-dark shadow"
                                                id="trainNumber" name="stationNumber" placeholder="Enter Metro number"
                                                required>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-12">
                                            <label class="form-label text-dark">Distance </label>
                                            <input type="text" class="form-control rounded-0 border-dark shadow"
                                                id="distance" name="distance" placeholder="Enter Distance" required>
                                        </div>
                                    </div>

                                    <div class="modal-footer rounded-bottom">
                                        <button type="button" class="btn btn-outline-light text-light"
                                            style="background-color: rgb(8, 10, 3);" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <button type="submit" class="btn text-dark"
                                            style="background-color: rgb(91, 230, 56);">
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
                        <div class="modal-content rounded-0" style="background-color: rgb(89, 145, 248)">
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
                                            <select class="form-select rounded-0 border-dark shadow " id="traintype"
                                                name="trainType" required>
                                                <option value="" disabled selected>Select train type</option>
                                                <option value="Purple Line">Purple Line</option>
                                                <option value="Green Line">Green Line</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <label for="fromDay" class="form-label text-dark">From Day</label>
                                            <select name="fromDay" id="fromDay"
                                                class="form-select  rounded-0 shadow border-dark">
                                                <option selected disabled>Select Starting Day</option>
                                                <option value="monday">Monday</option>
                                                <option value="tuesday">Tuesday</option>
                                                <option value="wednesday">Wednesday</option>
                                                <option value="thursday">Thursday</option>
                                                <option value="friday">Friday</option>
                                                <option value="saturday">Saturday</option>
                                                <option value="sunday">Sunday</option>
                                            </select>
                                        </div>

                                        <div class="col-md-6">
                                            <label for="toDay" class="form-label text-dark">To Day</label>
                                            <select name="toDay" id="toDay"
                                                class="form-select  rounded-0 shadow border-dark">
                                                <option selected disabled>Select Ending Day</option>
                                                <option value="monday">Monday</option>
                                                <option value="tuesday">Tuesday</option>
                                                <option value="wednesday">Wednesday</option>
                                                <option value="thursday">Thursday</option>
                                                <option value="friday">Friday</option>
                                                <option value="saturday">Saturday</option>
                                                <option value="sunday">Sunday</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">Source</label>
                                            <select id="sourceId" class="form-select rounded-0 shadow border-dark"
                                                name="source">
                                                <option value="" disabled selected>Select Source</option>
                                                <c:forEach var="station" items="${stationDetailsDtoList}">
                                                    <option name="source" value="${station.stationName}">
                                                        ${station.stationName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">Destination</label>
                                            <select id="destinationId" class="form-select rounded-0 shadow border-dark"
                                                name="destination">
                                                <option value="" disabled selected>Select Destination</option>
                                                <c:forEach var="station" items="${stationDetailsDtoList}">
                                                    <option name="destination" value="${station.stationName}">
                                                        ${station.stationName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <label class="form-label text-dark">Source Time</label>
                                            <input type="time" class="form-control  rounded-0 shadow border-dark"
                                                id="sourceTime" name="sourceTime" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label text-dark ">Destination Time</label>
                                            <input type="time" class="form-control  rounded-0 shadow border-dark"
                                                id="destinationTime" name="destinationTime" required>
                                        </div>
                                    </div>

                                    <div class="modal-footer rounded-bottom">
                                        <button type="button" class="btn btn-outline-light text-light"
                                            style="background-color: rgb(8, 10, 3);" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <button type="submit" class="btn text-dark"
                                            style="background-color: rgb(91, 230, 56);">
                                            Save changes
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>



                <!-- image enlarge card -->
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

                                        <!-- <a href="editProfile?emailId=${details.emailId}" class="btn btn-primary">Edit Profile</a> -->
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
                <div class="container position-relative mt-5 text-center">
                    <h3 class="text-light justify-content-center">${TimeDetailsMsg}</h3>
                </div>
                <div class="container position-relative mt-5 text-center">
                    <h3 class="text-light justify-content-center">${PriceMsg}</h3>
                </div>
                
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