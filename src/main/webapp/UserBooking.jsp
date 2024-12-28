<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <%@ page isELIgnored="false" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Metro Home Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

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
                                                        href="editUserProfile?emailId=${verifyUserOtpDto.emailId}">Profile</a></li>
                                                <li><a class="dropdown-item" href="getLogout?emailId=${verifyUserOtpDto.emailId}">Log out</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div>

    <!-- Profile Image Modal -->
    <div class="modal fade" id="profileImageModal" tabindex="-1" aria-labelledby="profileImageModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">${verifyUserOtpDto.firstName}'s Profile</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <img src="getImage/${verifyUserOtpDto.userImage}" class="img-fluid rounded-circle mb-3"
                        alt="User Image">
                    <h5>${verifyUserOtpDto.firstName}</h5>
                </div>
            </div>
        </div>
    </div>

    <!-- Booking Section -->
    <section class="container my-5 py-4 p-5">
        <div class="card mx-auto shadow p-4" style="max-width: 600px;">
            <h3 class="text-center mb-4">Book Your Ticket</h3>
            <form id="stationForm">
                <input type="hidden" id="userId" name="userLoginId" value="${verifyUserOtpDto.userRegistrationId}">
                <input type="hidden" id="email" name="emailId" value="${verifyUserOtpDto.emailId}">

                <div class="mb-3">
                    <select id="sourceId" class="form-select" name="source">
                        <option value="" disabled selected>Select Source</option>
                        <c:forEach var="station" items="${stationDetailsDtoList}">
                            <option value="${station.stationName}">${station.stationName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <select id="destinationId" class="form-select" name="destination" ">
                        <option value="" disabled selected>Select Destination</option>
                        <c:forEach var="station" items="${stationDetailsDtoList}">
                            <option value="${station.stationName}">${station.stationName}</option>
                        </c:forEach>
                    </select>
                    <span id="des" class="text-danger small"></span>
                </div>
                <div class="form-check mb-3 text-center">

                        <label class="form-check-label " for="agreeTerms">
                            Generate Price !!!!!!!!!!
                        </label>
                        <input class="form-check-input border-success " type="checkbox" onclick="checkPrice() ">
                    </div>

                <div class="text-center mb-3">
                    <h4 id="price" class="text-primary"></h4>
                </div>

                <button type="button" id="tokenId" class="btn btn-dark w-100" onclick="getToken()">Book Ticket</button>
                <div id="TicketMsg" class="text-center mt-3"></div>
            </form>
        </div>
    </section>

    <!-- Footer Section -->
    <footer class="text-light py-4  p-3 text-center " style="background-color: #08090a;">
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

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        var emailId = document.getElementById("email").value;
        console.log("email is ============= " + emailId);
        const checkPrice = async () => {
            var sourceId = document.getElementById("sourceId").value;
            var destinationId = document.getElementById("destinationId").value;
            if (sourceId && destinationId) {
                tokenId.removeAttribute("disabled");
                if (sourceId === destinationId &&  destinationId  === sourceId) {
                    document.getElementById("des").innerHTML = "<span style='color:red'><i>source and destination cannot be same </i> </span>";
                    document.getElementById("price").textContent = "Amount is:  not found";
                     tokenId.setAttribute("disabled","true");
                }
                else {
                    tokenId.removeAttribute("disabled");
                    document.getElementById("des").innerHTML ="";
                    const response = await axios('http://localhost:8083/metro-application/isPriceExists?source=' + sourceId + '&destination=' + destinationId);

                    if (response.data) {
                        var price = response.data;
                        document.getElementById("price").textContent = "Amount is :-  " + price;
                    } else {
                        document.getElementById("price").textContent = "Amount is:  not found";
                    }
                }

            } else {
                tokenId.setAttribute("disabled", '')
            }
        }

        const getToken = async () => {
            var sourceId = document.getElementById("sourceId").value;
            var destinationId = document.getElementById("destinationId").value;
            var userId = document.getElementById("userId").value;
            if (sourceId && destinationId) {
                const responseT = await axios('http://localhost:8083/metro-application/generateToken');
                console.log("Ticket generation response  is ++++++++ "+responseT.data);
                if (responseT.data) {
                    console.log("Ticket generation response  is ++++++++ "+responseT.data);
                    document.getElementById("TicketMsg").innerHTML = "<span style='color : green'>Ticket Booking Successful . Have a Safe Journey</span>";
                    const responseS = await axios.post('http://localhost:8083/metro-application/saveTicketDetails?source=' + sourceId + '&destination=' + destinationId + '&userLoginId=' + userId + '&tokenNumber=' + responseT.data);
                }
            }else{
                document.getElementById("TicketMsg").innerHTML ="<span style='color : red'>Please Enter Correct Data</span>";
            }

        }
    </script>
</body>

</html>