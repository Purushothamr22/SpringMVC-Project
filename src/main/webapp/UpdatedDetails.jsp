<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Details</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
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

                                    <!-- Dropdown Menu -->
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

                <div class="input-group mb-3" style="width: 25%;">
                    <form action="getByStationName">
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon1">Button</button>
                        <input type="text" class="form-control" placeholder="Enter Station Name " name="stationName">
                        <input type="text" class="form-control" placeholder="" name="emailId" value="${metroDto.emailId}" hidden >
                    </form>
                </div>


                <h3 class="text justify-content-center text-danger shadow-sm">${DisplayMsg}</h3>

                <!-- Main Content -->
                <div class="container my-5 py-4">
                    <h2 class="text-center text-primary fw-bold mb-4">Metro Information</h2>
                
                    <div class="table-responsive shadow-sm rounded">
                        <table class="table table-hover table-bordered table-striped align-middle">
                            <thead class="bg-primary text-white">
                                <tr>
                                    <th class="text-center">ID</th>
                                    <th class="text-center">Train Type</th>
                                    <th class="text-center">Station Number</th>
                                    <th class="text-center">Source</th>
                                    <th class="text-center">Destination</th>
                                    <th class="text-center">From Day</th>
                                    <th class="text-center">To Day</th>
                                    <th class="text-center">Source Time</th>
                                    <th class="text-center">Destination Time</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Edit/Update</th>
                                </tr>
                            </thead>
                            <tbody id="detail">
                                <c:forEach var="trainTimeDetails" items="${stationDetailsDtoList.trainTimeDetails}">
                                    <tr>
                                        <td class="text-center">${stationDetailsDtoList.stationId}</td>
                                        <td class="text-center">${stationDetailsDtoList.stationType}</td>
                                        <td class="text-center">${stationDetailsDtoList.stationNumber}</td>
                                        <td>${trainTimeDetails.source}</td>
                                        <td>${trainTimeDetails.destination}</td>
                                        <td>${trainTimeDetails.fromDay}</td>
                                        <td>${trainTimeDetails.toDay}</td>
                                        <td>${trainTimeDetails.sourceTime}</td>
                                        <td>${trainTimeDetails.destinationTime}</td>
                                        <td>${trainTimeDetails.price}</td>
                                        <td class="text-center">
                                            <a href="getEditMetroDetails?source=${trainTimeDetails.source}&destination=${trainTimeDetails.destination}" 
                                                class="btn btn-outline-primary btn-sm">
                                                <i class="bi bi-pencil-square"></i> Edit
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                

                </div>

                <!-- Footer -->
                <footer class="bg-dark text-light py-4 text-center ">
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

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


            </body>

            </html>