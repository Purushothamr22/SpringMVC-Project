<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Namma Metro</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .navbar {
            background-color: #090a0c;
        }

        .navbar-text {
            color: white;
        }

        .card {
            background-color: #ffffff;
            border: 1px solid rgba(0, 0, 0, 0.1);
        }

        .btn-primary {
            background-color: #0d6efd;
            border-color: #0d6efd;
        }

        .btn-primary:hover {
            background-color: #084298;
        }

        footer {
            background-color: #080a0e;
            color: white;
        }

        label {
            font-weight: 600;
        }

        span#email {
            font-size: 0.9rem;
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid d-flex justify-content-between align-items-center">
            <div>
                <a class="navbar-brand" href="getIndex">
                    <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                </a>
            </div>
            <div>
                <span class="navbar-text h5">Government Metro</span>
            </div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-light" href="getAdminLogin">Back</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Content -->
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-sm p-5 mx-auto">
                    <h5 class="text-success">${otpSuccessMessage}</h5>
                    <h5 class="text-danger">${otpErrorMessage}</h5>

                    <!-- Get OTP Form -->
                    <form action="getOtpDetails" method="get">
                        <div class="mb-4">
                            <label for="emailId" class="form-label">Email ID</label>
                            <input type="email" id="emailId" name="emailId" placeholder="Enter your email ID"
                                class="form-control" onblur="checkEmail()" value="${emailDto.emailId}" required>
                            <span id="email"></span>
                        </div>
                        <div class="d-grid col-4 mx-auto">
                            <button type="submit" class="btn btn-primary" id="getOtp">Get OTP</button>
                        </div>
                    </form>

                    <!-- Verify OTP Form -->
                    <form action="verifyOtp" method="post" class="mt-4">
                        <div class="mb-3">
                            <input type="email" class="form-control" placeholder="Enter your email" name="emailId"
                                value="${emailDto.emailId}" hidden>
                            <label for="inputPassword5" class="form-label">Enter OTP</label>
                            <input type="password" class="form-control" placeholder="Enter your OTP" name="otp"
                                required>
                        </div>
                        <div class="text-center">
                            <div class="col-12">
                                <button type="submit" class="btn btn-success">Verify OTP</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer text-white text-center py-3">
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
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <script>
        const checkEmail = async () => {
            var email = document.getElementById("emailId").value;
            var response = await axios('http://localhost:8083/metro-application/isEmailExists?emailId=' + email);
            if (response.data === "Email Exists") {
                document.getElementById("email").innerHTML = "";
                document.getElementById("getOtp").removeAttribute("disabled");
            } else if (response.data === "Email Accepted") {
                document.getElementById("email").innerHTML = "<span style ='color:orange'>Email does not exist</span>";
                document.getElementById("getOtp").setAttribute("disabled", "");
            }
        }
    </script>
</body>

</html>