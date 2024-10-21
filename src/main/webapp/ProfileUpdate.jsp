<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <title>Government Metro Service Login</title>
            </head>

            <body class="bg-dark" >

                <!-- Navigation Bar -->
                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(95, 101, 104);">
                    <div class="container-fluid">
                        <div>
                            <a class="navbar-brand" href="#">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
                        </div>
                        <div>
                            <span class="navbar-text h5 text-dark">Profile Update</span>
                        </div>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav ms-auto">
                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary btn-outline-dark text-light"
                                        href="getIndex">Home</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="row justify-content-center py-5">
                    <div class="col-md-6 ">
                        <div class="card p-4 mx-auto " style="background-color: rgba(144, 177, 54, 0.7); width: 40vw;">
                            <form action="updateDetails" method="post" enctype="multipart/form-data">
                                <input type="number" name="id" value="${metroDto.id}" hidden>
                                <!-- Row 1: First Name, Last Name -->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <label class="form-label">First Name</label>
                                        <input type="text" id="fName" name="firstName" placeholder="Enter First Name"
                                            class="form-control" value="${metroDto.firstName}"
                                            onblur="fNameValidation()">
                                        <span id="firstName"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label">Last Name</label>
                                        <input type="text" id="lName" name="lastName" placeholder="Enter Last Name"
                                            value="${metroDto.lastName} " class="form-control"
                                            onblur="lNameValidation()">
                                        <span id="lastName"></span>
                                    </div>
                                </div>

                                <!-- Row 2: Birthday, Gender -->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <label class="form-label">Birth Date:</label>
                                        <input type="date" id="birthDate" name="birthdayDate"
                                            placeholder="Enter birth Date" value="${metroDto.birthdayDate}"
                                            class="form-control">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label d-block" for="gender">Gender</label>
                                        <input type="radio" id="male" name="gender" value="male"
                                            ${metroDto.gender=='male' ? 'checked' : '' }>
                                        <label for="male">Male</label>
                                        <input type="radio" id="female" name="gender" value="female"
                                            ${metroDto.gender=='female' ? 'checked' : '' }>
                                        <label for="female">Female</label>
                                        <input type="radio" id="other" name="gender" value="other"
                                            ${metroDto.gender=='other' ? 'checked' : '' }>
                                        <label for="other">Other</label>
                                    </div>
                                </div>


                                <!-- Row 3: Username, Email ID -->
                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <label class="form-label">User Name</label>
                                        <input type="text" id="uName" name="userName" placeholder="Enter User Name"
                                            value="${metroDto.userName}" class="form-control" onblur="checkUserName()">
                                        <span id="userName"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label">Email ID</label>
                                        <input type="email" id="eId" name="emailId" placeholder="Enter Email Id"
                                            value="${metroDto.emailId}" class="form-control" onblur="checkEmail()">
                                        <span id="emailId"></span>
                                    </div>
                                </div>

                                <div class="row mb-2">
                                    <div class="col-md-6">
                                        <label class="form-label">Mobile Number</label>
                                        <input type="tel" id="mNumber" name="mobileNumber"
                                            placeholder="Enter Mobile Number" value="${metroDto.mobileNumber}"
                                            class="form-control" onblur="checkMobileNumber()">
                                        <span id="mobileNumber"></span>
                                    </div>

                                    <div class="col-md-6">
                                        <label class="form-label">Password</label>
                                        <input type="password" id="pass" name="password" placeholder="Enter Password"
                                            value="${metroDto.password}" class="form-control" onblur="checkPassword()">
                                        <span id="password"></span>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <label class="form-label">Upload file </label>
                                        <input type="file" id="file" name="file" class="form-control" />
                                    </div>

                                    <div class="col-md-6">
                                        <input type="password" id="cpass" name="confirmPassword"
                                            value="${metroDto.password}" class="form-control" onblur="confirmPassword()"
                                            hidden>
                                        <span id="password"></span>
                                    </div>

                                    
                                </div>

                                <div class="text-center mt-3">
                                    <button id="button" type="submit" class="btn btn-primary w-100">Edit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <!-- Footer -->
                <footer class="text-white text-center py-3 " style="background-color: rgb(153, 166, 172);">
                    <div class="container">
                        <nav>
                            <a href="#" class="mx-2 text-white">Privacy Policy</a>
                            <a href="#" class="mx-2 text-white">Terms of Service</a>
                        </nav>
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
                            document.getElementById("firstName").innerHTML = "<span style='color:yellow;'>Username cannot contain numbers.</span>";
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

                    function checkUserName() {
                        var uName = document.getElementById("uName").value;
                        var button = document.getElementById("button");
                        var userName = document.getElementById("userName");
                        userName.innerHTML = "";



                        var firstChar = uName.charAt(0);
                        if (!((firstChar >= 'A' && firstChar <= 'Z') || (firstChar >= 'a' && firstChar <= 'z'))) {
                            userName.innerHTML = "<span style='color:yellow;'>Username must start with a letter.</span>";
                            button.setAttribute("disabled", "");
                            return;
                        }

                        if (uName.length < 4 || uName.length > 20) {
                            userName.innerHTML = "<span style='color:yellow;'>Username must be between 4 and 20 characters.</span>";
                            button.setAttribute("disabled", "");
                            return;
                        }

                        for (var i = 0; i < uName.length; i++) {
                            var char = uName.charAt(i);
                            if (!((char >= 'A' && char <= 'Z') || (char >= 'a' && char <= 'z') || (char >= '0' && char <= '9') || char === '_' || char === '-')) {
                                userName.innerHTML = "<span style='color:yellow;'>Username can only contain letters, numbers, underscores, and hyphens.</span>";
                                button.setAttribute("disabled", "");
                                return;
                            }

                        }
                        userName.innerHTML = "";
                        button.removeAttribute("disabled");
                    }

                    function checkPassword() {
                        var pass = document.getElementById("pass").value;
                        var button = document.getElementById("button");
                        var password = document.getElementById("password");

                        if (pass.trim !== '' && pass.length >= 8 && pass.length <= 12) {
                            password.innerHTML = "";
                            button.removeAttribute("disabled")
                        } else {
                            password.innerHTML = "<span> password must have atleast 8 letters </span>";
                            button.setAttribute("disabld", "");
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
                            var response = await axios('http://localhost:8083/metro-application/isMobileNumberExists?mobileNumber=' + mNumber);
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
                        var response = await axios('http://localhost:8083/metro-application/isEmailExists?emailId=' + email);
                        if (response.data === "Email Exists") {
                            document.getElementById("emailId").innerHTML = "<span style ='color:yellow'> Email exists </span>";
                            button.setAttribute("disabled", "");

                        } else if (response.data === "Email Accepted") {
                            document.getElementById("emailId").innerHTML = "";
                            button.removeAttribute("disabled");
                        }

                    }

                    document.addEventListener("DOMContentLoaded", function () {
                        const gender = "${metroDto.gender}";
                        document.getElementById(gender).checked = true;
                    });



                </script>
            </body>

            </html>