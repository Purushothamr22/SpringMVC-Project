<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Reset Password</title>
</head>

<style>
    i {
        cursor: pointer;
    }
</style>

<body class="bg-light">

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(12, 13, 14);">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://www.x-workz.in/Logo.png" alt="Company Logo" style="max-height: 40px;">
            </a>
        </div>
    </nav>

    <div class="row justify-content-center py-0 my-5">
        <div class="col-12 col-md-6">
            <div class="card p-5 mx-auto rounded-0 shadow-lg hover-shadow-lg border-dark" style="background-color: rgba(231, 234, 248, 0.7);">
                <div class="card-header text-center bg-transparent border-0">
                    <h3 class="text-dark">Reset Your Password</h3>
                </div>
                <form action="resetPassword" method="post">

                    <!-- Current Password -->
                    <div class="mb-4">
                        <label for="currentPassword" class="form-label">Current Password</label>
                        <input type="password" id="currentPassword" name="currentPassword" placeholder="Enter Current Password" class="form-control shadow-sm border border-dark">
                        <span id="currentPasswordError" class="text-danger"></span>
                    </div>

                    <!-- New Password -->
                    <div class="mb-4">
                        <label for="newPassword" class="form-label">New Password</label>
                        <input type="password" id="newPassword" name="newPassword" placeholder="Enter New Password" class="form-control shadow-sm border border-dark">
                        <span id="newPasswordError" class="text-danger"></span>
                    </div>

                    <!-- Confirm New Password -->
                    <div class="mb-4">
                        <label for="confirmPassword" class="form-label">Confirm New Password</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm New Password" class="form-control shadow-sm border border-dark">
                        <span id="confirmPasswordError" class="text-danger"></span>
                    </div>

                    <!-- Submit Button -->
                    <div class="text-center mt-4">
                        <button type="submit" class="btn btn-primary w-100 py-2 shadow">Update Password</button>
                    </div>

                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-light py-4 p-3   text-center ">
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
        document.getElementById("newPassword").addEventListener("input", validatePasswords);
        document.getElementById("confirmPassword").addEventListener("input", validatePasswords);

        function validatePasswords() {
            const newPassword = document.getElementById("newPassword").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const confirmPasswordError = document.getElementById("confirmPasswordError");

            if (newPassword !== confirmPassword) {
                confirmPasswordError.textContent = "Passwords do not match.";
            } else {
                confirmPasswordError.textContent = "";
            }
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>