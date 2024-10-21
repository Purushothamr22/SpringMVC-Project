<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <title>User Details Table</title>
            </head>

            <body>
                <!-- Navigation Bar -->
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
                    <div class="container-fluid d-flex justify-content-between align-items-center">
                        <!-- Brand/Logo -->
                        <div class="d-flex align-items-center">
                            <a class="navbar-brand text-white" href="#">
                                <img src="https://www.x-workz.in/Logo.png" alt="Logo" class="img-fluid "
                                    style="max-height: 50px;">
                            </a>

                        </div>
                        <h4 class="mb-0 ms-2 text-white">User Management Portal</h4>
                        <!-- Dropdown Menu -->
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



                <!-- Displaying the message -->
                <div class="container mt-4">
                    <h2 class="text-center">${message}</h2>
                </div>

                <!-- User Details Table -->
                <div class="container mt-4">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>User Name</th>
                                    <th>Password</th>
                                    <th>Email ID</th>
                                    <th>Mobile Number</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${users}" var="dto">
                                    <tr>
                                        <td>${dto.id}</td>
                                        <td>${dto.userName}</td>
                                        <td>${dto.password}</td>
                                        <td>${dto.emailId}</td>
                                        <td>${dto.mobileNumber}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <form action="onFindByUserName" method="post">
                    <div class="container mt-4">
                        <div class="row justify-content-between">
                            <div class="card shadow-sm" style="max-width: 300px; border-color: aqua;">
                                <div class="card-body">
                                    <div class="mb-3">
                                        <label for="userName" class="form-label text-dark">User Name</label>
                                        <input type="text" id="userName" name="userName"
                                            placeholder="Enter your user name" class="form-control"
                                            value="${dto.userName}">
                                    </div>
                                    <button type="submit" class="btn btn-primary w-100">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- Footer -->
                <footer class="bg-dark text-white py-3 fixed-bottom">
                    <div class="container text-center">
                        <p class="mb-0">User Management Portal © 2024</p>
                    </div>
                </footer>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>