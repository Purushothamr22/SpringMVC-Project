<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            </head>

            <body class="bg-light text-dark">

                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(8, 9, 10);">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="Company Logo" style="max-height: 40px;">
                            </a>

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
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="getBookingPage?emailId=${verifyUserOtpDto.emailId}">Book
                                            Ticket</a>
                                    </li>
                                    <li class="nav-item mx-3">
                                        <a class="nav-link btn btn-primary text-light"
                                            href="viewBookingHistory?userLoginId=${verifyUserOtpDto.userRegistrationId}">Booking
                                            History</a>
                                    </li>
                                    <!-- Dropdown Menu -->
                                    <li class="nav-item dropdown mx-3">
                                        <a class="nav-link dropdown-toggle btn btn-primary text-light" href="#"
                                            id="userDropdown" role="button" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                            ${verifyUserOtpDto.firstName}
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                            <li><a class="dropdown-item"
                                                    href="editUserProfile?emailId=${verifyUserOtpDto.emailId}">Profile</a>
                                            </li>
                                            <li><a class="dropdown-item"
                                                    href="getLogout?emailId=${verifyUserOtpDto.emailId}">Log out</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <!-- image enlarge card -->
                <div class="modal fade" id="profileImageModal" tabindex="-1" aria-labelledby="profileImageModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-sm  modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="profileImageModalLabel">${verifyUserOtpDto.firstName}'s
                                    Profile</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="card">
                                    <img src="getImage/${verifyUserOtpDto.userImage}" class="card-img-top"
                                        alt="User Image">
                                    <div class="card-body text-center">
                                        <h5 class="card-title">${verifyUserOtpDto.firstName}</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Search by token  -->
                <div class="input-group d-flex align-items-center justify-content-start py-4 mx-3"
                    style="max-width: 25%;">
                    <form action="getHistoryById" class="d-flex w-100">
                        <input type="text" class="form-control border-dark rounded-0 me-2"
                            placeholder="Enter Token Number" name="tokenNumber">

                        <input type="text" name="userLoginId" value="${verifyUserOtpDto.userRegistrationId}" hidden>

                        <!-- Search Button -->
                        <button class="btn btn-primary btn-outline-secondary text-dark px-4" type="submit"
                            id="button-addon1"
                            >Search</button>
                    </form>
                </div>





                <!-- displaying Booking Details  -->
                <div class="container my-5 py-4 p-3">
                    <h2 class="text-center mb-4">Booking Information</h2>

                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-dark table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <th>Token Number </th>
                                    <th>Source </th>
                                    <th>Destination</th>
                                    <th>Source Time</th>
                                    <th>Destination Time</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody id="detail">

                                    <tr>
                                        <td>${booking.tokenNumber}</td>
                                        <td>${booking.source}</th>
                                        <td>${booking.destination}</th>
                                        <td>${booking.sourceTime}</th>
                                        <td>${booking.destinationTime}</th>
                                        <td>${booking.price}</th>
                                    </tr>

                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- footer  -->
                <footer class="bg-dark text-light py-4 p-3   text-center ">
                    <div class="container-fluid">
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
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


            </body>