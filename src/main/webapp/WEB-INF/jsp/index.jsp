<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
    		<div class="row">
    		
		<div class="col-md-12" style="font-size:20px;margin-top: 50px; text-align:center;" >
			1. Listar todas as cidades.<br>
			2. Listar todas as cidades cujo nome começa com uma letra específica.<br>
			3. Obter uma cidade por sua latitude e longitude.<br>
			4. Cadastrar novas cidades.
       </div>
 
       
       </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>