<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <title>Government Metro Service Login</title>
            </head>
            <style>
                i {
                    cursor: pointer;
                }
            </style>

            <body class="bg-light">

                <div>
                    <nav class="navbar navbar-expand-lg navbar-dark vw-100" style="background-color: rgb(13, 16, 19);">
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


                <div class="row justify-content-center py-3 my-5 mb-4">
                    <div class="  col-12 col-md-6 "> <!-- Increased card size -->
                        <div class="card p-5 mx-auto  rounded-0 shadow-lg hover-shadow-lg border-dark"
                            style="background-color: rgba(231, 234, 248, 0.7);">

                            <div class="card-header text-center bg-transparent border-0">
                                <h2 class="text-dark">User Details</h2>
                            </div>
                            <h4 class="text-center text-bold mt-3 mb-3 " style="color: red;">${UserUpdateMsg}</h4>

                            <div class="mb-4 text-center">
                                <img src="getImage/${verifyUserOtpDto.userImage}" alt="Profile Image"
                                    class="img-thumbnail rounded-circle shadow-lg border  border-warning"
                                    style="width: 180px; height: 180px;">
                            </div>

                            <form action="updateUserProfile" method="post" enctype="multipart/form-data">
                                <input type="number" name="userRegistrationId"
                                    value="${verifyUserOtpDto.userRegistrationId}" hidden>

                                <!-- Row 1: First Name, Last Name -->
                                <div class="row g-3 gx-5 mb-4">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">First Name</label>
                                        <input type="text" id="fName" name="firstName" placeholder="Enter First Name"
                                            class="form-control shadow-sm border border-dark"
                                            value="${verifyUserOtpDto.firstName}" onblur="fNameValidation()">
                                        <span id="firstName" class="text-danger"></span>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Last Name</label>
                                        <input type="text" id="lName" name="lastName" placeholder="Enter Last Name"
                                            value="${verifyUserOtpDto.lastName}"
                                            class="form-control shadow-sm border border-dark"
                                            onblur="lNameValidation()">
                                        <span id="lastName" class="text-danger"></span>
                                    </div>
                                </div>

                                <!-- Row 2: Birth Date, Email ID -->
                                <div class="row g-3 gx-5 mb-4">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Birth Date:</label>
                                        <input type="date" id="birthDate" name="birthdayDate"
                                            class="form-control shadow-sm border border-dark"
                                            value="${verifyUserOtpDto.birthdayDate}">
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Email ID</label>
                                        <input type="email" id="eId" name="emailId" placeholder="Enter Email Id"
                                            value="${verifyUserOtpDto.emailId}"
                                            class="form-control shadow-sm border border-dark" onblur="checkEmail()">
                                        <span id="emailId" class="text-danger"></span>
                                    </div>
                                </div>

                                <!-- Row 3: Mobile Number,Gender -->
                                <div class="row g-3 gx-5 mb-4">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Mobile Number</label>
                                        <input type="tel" id="mNumber" name="mobileNumber"
                                            placeholder="Enter Mobile Number" value="${verifyUserOtpDto.mobileNumber}"
                                            class="form-control shadow-sm border border-dark"
                                            onblur="checkMobileNumber()">
                                        <span id="mobileNumber" class="text-danger"></span>
                                    </div>

                                    <div class="col-12 col-md-6">
                                        <label class="form-label">gender </label>
                                        <input type="text" id="gen" name="gender" placeholder=" Enter gender"
                                            value="${verifyUserOtpDto.gender}"
                                            class="form-control shadow-sm border border-dark">
                                        <span id="gender" class="text-danger"></span>
                                    </div>

                                </div>
                                <!-- Row 4: File  -->
                                <div class="row g-3 gx-5 mb-4">
                                    <div class="col-12">
                                        <label class="form-label">Upload Profile Image</label>
                                        <input type="file" id="file" name="file"
                                            class="form-control shadow-sm border border-dark" />
                                    </div>
                                </div>

                                <!-- Submit Button -->
                                <div class="text-center mt-4">
                                    <button id="button" type="submit" class="btn btn-primary w-100 py-2 shadow">Update
                                        Profile</button>
                                </div>
                            </form>



                            </form>
                        </div>



                    </div>
                </div>



                <!-- Footer -->
                <footer class="  text-light py-4 p-3  mt-4 text-center vw-100 " style="background-color: rgb(6, 8, 8);">
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

                <script>
                    function fNameValidation() {
                        var names = document.getElementById("fName").value;
                        console.log(names);
                        var button = document.getElementById("button");
                        if (names.trim() !== '' && names.length > 3 && names.length <= 25 && !/\d/.test(names)) {
                            document.getElementById("firstName").innerHTML = "";
                            button.removeAttribute("disabled");
                        } else if (/\d/.test(names)) {
                            document.getElementById("firstName").innerHTML = "<span style='color:yellow;'>firstName cannot contain numbers.</span>";
                            button.setAttribute("disabled", "");
                        } else {
                            document.getElementById("firstName").innerHTML = "<span style='color:yellow;'>Must be between 4 & 25 characters.</span>";
                            button.setAttribute("disabled", "");
                        }
                    }

                    function lNameValidation() {
                        var names = document.getElementById("lName").value;
                        console.log(names)
                        var button = document.getElementById("button");
                        if (names.trim() !== '' && names.length > 0 && names.length <= 25 && !/\d/.test(names)) {
                            document.getElementById("lastName").innerHTML = "";
                            button.removeAttribute("Disabled");
                        } else if (/\d/.test(names) || names.length < 1) {
                            document.getElementById("lastName").innerHTML = "<span style='color:yellow;'>Last name cannot be a number and must be atleast 1.</span>";
                            button.setAttribute("disabled", "");
                            return;
                        }

                    }



                    const checkMobileNumber = async () => {
                        var mNumber = document.getElementById("mNumber").value;
                        var button = document.getElementById("button");
                        var mobileNumber = document.getElementById("mobileNumber");
                        if (mNumber.length < 10 || mNumber.length > 10) {
                            mobileNumber.innerHTML = "<span style='color:yellow'> Mobile Number length should be 10</span>";
                            button.removeAttribute("disabled");
                        } else {
                            var response = await axios('http://localhost:8083/metro-application/isMobileNoExists?mobileNumber=' + mNumber);
                            if (response.data === "Mobile Number Exists") {
                                mobileNumber.innerHTML = "<span style='color:yellow'> Mobile Number Exists</span>";
                                button.removeAttribute("disabled");
                            }
                            if (response.data === "Mobile Number Accepted") {
                                mobileNumber.innerHTML = "";
                                button.setAttribute("disabled", "");
                            }
                        }
                    }

                    const checkEmail = async () => {
                        var email = document.getElementById("eId").value;
                        var button = document.getElementById("button");
                        var response = await axios('http://localhost:8083/metro-application/isUserEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            document.getElementById("emailId").innerHTML = "<span style ='color:yellow'> Email exists </span>";
                            button.setAttribute("disabled", "");

                        } else if (response.data === "Email Does not exists") {
                            document.getElementById("emailId").innerHTML = "";
                            button.removeAttribute("disabled");
                        }

                    }
                </script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
                </script>
                <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
            </body>

            </html>