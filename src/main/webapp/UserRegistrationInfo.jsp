<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="ISO-8859-1">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <title>Registration Page</title>
            </head>

            <body class="text-light" style="background-color: rgb(173, 187, 187);">

                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <div>
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
                        </div>
                        <div>
                            <span class="navbar-text h5 text-dark">Government Metro Registration</span>
                        </div>
                        <div>
                            <li class="btn btn-primary btn-outline-dark">
                                <a class="nav-link text-light" href="getIndex">Home</a>
                            </li>
                        </div>
                    </div>
                </nav>
                <br>

                <div class="container d-flex justify-content-center">
                    <!-- <div class="row w-100"> -->

                    <!-- Image Section -->
                    <!-- <div class="col-md-6 py-5 mx-0  ">
                            <div id="imageCarousel" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="https://www.prestigesouthernstar.info/images/prestige/metro-bangalore.webp"
                                            class="d-block w-100" alt="Registration image 1"
                                            style="object-fit: cover; height: 50%;">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="https://png.pngtree.com/thumb_back/fh260/background/20230928/pngtree-a-green-and-white-metro-train-pull-into-a-station-image_13357538.jpg"
                                            class="d-block w-100" alt="Registration image 2"
                                            style="object-fit: cover; height: 50%;">
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#imageCarousel"
                                    data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#imageCarousel"
                                    data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div> -->


                    <!-- Registration Card Section -->
                    <div class="col-md-6 d-flex align-items-center py-5">
                        <div class="card rounded-0 text-dark w-100"
                            style="background-color: rgb(232, 245, 245); padding: 10px 15px;">
                            <h5 class="text-center " style="color: #ff5722;">${userInfoMsg}</h5>
                            <div class="card-body p-3">
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

                                    <!-- Row 5: Password, Confirm Password
                                    <div class="row mb-2">
                                        <div class="col-md-6">
                                            <label class="form-label">Password</label>
                                            <input type="password" id="pass" name="password"
                                                placeholder="Enter password" class="form-control"
                                                onblur="checkPassword()" required>
                                            <span id="password"></span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Confirm Password</label>
                                            <input type="password" id="cpass" placeholder="Confirm password"
                                                class="form-control" onblur="confirmPassword()" required>
                                            <span id="cPassword"></span>
                                        </div>
                                    </div> -->

                                    <!-- Submit Button -->
                                    <div class="text-center mt-3">
                                        <button id="button" type="submit" class="btn btn-primary w-100">Submit</button>
                                    </div>

                                </form>

                            </div>
                            <div class="mt-2 text-center text-dark justify-content-center">
                                Already have an account? <a href="LoginByEmail.jsp" class="text-warning mx-2">Login</a>
                            </div>
                        </div>

                    </div>
                </div>




                <footer class=" text-white py-3" style="background-color: rgb(133, 128, 139); margin: 0;">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <p class="mb-1">&copy; 2024 Metro Service. All rights reserved.</p>
                        <nav class="d-flex">
                            <a href="PrivacyPolicy.jsp" class="text-white me-3">Privacy Policy</a>
                            <a href="TermsOfService.jsp" class="text-white me-3">Terms of Service</a>
                            <a href="Support.jsp" class="text-white">Support</a>
                        </nav>
                    </div>
                </footer>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script>
                    function fNameValidation() {
                        var fname = document.getElementById("fName").value
                        if (fname.trim() !== '' && fname.length > 3 && fname.length <= 25 && !/\d/.test(fname)) {
                            document.getElementById("firstName").innerHTML = "";
                        } else if (/\d/.test(fname)) {
                            document.getElementById("firstName").innerHTML = "<span style='color:red;'>First Name cannot contain numbers.</span>";
                        } else {
                            document.getElementById("firstName").innerHTML = "<span style='color:red;'>Must be between 4 & 25 characters.</span>";
                        }
                        checkForm();
                    }
                    function lNameValidation(){
                        var lname = document.getElementById("lName").value;
                        
                        if (names.trim() !== '' && names.length > 0 && names.length <= 25 && !/\d/.test(names)) {
                            document.getElementById("lastName").innerHTML = "";
                        } else if (/\d/.test(names) || names.length < 1) {
                            document.getElementById("lastName").innerHTML = "<span style='color:red;'>Last name cannot be a number and must be atleast 1.</span>";
                        }
                        checkForm();
                    }

                   
                    const checkMobileNumber = async () => {
                        var mNumber = document.getElementById("mNumber").value;
                        var button = document.getElementById("button");
                        var mobileNumber = document.getElementById("mobileNumber");

                        if (!(mNumber.length == 10)) {
                            mobileNumber.innerHTML = "<span style='color:red'>Mobile Number length should be 10</span>";
                            button.setAttribute("disabled", "disabled");
                        } else {
                            var response = await axios('http://localhost:8083/metro-application/isMobileNumberExists?mobileNumber=' + mNumber);
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
                        var email = document.getElementById("eId").value;
                        var button = document.getElementById("button");
                        var response = await axios('http://localhost:8083/metro-application/isUserEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            document.getElementById("emailId").innerHTML = "<span style='color:red'>Email exists</span>";
                            button.setAttribute("disabled", "disabled");
                        } else if (response.data === "Email Accepted") {
                            document.getElementById("emailId").innerHTML = "";
                            checkForm();
                        }
                    }

                    function checkForm() {
                        var names = document.getElementById("fName").value;
                        var lnames = document.getElementById("lName").value;
                        var pass = document.getElementById("pass").value;
                        const cpass = document.getElementById("cpass").value;
                        var mNumber = document.getElementById("mNumber").value;
                        var email = document.getElementById("eId").value;
                        var button = document.getElementById("button");


                        if ((names.trim() !== '' && names.length > 3 && names.length <= 25 && !/\d/.test(names)) &&
                            (lnames.trim() !== '' && lnames.length > 0 && lnames.length <= 25 && !/\d/.test(lnames)) &&
                            (pass.trim() !== '' && pass.length >= 8 && pass.length <= 12 && pass === cpass) &&
                            (mNumber.length == 10) &&
                            (email.trim() !== "")
                        ) {
                            button.removeAttribute("disabled")
                        } else {
                            document.getElementById("formMessage").innerHTML = "";
                            button.setAttribute("disabled", "");
                        }
                    }
                </script>
                <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

            </body>

            </html>