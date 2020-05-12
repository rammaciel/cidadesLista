<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Criar Cidade</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Nova Cidade</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="inserir_cidade" method="post">
            <!-- area de campos do form -->
            <div class="form-group col-md-6">
                    <label for="nome">Nome da cidade</label>
                    <form:errors path="cidade.nome" cssStyle="color:red"/>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome da cidade">
            </div>
            <div class="form-group col-md-3">
                    <label for="nome">Latitude</label>
                    <form:errors path="cidade.latitude" cssStyle="color:red"/>
                    <input type="text" class="form-control" name="latitude" id="latitude" required maxlength="100" placeholder="latitude">
            </div>
            <div class="form-group col-md-3">
                    <label for="nome">Longitude</label>
                    <form:errors path="cidade.longitude" cssStyle="color:red"/>
                    <input type="text" class="form-control" name="longitude" id="longitude" required maxlength="100" placeholder="longitude">
            </div>
            
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="criar">Salvar</button>
                    <a href="inicio" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>