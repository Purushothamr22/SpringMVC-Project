<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <title>Government Metro Service Login</title>
    <style>
        body {
            background: linear-gradient(145deg, #e0f7fa, #f4f7fa);
            font-family: 'Roboto', sans-serif;
            color: #2c3e50;
            margin: 0;
        }

        .navbar {
            background-color: #000000;
        }

        .navbar-brand img {
            max-height: 50px;
        }

        .navbar-text {
            color: #fff;
        }

        .btn-primary {
            background-color: #000000;
            border-color: #2f4d55cc;
        }

        .btn-primary:hover {
            background-color: #3f19c9;
            border-color: #1a33a5;
        }

        .footer {
            background-color: #000000;
            color: white;
            text-align: center;
            padding: 30px 0;
        }

        .footer a {
            color: #ddd;
            text-decoration: none;
        }

        .divider {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .divider h3 {
            color: #00796b;
        }

        .section-header {
            font-size: 1.75rem;
            font-weight: 600;
            color: #00796b;
            justify-content: center;
            text-align-last: auto;
        }

        .section-content {
            font-size: 1.1rem;
            color: #5d6d7e;
        }

        .card-header {
            background-color: #1a0101ef;
            color: #fff;
            font-weight: bold;
        }
    </style>
</head>

<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark ">
        <div class="container-fluid">
            <a class="navbar-brand" href="getIndex">
                <img src="https://www.x-workz.in/Logo.png" alt="Metro Logo" style="max-height: 50px;">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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

    <!-- Main Content -->

    <!-- Admin Login Card -->
    <section class="container px-4 mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5 mb-4">
                <div class="card shadow-lg rounded-3 border-0">
                    <div class="card-header text-center">Admin Login</div>
                    <div class="card-body mt-4 my-3">
                        <form action="getAdminLogin" method="get">
                            <button type="submit" class="btn btn-primary w-100">Login as Admin</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-5 mb-4">
                <div class="card shadow-lg rounded-3 border-0">
                    <div class="card-header text-center">User Login</div>
                    <div class="card-body mt-4 my-3">
                        <form action="getUserLogin" method="get">
                            <button type="submit" class="btn btn-primary w-100">Login as User</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>




    <!-- Footer -->
    <footer class="footer fixed-bottom py-3">
        <div>
            <h2 class="section-header text-light">Contact Us</h2>
            <p class="section-content text-light">For more information, complaints, or inquiries, feel free to reach
                out to
                our customer service team at:</p>
            <p class="section-content text-light"><strong>Email:</strong> support@namma.metro.in</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>