<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar CidadeResourcess</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>

        <body>
            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir CidadeResources</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este cidade?
                        </div>
                        <div class="modal-footer">
                            <form action="excluir_cidade" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal -->
            <!-- Barra superior com os menus de navegação -->
			<c:import url="Menu.jsp"/>
            <!-- Container Principal -->
            <div id="main" class="container">
                <form action="buscar_cidades" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Cidades</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="chave" class="form-control" id="search" type="text" placeholder="Pesquisar cidades (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
				                <button class="btn btn-primary" type="submit" name="acao" value="listar">
				                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="novo_cidade" class="btn btn-primary pull-right h2">Nova Cidade</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>nome</th>
                                    <th>latitude</th>
                                    <th>longitude</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="cidade" items="${lista}">
                                       <tr>
                                   
                                            <td>
                                               ${cidade.id }
                                            </td>
                                            <td>
                                                ${cidade.nome }
                                            </td>
                                           <td>
                                                ${cidade.latitude }
                                            </td>
                                            <td>
                                                ${cidade.longitude }
                                            </td>
                                           
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="visualizar_cidade?id=${cidade.id}">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="alterar_cidade?id=${cidade.id}">Editar</a>
                                                <button id="btn${cidade.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cidade="${cidade.id }">Excluir</button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('cidade');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>