<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Practica #2 {CRUD}</title>

    <!-- Bootstrap core CSS -->
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.js" integrity="sha256-BTlTdQO9/fascB1drekrDVkaKd9PkwBymMlHOiG+qLI=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>

    <link rel="stylesheet" href="styles.css">


</head>

<body>

<!-- Start your project here-->
<head>
    <!--Navbar -->
    <nav class="mb-1 navbar navbar-expand-lg navbar-dark danger-color lighten-1">
        <a class="navbar-brand" href="#"><i class="fab fa-accusoft"></i> CRUD</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
                aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">

            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item avatar">
                    <a class="nav-link p-0" href="#">
                        <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="rounded-circle z-depth-0"
                             alt="avatar image" height="35"><span>  Bienvenido! ${usuario.user}</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <!--/.Navbar -->
</head>

<main>
    <!--INSERT-->
    <h3 class="head-titles-2">Registrar nuevo estudiante:</h3>
    <script>

    </script>


    <form action="/crud" method="POST" name="insertStudent" onsubmit="">
        <div class="row">

            <div class="col-md-1"></div>

            <div class="col-md-2">
                <!-- Material input -->
                <div class="md-form">
                    <i class="fas fa-id-badge prefix"></i>
                    <input type="number" id="id_student" name="id_student" class="form-control" placeholder="Matricula:" >
                    <span class="error" style="color: red; display: none">* Solo digitos del (0 - 9)</span>

                </div>
                <!-- Material input -->

            </div>
            <div class="col-md-2">
                <!-- Material input -->
                <div class="md-form">
                    <i class="fas fa-signature prefix"></i>
                    <input type="text" id="named" name="name" class="form-control" placeholder="Nombre:"  >
                    <span class="error-name" style="color: red; display: none">* Solo Letras</span>

                </div>
                <!-- Material input -->
            </div>
            <div class="col-md-2">
                <!-- Material input -->
                <div class="md-form">
                    <i class="fas fa-signature prefix"></i>
                    <input type="text" id="last_name" name="last_name"  class="form-control" placeholder="Apellido:"  required>
                    <span class="error-name" style="color: red; display: none">* Solo Letras</span>

                </div>
                <!-- Material input -->
            </div>
            <div class="col-md-2">
                <!-- Material input -->
                <div class="md-form">
                    <i class="fas fa-phone prefix"></i>
                    <input type="number" id="phone" name="phone" class="form-control" placeholder="Telefono:" required>
                    <span class="error" style="color: red; display: none">* Solo digitos del (0 - 9)</span>

                </div>
                <!-- Material input -->
            </div>


            <div class="col-md-3">
                <div class="md-form">
                <button type="submit" class="btn btn-danger btn-rounded">Registrar</button>
                </div>
            </div>

        </div>
    </form>
    <!--INSERT-->
    <hr>
    <h3 class="head-titles">Listado de estudiantes:</h3>

    <div class="row">
        <div class="col-md-1">

        </div>
        <div class="col-md-10">
            <table class="table table-bordered table-striped " id="tabledit">
                <thead>
                <tr>
                    <th scope="col" class="th-sm">ID</th>
                    <th scope="col" class="th-lg">Matricula</th>
                    <th scope="col" class="th-lg">Nombre</th>
                    <th scope="col" class="th-lg">Apellido</th>
                    <th scope="col" class="th-lg">Telefono</th>
                    <th scope="col" class="th-sm">Editar/Borrar</th>
                </tr>
                </thead>
                <tbody>

                <#list student as k>
                    <tr>
                        <td scope="row">${k.id}</td>
                        <td scope="row">${k.student_id}</td>
                        <td>${k.name}</td>
                        <td>${k.last_name}</td>
                        <td>${k.tel}</td>
                        <td class="modal_form"></td>
                    </tr>

                </#list>

                </tbody>
            </table>
        </div>
        <div class="col-md-1">

        </div>
    </div>
</main>

<!-- Start your project here-->

<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="Myjquery.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
</body>

</html>