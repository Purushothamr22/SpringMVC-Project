<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Details</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            </head>

            <body class="bg-light">

                <!-- Navigation Bar -->
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="getIndex">
                            <img src="https://www.x-workz.in/Logo.png" alt="Logo" style="max-height: 40px;">
                        </a>
                        <h4 class="text-white ms-2 mb-0">Metro Management Portal</h4>

                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary text-white" href="getIndex">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary text-white"
                                        href="getAdminPageByMail?emailId=${metroDto.emailId}">back</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h3 class="text justify-content-center text-danger shadow-sm">${DisplayMsg}</h3>

                <!-- Main Content -->
                <div class="container my-5">
                    <h2 class="text-center mb-4">Metro Information</h2>

                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Train Type</th>
                                    <th>Station Number</th>
                                    <th>Station Name</th>
                                    <th>Source</th>
                                    <th>Destination</th>
                                    <th>From Day</th>
                                    <th>To Day</th>
                                    <th>Source Time</th>
                                    <th>Destination Time</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody id="detail">
                                <c:forEach var="metroInfo"  items="${stationDetailsDtoList}">
                                    <c:forEach var="train" items="${metroInfo.trainTimeDetails}">
                                        <tr>
                                            <td>${metroInfo.stationId}</td>
                                            <td>${metroInfo.stationType}</td>
                                            <td>${metroInfo.stationNumber}</td>
                                            <td>${metroInfo.stationName}</td>
                                            <td>${train.source}</td>
                                            <td>${train.destination}</td>
                                            <td>${train.fromDay}</td>
                                            <td>${train.toDay}</td>
                                            <td>${train.sourceTime}</td>
                                            <td>${train.destinationTime}</td>
                                            <td>${train.price}</td>
                                        </tr>
                                    </c:forEach>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                </div>

                <!-- Footer -->
                <footer class="footer fixed-bottom bg-dark text-white py-3">
                    <div class="container text-center">
                        <p class="mb-0">Metro Management Portal &copy; 2024</p>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script>
                    var list = document.getElementById("detail");  
                    console.log("List of the data is:", list);
                
                    // Example: Get all rows inside the table body
                    var rows = list.getElementsByTagName("tr");
                    console.log("Number of rows:", rows.length);
                
                    // Log each row's content for debugging
                    Array.from(rows).forEach((row, index) => {
                        console.log(`Row ${index + 1}:`, row.innerText);
                    });
                </script>
                
            </body>

            </html>