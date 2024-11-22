<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <title>Government Metro Service Login</title>

    <style>
        body {
            background: url('https://storage.googleapis.com/a1aa/image/foGcaH7sbv3DYySXTehv3radBvXXUqWN0decWrrP2Y2WD8mnA.jpg');
            background-size: auto;
            background-color: rgb(208, 208, 248);
        }

        .navbar {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        h2,
        h3,
        h5 {
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
        }
    </style>
</head>

<body class="bg background-color">
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(127, 134, 138);">
        <div class="container-fluid d-flex justify-content-between align-items-center">
            <div>
                <a class="navbar-brand" href="getIndex">
                    <img src="https://www.x-workz.in/Logo.png" alt="xworkz logo" style="max-height: 50px;">
                </a>
            </div>
            <div>
                <span class="navbar-text h5 text-dark">Namma Metro</span>
            </div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary btn-outline-dark text-light px-4" href="getIndex">Back</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div>
        <div class="container my-5 py-5">
            <div class="row justify-content-center g-4">
                <!-- Admin Login Card -->
                <div class="col-md-5">
                    <div class="card border-warning shadow-sm rounded-0 bg-light text-dark">
                        <div class="card-body">
                            <h2 class="card-title text-center  mb-4">Admin Login</h2>
                            <form action="getAdminLogin" method="get">
                                <button type="submit" class="btn btn-primary w-100">LOGIN</button>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- Divider -->
                <div class="col-md-2 d-flex align-items-center justify-content-center">
                    <h3 class="text-light ">OR</h3>
                </div>

                <!-- User Login Card -->
                <div class="col-md-5">
                    <div class="card border-primary shadow-sm rounded-0 bg-light text-dark">
                        <div class="card-body">
                            <h2 class="card-title text-center mb-4">User Login</h2>
                            <form action="getUserLogin" method="get">
                                <button type="submit" class="btn btn-primary w-100">LOGIN</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <footer class="footer fixed-bottom py-3" style="background-color: rgb(87, 93, 95);">
        <div class="text-white text-center">
            <nav>
                <a href="#" class="mx-2 text-white">Privacy Policy</a>
                <a href="#" class="mx-2 text-white">Terms of Service</a>
            </nav>
        </div>
    </footer>

</body>

</html>