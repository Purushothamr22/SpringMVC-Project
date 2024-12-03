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

                                    <!-- Dropdown Menu -->
                                    <li class="nav-item dropdown mx-3">
                                        <a class="nav-link dropdown-toggle btn btn-primary text-light" href="#"
                                            id="userDropdown" role="button" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                            ${verifyUserOtpDto.firstName}
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                            <li><a class="dropdown-item"
                                                    href="?emailId=${verifyUserOtpDto.emailId}">Profile</a></li>
                                            <li><a class="dropdown-item" href="getUserLogin">Log out</a></li>
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

                                        <!-- <a href="editProfile?emailId=${verifyUserOtpDto.emailId}" class="btn btn-primary">Edit Profile</a> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card container-fluid  p-3" style="width:50%; margin:6rem;">
                    <form id="stationForm">
                        <h3 class="text-dark justify-content-center py-3"> Want to book your ticket </h3>
                        <div class=" col-md-6 mb-3">
                            <input type="text" id="userId" class="form-select rounded-0 shadow border-warning"
                                name="userLoginId" value="${verifyUserOtpDto.userRegistrationId}" hidden>
                        </div>
                        <div class="row ">


                            <!-- Source Selection -->
                            <div class=" col-md-6 mb-3 ">
                                <select id="sourceId" class="form-select rounded-0 shadow border-warning" name="source">
                                    <option value="" disabled selected>Select Source</option>
                                    <c:forEach var="station" items="${stationDetailsDtoList}">
                                        <option value="${station.stationName}">${station.stationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- Destination Selection -->
                            <div class=" col-md-6 mb-3  ">
                                <select id="destinationId" class="form-select rounded-0 shadow border-warning"
                                    name="destination" onblur="checkPrice()">
                                    <option value="" disabled selected>Select Destination</option>
                                    <c:forEach var="station" items="${stationDetailsDtoList}">
                                        <option name="destination" value="${station.stationName}">${station.stationName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="row ">
                            <div class="col-md-4 mb-3 mx-3">
                                <h3 id="price" class="justify-content-center "></h3>
                            </div>
                        </div>
                        <div class="row">
                            <div>
                                <button type="button" id="tokenId"
                                    class="form-control btn btn-dark shadow rounded-0 btn-outline-info"
                                    onclick="getToken()">Book Ticket </button>
                            </div>
                        </div>
                    </form>


                </div>



                <!-- Footer Section -->
                <footer class=" text-white py-3 fixed-bottom" style="background-color: rgb(87, 93, 95);">
                    <div class="container text-center">
                        <p class="mb-1">&copy; 2024 Metro Service. All rights reserved.</p>
                        <nav>
                            <a href="PrivacyPolicy.jsp" class="text-white me-3">Privacy Policy</a>
                            <a href="TermsOfService.jsp" class="text-white me-3">Terms of Service</a>
                        </nav>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
                </script>
                <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


                <script>
                    const checkPrice = async () => {
                        var sourceId = document.getElementById("sourceId").value;
                        var destinationId = document.getElementById("destinationId").value;
                        console.log("source is  =============== " + sourceId);
                        console.log("destination  is  =============== " + destinationId);
                        if (sourceId && destinationId) {
                            tokenId.removeAttribute("disabled")
                            const response = await axios('http://localhost:8083/metro-application/isPriceExists?source=' + sourceId + '&destination=' + destinationId);

                            if (response.data) {
                                var price = response.data;
                                console.log("response price given is " + price);
                                document.getElementById("price").textContent = "Amount is :-  " + price;
                            } else {
                                document.getElementById("price").textContent = "Amount is:  not found";
                            }

                        }else{
                            tokenId.setAttribute("disabled",'')
                        }
                    }

                    const getToken = async () => {
                        var sourceId = document.getElementById("sourceId").value;
                        var destinationId = document.getElementById("destinationId").value;
                        var userId = document.getElementById("userId").value;
                        console.log("source is  =============== " + sourceId);
                        console.log("destination  is  =============== " + destinationId);
                        if (sourceId && destinationId) {
                            const responseT = await axios('http://localhost:8083/metro-application/generateToken');
                            console.log("generated token data  is ===================   "+responseT.data);
                            if (responseT.data) {
                                const responseS = await axios.post('http://localhost:8083/metro-application/saveTicketDetails?source=' + sourceId + '&destination=' + destinationId + '&userLoginId=' + userId+'&tokenNumber='+responseT.data);
                                console.log("save  response is " + responseS.data);
                            }

                        }
                    
                    }
                </script>
            </body>

            </html>