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

            <body class="bg-dark text-light">

                <!-- Full Mask Overlay -->
                <!-- <div class="position-absolute top-0 start-0 w-100 h-100" style="background-color: rgba(0, 0, 0, 0.7);">
                </div> -->

                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <div>
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
                        </div>
                        <div>
                            <span class="navbar-text h5 text-dark  ">Government Metro Registratioin </span>
                        </div>
                        <div>
                            <li class="btn btn-primary btn-outline-dark">
                                <a class="nav-link text-light " href="getIndex">Home</a>
                            </li>
                        </div>
                    </div>
                </nav>
                <br>

                <div class="container position-relative d-flex justify-content-end align-items-center flex-grow-1"
                    style="z-index: 1; max-width: 450px;">
                    <div class="card  rounded-3 text-light"
                        style="background-color: rgb(36, 113, 139); padding: 20px 15px;">
                        <h5 class="text-center text-dark justify-content-end ">${registrationMsg}</h5>
                        <div class="card-body p-3">
                            <h2 class="text-center mb-3">User Registration Form</h2>
                            <form action="onSaveRegistration" method="post" onblur="form()">
                                <span id="formMessage"></span>

                                <input type="text" class="form-control" id="id" placeholder="Enter your id" name="id"
                                    hidden>

                                <!-- Row 1: First Name, Last Name -->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <label class="form-label">First Name</label>
                                        <input type="text" id="fName" name="firstName" placeholder="Enter First Name"
                                            class="form-control" onblur="fNameValidation()" required>
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
                                            <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                                value="Female" required>
                                            <label class="form-check-label" for="femaleGender">Female</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                                value="Male">
                                            <label class="form-check-label" for="maleGender">Male</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="otherGender"
                                                value="Other">
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



                                <!-- Row 5: Password, Confirm Password -->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <label class="form-label">Password</label>
                                        <input type="password" id="pass" name="password" placeholder="Enter password"
                                            class="form-control" onblur="checkPassword()" required>
                                        <span id="password"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label">Confirm Password</label>
                                        <input type="password" id="cpass" placeholder="Confirm password"
                                            class="form-control" onblur="confirmPassword()" required>
                                        <span id="cPassword"></span>
                                    </div>
                                </div>



                                <!-- Submit Button -->
                                <div class="text-center mt-3">
                                    <button id="button" type="submit" class="btn btn-primary w-100">Submit</button>
                                </div>

                            </form>

                        </div>
                        <div class="mt-2 text-center text-light justify-content-center   ">
                            Already have an account? <a href="LoginByEmail.jsp" class="text-warning mx-2">Login</a>
                        </div>
                    </div>

                </div>

                <br>
                <footer class=" text-white py-3" style="background-color: rgb(133, 128, 139);">
                    <div class="container text-center">
                        <p class="mb-1">&copy; 2024 Metro Service. All rights reserved.</p>
                        <nav>
                            <a href="PrivacyPolicy.jsp" class="text-white me-3">Privacy Policy</a>
                            <a href="TermsOfService.jsp" class="text-white me-3">Terms of Service</a>
                            <a href="Support.jsp" class="text-white">Support</a>
                        </nav>
                    </div>
                </footer>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <script>
                    function fNameValidation() {
                        var names = document.getElementById("fName").value;

                        if (names.trim() !== '' && names.length > 3 && names.length <= 25 && !/\d/.test(names)) {
                            document.getElementById("firstName").innerHTML = "";
                        } else if (/\d/.test(names)) {
                            document.getElementById("firstName").innerHTML = "<span style='color:yellow;'>First Name cannot contain numbers.</span>";
                        } else {
                            document.getElementById("firstName").innerHTML = "<span style='color:yellow;'>Must be between 4 & 25 characters.</span>";
                        }
                        checkForm();
                    }

                    function lNameValidation() {
                        var names = document.getElementById("lName").value;

                        if (names.trim() !== '' && names.length > 0 && names.length <= 25 && !/\d/.test(names)) {
                            document.getElementById("lastName").innerHTML = "";
                        } else if (/\d/.test(names) || names.length < 1) {
                            document.getElementById("lastName").innerHTML = "<span style='color:yellow;'>Last name cannot be a number and must be atleast 1.</span>";
                        }
                        checkForm();
                    }


                    function checkPassword() {
                        var pass = document.getElementById("pass").value;
                        var button = document.getElementById("button");
                        var password = document.getElementById("password");

                        if (pass.trim !== '' && pass.length >= 8 && pass.length <= 12) {
                            password.innerHTML = "";

                        } else {
                            password.innerHTML = "<span> password must have atleast 8 letters </span>";

                        }
                        checkForm();
                    }

                    function confirmPassword() {
                        const pass = document.getElementById("pass").value;
                        const cpass = document.getElementById("cpass").value;
                        const button = document.getElementById("button");
                        const confirmPasswordMessage = document.getElementById("cPassword");
                        confirmPasswordMessage.innerHTML = "";
                        if (cpass.trim() === '') {
                            confirmPasswordMessage.innerHTML = "<span style='color:yellow;'>Password cannot be empty.</span>";
                            return;
                        }
                        if (cpass.length < 8 || cpass.length > 12) {
                            confirmPasswordMessage.innerHTML = "<span style='color:yellow;'>Password must be between 8 and 12 characters.</span>";
                            return;
                        }
                        if (pass === cpass) {
                            confirmPasswordMessage.innerHTML = "";

                        } else {
                            confirmPasswordMessage.innerHTML = "<span style='color:yellow;'>Passwords do not match.</span>";

                        }
                        checkForm();
                    }
                    const checkMobileNumber = async () => {
                        var mNumber = document.getElementById("mNumber").value;
                        var button = document.getElementById("button");
                        var mobileNumber = document.getElementById("mobileNumber");

                        if (!(mNumber.length == 10)) {
                            mobileNumber.innerHTML = "<span style='color:yellow'>Mobile Number length should be 10</span>";
                            button.setAttribute("disabled", "disabled");
                        } else {
                            var response = await axios('http://localhost:8083/metro-application/isMobileNumberExists?mobileNumber=' + mNumber);
                            if (response.data === "Mobile Number Exists") {
                                mobileNumber.innerHTML = "<span style='color:yellow'>Mobile Number Exists</span>";
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
                        var response = await axios('http://localhost:8083/metro-application/isEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            document.getElementById("emailId").innerHTML = "<span style='color:yellow'>Email exists</span>";
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