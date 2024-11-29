<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html>
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            </head>

            <body class="bg-light text-dark">

                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="Company Logo" style="max-height: 40px;">
                            </a>
                            <h1 class="h3 text-white mx-2">User Page</h1>

                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                                aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav ms-auto text-center align-items-center">

                                    <li class="nav-item mx-auto">
                                        <img src="getImage/${verifyUserOtpDto.userImage}" alt="User Image"
                                            class="rounded-circle border border-warning shadow-sm"
                                            style="width: 50px; height: 50px; cursor: pointer;" data-bs-toggle="modal"
                                            data-bs-target="#profileImageModal">
                                    </li>
                            </div>
                        </div>
                    </nav>
                </div>

                <div class="container mt-5">
                    <h3 class="text-center mb-4">Train Time Details</h3>
                    <table class="table table-striped table-bordered">
                        <thead class="table-dark">
                            <tr>
                                <th>From Day</th>
                                <th>To Day</th>
                                <th>Source</th>
                                <th>Destination</th>
                                <th>Train Type</th>
                                <th>Source Time</th>
                                <th>Destination Time</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                                <tr>
                                    <td>${trainTimeInfo.fromDay}</td>
                                    <td>${trainTimeInfo.toDay}</td>
                                    <td>${trainTimeInfo.source}</td>
                                    <td>${trainTimeInfo.destination}</td>
                                    <td>${trainTimeInfo.trainType}</td>
                                    <td>${trainTimeInfo.sourceTime}</td>
                                    <td>${trainTimeInfo.destinationTime}</td>
                                    <td>${trainTimeInfo.priceDetails.price}</td>
                                </tr>
                        </tbody>
                    </table>
                </div>



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
                                </body>

           </html>
