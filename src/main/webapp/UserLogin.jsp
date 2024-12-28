<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&family=Montserrat:wght@300;400&display=swap" rel="stylesheet">
    <title>Government Metro Service Login</title>
    <style>
        body {
            background-image: url('https://www.googleapis.com/download/storage/v1/b/kaggle-user-content/o/inbox%2F14601120%2F818e48829e36eb2016662b44dfc55937%2Fbanner04.jpg?generation=1691950460844130&alt=media');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            font-family: 'Roboto', sans-serif;
            color: #fff;
        }

        /* Custom Metro Card */
        .metro-card {
            background-color: rgba(0, 0, 0, 0.7);
            color: white;
            padding: 50px;
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.5);
            text-align: center;
            margin-top: 60px;
        }

        .metro-card h2 {
            font-family: 'Montserrat', sans-serif;
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.7);
            font-size: 2.5rem;
        }

        .metro-card p {
            font-size: 1.2rem;
            margin-top: 20px;
            line-height: 1.6;
        }

        /* Custom Button */
        .btn-custom {
            background-color: #ff6f61;
            color: white;
            border: none;
            border-radius: 50px;
            padding: 12px 30px;
            text-transform: uppercase;
            transition: background-color 0.3s ease-in-out;
        }

        .btn-custom:hover {
            background-color: #ff5a4e;
        }

        /* Form Inputs */
        .form-control {
            border-radius: 50px;
            padding: 12px 20px;
            border: 2px solid #ccc;
            transition: border 0.3s ease;
        }

        .form-control:focus {
            border-color: #ff6f61;
            box-shadow: 0 0 10px rgba(255, 111, 97, 0.5);
        }

        /* Navbar */
        .navbar {
            background-color: rgba(0, 0, 0, 0.8);
        }

        .navbar-brand img {
            max-height: 50px;
        }

        .navbar-nav .nav-link {
            color: white !important;
        }

        .navbar-nav .nav-link:hover {
            background-color: #ff6f61;
            border-radius: 30px;
        }

        /* Footer */
        footer {
            background-color: rgba(0, 0, 0, 0.8);
            color: white;
            padding: 30px 0;
            text-align: center;
        }

        footer a {
            color: #ff6f61;
            text-decoration: none;
        }

        footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid d-flex justify-content-between align-items-center">
            <a class="navbar-brand" href="getIndex">
                <img src="https://www.x-workz.in/Logo.png" alt="Metro Logo">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link btn btn-light text-dark" href="getLoginPage">Back</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Namma Metro Corporation Custom Card -->
    <div class="container">
        <div class="metro-card">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQw-aNLlRb7L5prZL2byTNKoT2nH20mBHiN9A&s" alt="Namma Metro Logo" class="mb-3" style="max-width: 300px; max-height: 150px;">
            <h2>Welcome to Namma Metro Corporation</h2>
            <p>Experience a smooth and seamless metro service designed for the citizens of Bangalore. We are committed to providing safe, clean, and efficient transportation for all.</p>
        </div>
    </div>

    <!-- Login Form -->
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-5">
                <div class="card p-4 shadow-lg rounded">
                    <h2 class="text-center mb-4">User Login</h2>
                    <form action="getUserOtpDetails" method="get">
                        <div class="mb-4">
                            <label for="userEmail" class="form-label">Email ID</label>
                            <input type="email" id="userEmail" name="emailId" class="form-control shadow-sm" placeholder="Enter your email ID" value="${userDto.emailId}" required onblur="checkUserEmail()">
                            <span id="ueId" class="text-danger small"></span>
                        </div>
                        <div class="d-grid">
                            <button type="submit" id="button" class="btn btn-custom rounded-pill">✈️ Get OTP</button>
                        </div>
                    </form>
                    <div  class="text-center text-success mt-3"> ${OtpMsg}</div>
                    <form action="verifyUserOtp" method="post" class="mt-4">
                        <div class="mb-3">
                            <label for="otp" class="form-label">Enter OTP</label>
                            <input type="hidden" name="emailId" value="${userDto.emailId}">
                            <input type="password" id="otp" name="otp" class="form-control shadow-sm" placeholder="Enter your OTP" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success rounded-pill">Login</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <div>
            <nav>
                <a href="#" class="mx-3">Privacy Policy</a>
                <a href="#" class="mx-3">Terms of Service</a>
            </nav>
        </div>
        <p class="mb-0">&copy; 2024 Government Metro Service. All rights reserved.</p>
    </footer>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        const checkUserEmail = async () => {
            const email = document.getElementById("userEmail").value;
            const button = document.getElementById("button");
            const ueId = document.getElementById("ueId");
            ueId.innerHTML = "";

            if (email.length < 5) {
                ueId.innerHTML = "<span class='text-danger'>Invalid email</span>";
                button.setAttribute("disabled", "true");
                return;
            }
             console.log("email  is ================== "+email);
            const response = await axios('http://localhost:8083/metro-application/isUserEmailExists?emailId='+email);
            console.log("email  is ================== "+email);
            console.log("email response is ================== "+response.data);
            if (response.data === "Email Exists") {
                console.log("email response if exists  is ================== "+response.data);
                ueId.innerHTML = "";
                button.removeAttribute("disabled");
            } else {
                console.log("email response if not exists  is ================== "+response.data);
                ueId.innerHTML = "<span class='text-danger'>Email does not exist</span>";
                button.setAttribute("disabled", "true");
            }
        };
    </script>
</body>

</html>
