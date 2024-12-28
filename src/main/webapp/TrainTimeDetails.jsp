<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <style>
                    .bg-gradient {
                        background: linear-gradient(to right, #4CAF50, #2E7D32);
                    }

                    .rounded-50 {
                        border-radius: 50%;
                    }
                </style>
            </head>

            <body class="bg-light text-dark">

                <!-- Navigation Bar -->
                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(5, 5, 5);">
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

                                    <li class="nav-item dropdown mx-3">
                                        <a class="nav-link dropdown-toggle btn btn-primary text-light" href="#"
                                            id="userDropdown" role="button" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                            ${details.firstName}
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                            <li><a class="dropdown-item"
                                                    href="editProfile?emailId=${details.emailId}">Profile Edit</a></li>
                                            <li><a class="dropdown-item" href="getLoginPage?emailId=${details.emailId}">Log out</a></li>
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



                <!-- Add Train Time Form -->
                <div class="container my-5">
                <div>
                <h3 class="text-center text-warning mt-2 my-2  ">${TimeDetailsMsg}</h3>
                </div>
                    <div class="row justify-content-center">
                        <div class="col-md-8">
                            <div class="card shadow rounded">
                                <div class="card-header bg-dark text-white text-center">
                                    <h3 class="mb-1 py-3">Add Train Time Details</h3>
                                </div>
                                <div class="card-body">
                                    <form action="addTrainTimeDetails" method="post">
                                        <input type="email" name="emailId" value="${details.emailId}" hidden>

                                        <!-- Train Type -->
                                        <div class="mb-3">
                                            <label class="form-label fw-bold">Train Type</label>
                                            <select class="form-select" name="trainType" required>
                                                <option value="" disabled selected>Select train type</option>
                                                <option value="Purple Line">Purple Line</option>
                                                <option value="Green Line">Green Line</option>
                                            </select>
                                        </div>

                                        <!-- From Day and To Day -->
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <label class="form-label fw-bold">From Day</label>
                                                <select name="fromDay" class="form-select">
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
                                                <label class="form-label fw-bold">To Day</label>
                                                <select name="toDay" class="form-select">
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

                                        <!-- Source and Destination -->
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <label class="form-label fw-bold">Source</label>
                                                <select class="form-select" id="source" name="source">
                                                    <option value="" disabled selected>Select Source</option>
                                                    <c:forEach var="station" items="${stationDetailsDtoList}">
                                                        <option value="${station.stationName}">${station.stationName}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-md-6">
                                                <label class="form-label fw-bold">Destination</label>
                                                <select class="form-select" id="destination" onblur="checkStations()"
                                                    name="destination">
                                                    <option value="" disabled selected>Select Destination</option>
                                                    <c:forEach var="station" items="${stationDetailsDtoList}">
                                                        <option value="${station.stationName}">${station.stationName}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                                <span id="des"></span>
                                            </div>
                                        </div>

                                        <!-- Source and Destination Time -->
                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <label class="form-label fw-bold">Source Time</label>
                                                <input type="time" class="form-control" name="sourceTime" required>
                                            </div>
                                            <div class="col-md-6">
                                                <label class="form-label fw-bold">Destination Time</label>
                                                <input type="time" class="form-control" name="destinationTime" required>
                                            </div>
                                        </div>

                                        <!-- Submit Button -->
                                        <div class="text-center">
                                            <button type="submit" id="button" class="btn btn-success px-4">Save Changes</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Footer -->
                <footer class="bg-dark text-light py-4 text-center">
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
                <script>
                   function checkStations() {
                       var source = document.getElementById("source").value;
                       var destination = document.getElementById("destination").value;
                       var des = document.getElementById("des");
                       var submitButton = document.getElementById("button"); // Select the submit button.

                       if (destination === source) {
                           des.innerHTML = "<span style='color: red'><i>Destination cannot be the same as Source</i></span>";
                           submitButton.setAttribute("disabled", "true"); // Disable the submit button.
                       } else {
                           des.innerHTML = ""; // Clear the error message.
                           submitButton.removeAttribute("disabled"); // Enable the submit button.
                       }
                   }

                </script>
            </body>

            </html>