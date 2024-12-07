<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Government Metro Service Login</title>
    <style>
        body {
            background: linear-gradient(145deg, #e0f7fa, #f4f7fa);
            font-family: 'Roboto', sans-serif;
            color: #2c3e50;
            margin: 0;
        }

        .navbar {
            background-color: #00796b;
        }

        .navbar-brand img {
            max-height: 50px;
        }

        .navbar-text {
            color: #fff;
        }

        .btn-primary {
            background-color: #00796b;
            border-color: #00796b;
        }

        .btn-primary:hover {
            background-color: #004d40;
            border-color: #004d40;
        }

        .footer {
            background-color: #004d40;
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

        /* Custom styles */
        .section-header {
            font-size: 1.75rem;
            font-weight: 600;
            color: #00796b;
        }

        .section-content {
            font-size: 1.1rem;
            color: #5d6d7e;
        }
    </style>
</head>

<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid d-flex justify-content-between align-items-center">
            <a class="navbar-brand" href="getIndex">
                <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link btn-primary btn-outline-light px-4" href="getIndex">Back</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container my-5 py-5">
        <div class="row justify-content-center g-4">
            <!-- Admin Login Card -->
            <div class="col-md-5">
                <div class="card shadow-lg rounded-3">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Admin Login</h2>
                        <form action="getAdminLogin" method="get">
                            <button type="submit" class="btn btn-primary w-100">Login as Admin</button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Divider -->
            <div class="col-md-2 divider">
                <h3>|||||</h3>
            </div>

            <!-- User Login Card -->
            <div class="col-md-5">
                <div class="card shadow-lg rounded-3">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">User Login</h2>
                        <form action="getUserLogin" method="get">
                            <button type="submit" class="btn btn-success w-100">Login as User</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Extra Sections -->
        <div class="row mt-5">
            <div class="col-md-6 py-5">
                <div class="card p-4 shadow-sm rounded-3">
                    <h3 class="section-header">How It Works</h3>
                    <p class="section-content">The Namma Metro service is designed to reduce traffic congestion and
                        provide a clean, safe, and fast mode of transportation across Bangalore. With multiple
                        routes connecting the city's key locations, you can rely on us for quick and efficient
                        travel.</p>
                </div>
            </div>

            <div class="col-md-6 py-5">
                <div class="card p-4 shadow-sm rounded-3">
                    <h3 class="section-header">Ticketing and Payment</h3>
                    <p class="section-content">You can buy tickets at any metro station or use the Namma Metro app
                        for quick and easy ticket purchasing. We also offer various passes for frequent travelers to
                        enjoy discounted rates and unlimited travel within specific zones.</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer py-3">
        <div>
            <h2 class="section-header text-light">Contact Us</h2>
            <p class="section-content text-light">For more information, complaints, or inquiries, feel free to reach out to
                our customer service team at:</p>
            <p class="section-content text-light"><strong>Email:</strong> support@namma.metro.in</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
