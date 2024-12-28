<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="ISO-8859-1">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
                rel="stylesheet">
                <title>Registration Page</title>
            </head>

            <body class="text-light" style="background-color: rgb(173, 187, 187);">

                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="getIndex">
                            <img src="https://www.x-workz.in/Logo.png" alt="Metro Logo" style="max-height: 50px;">
                        </a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item me-2">
                                    <a class="nav-link btn btn-primary text-light" href="getUserRegistrationInfo">
                                        <i class="bi bi-person-plus-fill me-1"></i> New User Registration
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary text-light" href="getLoginPage">
                                        <i class="bi bi-box-arrow-in-right me-1"></i> Login
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <br>

                <div class="container d-flex justify-content-center">



                    <!-- Registration Card Section -->
                    <div class="col-md-6 d-flex align-items-center py-5">
                        <div class="card rounded-0 text-dark w-100"
                            style="background-color: rgb(232, 245, 245); padding: 10px 15px;">
                            <div class="card-body p-3">
                                <h4 class="text-center text-bold mt-3 mb-3 " style="color: green;">${userInfoMsg}</h4>
                                <h4 class="text-center text-bold mt-3 mb-3 " style="color: red;">${userErrorMsg}</h4>
                                <h2 class="text-center mb-3">User Registration Form</h2>
                                <form action="saveUserInfo" method="post" onblur="form()">
                                    <span id="formMessage"></span>

                                    <input type="text" class="form-control" id="id" placeholder="Enter your id"
                                        name="id" hidden>

                                    <!-- Row 1: First Name, Last Name -->
                                    <div class="row mb-2">
                                        <div class="col-md-6">
                                            <label class="form-label">First Name</label>
                                            <input type="text" id="fName" name="firstName"
                                                placeholder="Enter First Name" class="form-control"
                                                onblur="fNameValidation()" required>
                                            <span id="firstName"></span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Last Name</label>
                                            <input type="text" id="lName" name="lastName" placeholder="Enter Last Name"
                                                class="form-control" onblur="lNameValidation()" required>
                                            <span id="lastName"></span>
                                        </div>
                                    </div>

                                    <!-- Row 2: Birthday, Gender -->
                                    <div class="row mb-2">
                                        <div class="col-md-6">
                                            <label class="form-label">Birth Date:</label>
                                            <input type="date" id="birthDate" name="birthdayDate" class="form-control">

                                        </div>

                                        <div class="col-md-6">
                                            <label class="form-label d-block">Gender</label>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender"
                                                    id="femaleGender" value="Female" required>
                                                <label class="form-check-label" for="femaleGender">Female</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender"
                                                    id="maleGender" value="Male">
                                                <label class="form-check-label" for="maleGender">Male</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender"
                                                    id="otherGender" value="Other">
                                                <label class="form-check-label" for="otherGender">Other</label>
                                            </div>
                                            <span id="gender"></span>
                                        </div>
                                    </div>

                                    <!-- Row 3: Mobile Number, Email ID -->
                                    <div class="row mb-2">
                                        <div class="col-md-6">
                                            <label class="form-label">Email ID</label>
                                            <input type="email" id="eId" name="emailId" placeholder="Enter e-mail id"
                                                class="form-control" onblur="checkEmail()" required>
                                            <span id="emailId"></span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Mobile Number</label>
                                            <input type="tel" id="mNumber" name="mobileNumber"
                                                placeholder="Enter mobile number" class="form-control"
                                                onblur="checkMobileNumber()" required>
                                            <span id="mobileNumber"></span>
                                        </div>
                                    </div>

                                    <div class="text-bold fs-5">
                                        <input class="form-check-input border-dark " type="radio" name="flexRadioDefault" id="flexRadioDefault1" required> <u >Register Your Details</u> 
                                      </div>


                                    <!-- Submit Button -->
                                    <div class="text-center mt-3">
                                        <button id="button" type="submit" class="btn btn-primary w-100">Register </button>
                                    </div>

                                </form>

                            </div>
                            <div class="mt-2 text-center text-dark justify-content-center">
                                Already have an account? <a href="getUserLogin" class="text-warning mx-2">Login</a>
                            </div>
                        </div>

                    </div>
                </div>




                <footer class="py-4 text-center bg-dark">
                    <div class="container">
                        <p class="section-content text-light">For more information, complaints, or inquiries, feel free
                            to reach out to
                            our customer service team at:</p>
                        <p class="section-content text-light"><strong>Email:</strong> support@namma.metro.in</p>
                        <p class="mb-0">&copy; 2024 Namma Metro. All rights reserved.</p>
                        <nav class="mt-2">
                            <a href="#">Privacy Policy</a> |
                            <a href="#">Terms of Service</a> |
                            <a href="#">Contact Us</a>
                        </nav>
                        <div class="mt-3">
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
                <script>
                    function fNameValidation() {
                        let fname = document.getElementById("fName").value;
                        if (fname.trim() !== '' && fname.length > 3 && fname.length <= 25 && !/\d/.test(fname)) {
                            document.getElementById("firstName").innerHTML = "";
                        } else if (/\d/.test(fname)) {
                            document.getElementById("firstName").innerHTML = "<span style='color:red;'>First Name cannot contain numbers.</span>";
                        } else {
                            document.getElementById("firstName").innerHTML = "<span style='color:red;'>Must be between 4 & 25 characters.</span>";
                        }
                        checkForm();
                    }

                    function lNameValidation() {
                        let lname = document.getElementById("lName").value;
                        if (lname.trim() !== '' && lname.length > 0 && lname.length <= 25 && !/\d/.test(lname)) {
                            document.getElementById("lastName").innerHTML = "";
                        } else if (/\d/.test(lname) || lname.length < 1) {
                            document.getElementById("lastName").innerHTML = "<span style='color:red;'>Last name cannot contain numbers and must be at least 1 character.</span>";
                        }
                        checkForm();
                    }



                    const checkMobileNumber = async () => {
                        let mNumber = document.getElementById("mNumber").value;
                        let button = document.getElementById("button");
                        let mobileNumber = document.getElementById("mobileNumber");

                        if (!(mNumber.length == 10)) {
                            mobileNumber.innerHTML = "<span style='color:red'>Mobile Number length should be 10</span>";
                            button.setAttribute("disabled", "disabled");
                        } else {
                            let response = await axios('http://localhost:8083/metro-application/isMobileNoExists?mobileNumber=' + mNumber);
                            if (response.data === "Mobile Number Exists") {
                                mobileNumber.innerHTML = "<span style='color:red'>Mobile Number Exists</span>";
                                button.setAttribute("disabled", "disabled");
                            } else if (response.data === "Mobile Number Accepted") {
                                mobileNumber.innerHTML = "";
                                checkForm();
                            }
                        }
                    }

                    const checkEmail = async () => {
                        let email = document.getElementById("eId").value;
                        let button = document.getElementById("button");
                        let response = await axios('http://localhost:8083/metro-application/isUserEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            document.getElementById("emailId").innerHTML = "<span style='color:red'>Email exists</span>";
                            button.setAttribute("disabled", "disabled");
                        } else if (response.data === "Email Accepted") {
                            document.getElementById("emailId").innerHTML = "";
                            checkForm();
                        }
                    }



                    function checkForm() {
                        let fname = document.getElementById("fName").value;
                        let lname = document.getElementById("lName").value;
                        let mNumber = document.getElementById("mNumber").value;
                        let email = document.getElementById("eId").value;
                        let button = document.getElementById("button");

                        if (
                            fname.trim() !== '' && fname.length > 3 && fname.length <= 25 && !/\d/.test(fname) &&
                            lname.trim() !== '' && lname.length > 0 && lname.length <= 25 && !/\d/.test(lname) &&
                            mNumber.length === 10 && !isNaN(mNumber) &&
                            email.trim() !== "" && email.includes('@') && email.includes('.')
                        ) {
                            button.removeAttribute("disabled");
                            document.getElementById("formMessage").innerHTML = "";
                        } else {
                            document.getElementById("formMessage").innerHTML = "<span style='color:red;'>   </span>";
                            button.setAttribute("disabled", "");
                        }
                    }


                </script>
                <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

            </body>

            </html>