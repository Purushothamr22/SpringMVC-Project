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

                <!-- Navigation Bar -->
                <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(15, 15, 15);">
                    <div class="container-fluid">
                        <div>
                            <a class="navbar-brand" href="getIndex">
                                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                            </a>
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

                                <li class="nav-item">
                                    <a class="nav-link btn btn-primary btn-outline-dark text-light"
                                        href="getAdminPageByMail?emailId=${userDto.emailId}">Back</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <h3 class="justify-content-center" style="color: green;">${msg}</h3>
                <h3 class="justify-content-center" style="color: #ff5722">${errMsg}</h3>

                <div class="row justify-content-center py-0 my-5">
                    <div class="  col-12 col-md-6 "> <!-- Increased card size -->
                        <div class="card p-5 mx-auto  rounded-0 shadow-lg hover-shadow-lg border-dark"
                            style="background-color: rgba(231, 234, 248, 0.7);">

                            <div class="card-header text-center bg-transparent border-0">
                                <h3 class="text-dark">User Details</h3>
                            </div>

                            <div class="mb-4 text-center">
                                <img src="getImage/${userDto.userImage}" alt="Profile Image"
                                    class="img-thumbnail rounded-circle shadow-lg border  border-warning"
                                    style="width: 180px; height: 180px;">
                            </div>

                            <form action="updateDetails" method="post" enctype="multipart/form-data">
                                <input type="number" name="id" value="${userDto.id}" hidden>

                                <!-- Row 1: First Name, Last Name -->
                                <div class="row g-3 gx-5 mb-4">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">First Name</label>
                                        <input type="text" id="fName" name="firstName" placeholder="Enter First Name"
                                            class="form-control shadow-sm border border-dark"
                                            value="${userDto.firstName}" onblur="fNameValidation()">
                                        <span id="firstName" class="text-danger"></span>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Last Name</label>
                                        <input type="text" id="lName" name="lastName" placeholder="Enter Last Name"
                                            value="${userDto.lastName}"
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
                                            value="${userDto.birthdayDate}">
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Email ID</label>
                                        <input type="email" id="eId" name="emailId" placeholder="Enter Email Id"
                                            value="${userDto.emailId}"
                                            class="form-control shadow-sm border border-dark" onblur="checkEmail()">
                                        <span id="emailId" class="text-danger"></span>
                                    </div>
                                </div>

                                <!-- Row 3: Mobile Number,Gender -->
                                <div class="row g-3 gx-5 mb-4">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Mobile Number</label>
                                        <input type="tel" id="mNumber" name="mobileNumber"
                                            placeholder="Enter Mobile Number" value="${userDto.mobileNumber}"
                                            class="form-control shadow-sm border border-dark"
                                            onblur="checkMobileNumber()">
                                        <span id="mobileNumber" class="text-danger"></span>
                                    </div>

                                     <div class="col-12 col-md-6">
                                                                            <label class="form-label">gender </label>
                                                                            <input type="text" id="gen" name="gender" placeholder=" Enter gender"
                                                                                value="${userDto.gender}"
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
                                </div>


                                <!-- Submit Button -->
                                <div class="text-center mt-4">
                                    <button id="button" type="submit" class="btn btn-primary w-100 py-2 shadow">Update
                                        Profile</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>



                <br>
                <br>
                <!-- Footer -->
                <footer class=" text-white text-center py-3 " style="background-color: rgb(153, 166, 172);">
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
            </body>

            </html>